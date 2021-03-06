package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.eshop.connection.DBConnection;
import com.eshop.exceptions.ArticleException;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.interfaces.DAO;
import com.eshop.models.Article;
import com.eshop.models.Computer;

public class ComputerDAO implements DAO {
	
	Connection connection = DBConnection.getInstance().getConnection();

	
	@Override
	public Computer getArticleById(int computerId) throws SQLException, InvalidInputException {
		String query = "SELECT c.*, p.*, v.*, o.*, l.* FROM computer c "
				+ "JOIN processor_type p ON (c.processor_type_id = p.id) "
				+ "JOIN video_card_type v ON (c.video_card_type_id = v.id) "
				+ "JOIN operation_system o ON (c.operation_system_id = o.id) " + "JOIN label l ON (c.label_id = l.id) "
				+ "WHERE c.id LIKE '" + computerId + "';";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		Computer computer = null;
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");
			int ram = rs.getInt("ram");
			String processorType = rs.getString("processor_type");
			double processorSpeed = rs.getDouble("processor_speed");
			String videoCardType = rs.getString("video_card");
			int hdd = rs.getInt("hdd");
			String operationSystem = rs.getString("operation_system");
			int id = rs.getInt("id");
			computer = new Computer(model, label, ram, processorType, processorSpeed, videoCardType, hdd,
					operationSystem, price, image, id);
		}
		
		return computer;
	}

	
	@Override
	public Collection<Article> getArticleByLabel(String computerLabel) throws SQLException, InvalidInputException {
		List<Computer> computers = new ArrayList<Computer>();
		String query = "SELECT c.*, p.*, v.*, o.*, l.* FROM computer c "
				+ "JOIN processor_type p ON (c.processor_type_id = p.id) "
				+ "JOIN video_card_type v ON (c.video_card_type_id = v.id) "
				+ "JOIN operation_system o ON (c.operation_system_id = o.id) " + "JOIN label l ON (c.label_id = l.id) "
				+ "WHERE l.label LIKE '" + computerLabel + "';";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");

			int ram = rs.getInt("ram");
			String processorType = rs.getString("processor_type");
			double processorSpeed = rs.getDouble("processor_speed");
			String videoCardType = rs.getString("video_card");
			int hdd = rs.getInt("hdd");
			String operationSystem = rs.getString("operation_system");
			int id = rs.getInt("id");
			computers.add(new Computer(model, label, ram, processorType, processorSpeed, videoCardType, hdd,
					operationSystem, price, image, id));
		}
		return Collections.unmodifiableList(computers);
	}

	
	@Override
	public Collection<Article> showAll() throws SQLException, InvalidInputException, InvalidInputException {
		List<Computer> computers = new ArrayList<Computer>();
		String query = "SELECT c.*, p.*, v.*, o.*, l.* FROM computer c "
				+ "JOIN processor_type p ON (c.processor_type_id = p.id) "
				+ "JOIN video_card_type v ON (c.video_card_type_id = v.id) "
				+ "JOIN operation_system o ON (c.operation_system_id = o.id) " + "JOIN label l ON (c.label_id = l.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");

			int ram = rs.getInt("ram");
			String processorType = rs.getString("processor_type");
			double processorSpeed = rs.getDouble("processor_speed");
			String videoCardType = rs.getString("video_card");
			int hdd = rs.getInt("hdd");
			String operationSystem = rs.getString("operation_system");
			int id = rs.getInt("id");
			computers.add(new Computer(model, label, ram, processorType, processorSpeed, videoCardType, hdd,
					operationSystem, price, image, id));
		}
		return Collections.unmodifiableList(computers);
	}

	
	@Override
	public void deleteArticleById(int id) throws SQLException {
		String deleteQuery = "DELETE FROM computer WHERE id LIKE '" + id + "';";
		PreparedStatement deletePs = connection.prepareStatement(deleteQuery);
		deletePs.executeUpdate();

	}

	
	@Override
	public void insertArticle(Article computer) throws ArticleException {

		try {
			if (computer instanceof Computer) {
				
				
				connection.setAutoCommit(false);
				// getting processor id
				int processorId = getOrInsertProcessor((Computer) computer);
				int videoCardId = getOrInsertVideoCard((Computer) computer);
				// getting operation system id
				int operationSystemId = getOrInsertOperationSystem((Computer) computer);
				// getting label id
				int labelId = getOrInsertLabel(computer);
				// inserting computer into database
				PreparedStatement computerPs = connection
						.prepareStatement("INSERT INTO computer VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				computerPs.setInt(1, ((Computer) computer).getRam());
				computerPs.setDouble(2, ((Computer) computer).getProcessorSpeed());
				computerPs.setInt(3, ((Computer) computer).getHdd());
				computerPs.setString(4, computer.getModel());
				computerPs.setDouble(5, computer.getPrice());
				computerPs.setString(6, computer.getImage());
				computerPs.setInt(7, processorId);
				computerPs.setInt(8, videoCardId);
				computerPs.setInt(9, operationSystemId);
				computerPs.setInt(10, labelId);

				computerPs.executeUpdate();
				connection.commit();
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new ArticleException();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private int getOrInsertLabel(Article computer) throws SQLException {
		String labelQuery = "SELECT * FROM label WHERE label LIKE '" + computer.getLabel() + "';";
		PreparedStatement labelPs = connection.prepareStatement(labelQuery);
		ResultSet labelRs = labelPs.executeQuery();
		int labelId = 0;

		if (labelRs.next()) {
			labelId = labelRs.getInt("id");
		} else {
			labelId = new KeysDAO().insertLabel(computer.getLabel());
		}
		return labelId;
	}

	private int getOrInsertOperationSystem(Computer computer) throws SQLException {
		String operationSystemQuery = "SELECT * FROM operation_system WHERE operation_system LIKE '"
				+ computer.getOperationSystem() + "';";
		PreparedStatement operationSystemPs = connection.prepareStatement(operationSystemQuery);
		ResultSet operationSystemRs = operationSystemPs.executeQuery();
		int operationSystemId = 0;

		if (operationSystemRs.next()) {
			operationSystemId = operationSystemRs.getInt("id");
		} else {
			operationSystemId = new KeysDAO().insertOperationSystem(computer.getOperationSystem());
		}
		return operationSystemId;
	}

	private int getOrInsertProcessor(Computer computer) throws SQLException {
		String processorQuery = "SELECT * FROM processor_type WHERE processor_type LIKE '" + computer.getProcessorType()
				+ "';";
		PreparedStatement processorPs = connection.prepareStatement(processorQuery);
		ResultSet processorRs = processorPs.executeQuery();
		int processorId = 0;

		if (processorRs.next()) {
			processorId = processorRs.getInt("id");
		} else {
			processorId = new KeysDAO().insertProcessor(computer.getProcessorType());
		}
		return processorId;
	}

	private int getOrInsertVideoCard(Computer computer) throws SQLException {
		// getting video card id
		String videoCardQuery = "SELECT * FROM video_card_type WHERE video_card LIKE '" + computer.getVideoCardType()
				+ "';";
		PreparedStatement videoCardPs = connection.prepareStatement(videoCardQuery);
		ResultSet videoCardRs = videoCardPs.executeQuery();
		int videoCardId = 0;

		if (videoCardRs.next()) {
			videoCardId = videoCardRs.getInt("id");
		} else {
			videoCardId = new KeysDAO().insertVideoCard(computer.getVideoCardType());
		}
		return videoCardId;
	}

}