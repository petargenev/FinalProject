package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eshop.connection.DBConnection;
import com.eshop.exceptions.ArticleException;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.interfaces.DAO;
import com.eshop.models.Article;
import com.eshop.models.Computer;
import com.eshop.models.Laptop;

public class LaptopDAO implements DAO {
	Connection connection = DBConnection.getInstance().getConnection();

	public Laptop getArticleById(int laptopId) throws SQLException, InvalidInputException {
		String query = "SELECT la.*, p.*, v.*, o.*, l.*,r.* FROM laptop la "
				+ "JOIN processor_type p ON (la.processor_type_id = p.id) "
				+ "JOIN video_card_type v ON (la.video_card_type_id = v.id) "
				+ "JOIN operation_system o ON (la.operation_system_id = o.id) "
				+ "JOIN label l ON (la.label_id = l.id) " + "JOIN resolution r ON(la.resolution_id = r.id) "
				+ "WHERE la.id LIKE'" + laptopId + "';";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		Laptop laptop = null;
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");

			int ram = rs.getInt("ram");
			double displaySize = rs.getDouble("display_size");
			String processorType = rs.getString("processor_type");
			double processorSpeed = rs.getDouble("processor_speed");
			String videoCardType = rs.getString("video_card");
			int hdd = rs.getInt("hdd");
			String resolution = rs.getString("resolution");
			String operationSystem = rs.getString("operation_system");
			int id = rs.getInt("id");
			laptop = new Laptop(displaySize, resolution, model, label, ram, processorType, processorSpeed,
					videoCardType, hdd, operationSystem, price, image, id);
		}
		System.out.println("VRUSHTAM LAPTOP");
		System.out.println(laptop);
		return laptop;
	}

	public Collection<Article> getArticleByLabel(String laptopLabel) throws SQLException, InvalidInputException {
		List<Computer> laptops = new ArrayList<Computer>();
		String query = "SELECT la.*, p.*, v.*, o.*, l.*,r.* FROM laptop la "
				+ "JOIN processor_type p ON (la.processor_type_id = p.id) "
				+ "JOIN video_card_type v ON (la.video_card_type_id = v.id) "
				+ "JOIN operation_system o ON (la.operation_system_id = o.id) "
				+ "JOIN label l ON (la.label_id = l.id) " + "JOIN resolution r ON(la.resolution_id = r.id) "
				+ "WHERE l.label LIKE '" + laptopLabel + "';";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");

			int ram = rs.getInt("ram");
			double displaySize = rs.getDouble("display_size");
			String processorType = rs.getString("processor_type");
			double processorSpeed = rs.getDouble("processor_speed");
			String videoCardType = rs.getString("video_card");
			int hdd = rs.getInt("hdd");
			String resolution = rs.getString("resolution");
			String operationSystem = rs.getString("operation_system");
			int id = rs.getInt("id");
			laptops.add(new Laptop(displaySize, resolution, model, label, ram, processorType, processorSpeed,
					videoCardType, hdd, operationSystem, price, image, id));
		}
		return Collections.unmodifiableList(laptops);
	}

	public Collection<Article> showAll() throws SQLException, InvalidInputException, InvalidInputException {
		List<Computer> laptops = new ArrayList<Computer>();
		String query = "SELECT la.*, p.*, v.*, o.*, l.*,r.* FROM laptop la "
				+ "JOIN processor_type p ON (la.processor_type_id = p.id) "
				+ "JOIN video_card_type v ON (la.video_card_type_id = v.id) "
				+ "JOIN operation_system o ON (la.operation_system_id = o.id) "
				+ "JOIN label l ON (la.label_id = l.id) " + "JOIN resolution r ON(la.resolution_id = r.id) ";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");

			int ram = rs.getInt("ram");
			double displaySize = rs.getDouble("display_size");
			String processorType = rs.getString("processor_type");
			double processorSpeed = rs.getDouble("processor_speed");
			String videoCardType = rs.getString("video_card");
			int hdd = rs.getInt("hdd");
			String resolution = rs.getString("resolution");
			String operationSystem = rs.getString("operation_system");
			int id = rs.getInt("id");
			laptops.add(new Laptop(displaySize, resolution, model, label, ram, processorType, processorSpeed,
					videoCardType, hdd, operationSystem, price, image, id));
		}
		return Collections.unmodifiableList(laptops);
	}

	public void deleteArticleById(int id) throws SQLException {
		String deleteQuery = "DELETE FROM laptop WHERE id LIKE '" + id + "';";
		PreparedStatement deletePs = connection.prepareStatement(deleteQuery);
		deletePs.executeUpdate();

	}

	public void insertArticle(Article laptop) throws ArticleException {

		try {
			if (laptop instanceof Laptop) {
				connection.setAutoCommit(false);
				// getting processor id
				int processorId = getOrInsertProcessor((Laptop) laptop);

				// getting video card id
				int videoCardId = getOrInserVideoCard((Laptop) laptop);

				// getting operation system id
				int operationSystemId = getOrInsertOperationSystem((Laptop) laptop);

				// getting label id
				int labelId = getOrInserLabel((Laptop) laptop);

				// inserting resolution
				int resolutionId = getOrInsertResolution((Laptop) laptop);

				// inserting laptop into database
				PreparedStatement laptopPs = connection
						.prepareStatement("INSERT INTO laptop VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				laptopPs.setInt(1, ((Computer) laptop).getRam());
				laptopPs.setDouble(2, ((Laptop) laptop).getDisplaySize());
				laptopPs.setInt(3, ((Computer) laptop).getHdd());
				laptopPs.setDouble(4, laptop.getPrice());
				laptopPs.setString(5, laptop.getModel());
				laptopPs.setDouble(6, ((Computer) laptop).getProcessorSpeed());
				laptopPs.setString(7, laptop.getImage());
				laptopPs.setInt(8, processorId);
				laptopPs.setInt(9, videoCardId);
				laptopPs.setInt(10, operationSystemId);
				System.out.println("PREDI DA SETNA RESOLUTION");
				System.out.println(resolutionId);
				laptopPs.setInt(11, resolutionId);
				System.out.println("SLED KATO SETVAM RESOLUTION");
				laptopPs.setInt(12, labelId);

				laptopPs.executeUpdate();
				connection.commit();

			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new ArticleException(e);
		}finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private int getOrInsertResolution(Laptop laptop) throws SQLException {

		String resolutionQuery = "SELECT * FROM resolution WHERE resolution LIKE '" + laptop.getResolution() + "';";
		PreparedStatement resolutionPs = connection.prepareStatement(resolutionQuery);
		ResultSet resolutionRs = resolutionPs.executeQuery();
		int resolutionId = 0;

		if (resolutionRs.next()) {
			resolutionId = resolutionRs.getInt("id");
		} else {
			resolutionId = new KeysDAO().insertResolution(laptop.getResolution());
		}
		return resolutionId;
	}

	private int getOrInserLabel(Laptop laptop) throws SQLException {

		String labelQuery = "SELECT * FROM label WHERE label LIKE '" + laptop.getLabel() + "';";
		PreparedStatement labelPs = connection.prepareStatement(labelQuery);
		ResultSet labelRs = labelPs.executeQuery();
		int labelId = 0;

		if (labelRs.next()) {
			labelId = labelRs.getInt("id");
		} else {
			labelId = new KeysDAO().insertLabel(laptop.getLabel());
		}

		return labelId;
	}

	private int getOrInsertOperationSystem(Laptop laptop) throws SQLException {

		String operationSystemQuery = "SELECT * FROM operation_system WHERE operation_system LIKE '"
				+ laptop.getOperationSystem() + "';";
		PreparedStatement operationSystemPs = connection.prepareStatement(operationSystemQuery);
		ResultSet operationSystemRs = operationSystemPs.executeQuery();
		int operationSystemId = 0;

		if (operationSystemRs.next()) {
			operationSystemId = operationSystemRs.getInt("id");
		} else {
			operationSystemId = new KeysDAO().insertOperationSystem(laptop.getOperationSystem());
		}
		return operationSystemId;
	}

	private int getOrInserVideoCard(Laptop laptop) throws SQLException {

		String videoCardQuery = "SELECT * FROM video_card_type WHERE video_card LIKE '" + laptop.getVideoCardType()
				+ "';";
		PreparedStatement videoCardPs = connection.prepareStatement(videoCardQuery);
		ResultSet videoCardRs = videoCardPs.executeQuery();
		int videoCardId = 0;

		if (videoCardRs.next()) {
			videoCardId = videoCardRs.getInt("id");
		} else {
			videoCardId = new KeysDAO().insertVideoCard(laptop.getVideoCardType());
		}
		return videoCardId;
	}

	private int getOrInsertProcessor(Laptop laptop) throws SQLException {

		String processorQuery = "SELECT * FROM processor_type WHERE processor_type LIKE '" + laptop.getProcessorType()
				+ "';";
		PreparedStatement processorPs = connection.prepareStatement(processorQuery);
		ResultSet processorRs = processorPs.executeQuery();
		int processorId = 0;

		if (processorRs.next()) {
			processorId = processorRs.getInt("id");
		} else {
			processorId = new KeysDAO().insertProcessor(laptop.getProcessorType());
		}
		return processorId;
	}
}