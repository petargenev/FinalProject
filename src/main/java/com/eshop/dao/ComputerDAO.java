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

public class ComputerDAO implements DAO{
	Connection connection = DBConnection.getInstance().getConnection();

	public Collection<Article> showAll()
			throws SQLException, InvalidInputException,InvalidInputException {
		List<Computer> computers = new ArrayList<Computer>();
		String query = "SELECT c.*, p.*, v.*, o.*, l.* FROM computer c " + 
						"JOIN processor_type p ON (c.processor_type_id = p.id)" +
						"JOIN video_card_type v ON (c.video_card_type_id = v.id)" +
						"JOIN operation_system o ON (c.operation_system_id = o.id)" +
						"JOIN label l ON (c.label_id = l.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");	
			String type = rs.getString("type");
			int ram = rs.getInt("ram");
			String processorType = rs.getString("processor_type");
			double processorSpeed = rs.getDouble("processor_speed");
			String videoCardType = rs.getString("video_card");
			int hdd = rs.getInt("hdd");
			String operationSystem = rs.getString("operation_system");
			computers.add(new Computer(type, label, model, ram, processorType, processorSpeed, videoCardType, hdd, operationSystem, price, image));
		}
		return Collections.unmodifiableList(computers);
	}

	public void insertComputer(Computer computer) throws ArticleException {

		try {
			//getting processor id
			String processorQuery = "SELECT * FROM processor_type WHERE processor_type LIKE '" + computer.getProcessorType() + "';";
			PreparedStatement processorPs = connection.prepareStatement(processorQuery);
			ResultSet processorRs = processorPs.executeQuery();
			int processorId = 0;
			
			if(processorRs.next()){
				processorId = processorRs.getInt("id");
			}else{
				processorId = new KeysDAO().insertProcessor(computer.getProcessorType());
			}
			
			//getting video card id
			String videoCardQuery = "SELECT * FROM video_card_type WHERE type LIKE '" + computer.getVideoCardType() + "';";
			PreparedStatement videoCardPs = connection.prepareStatement(videoCardQuery);
			ResultSet videoCardRs = videoCardPs.executeQuery();
			int videoCardId = 0;
			
			if(videoCardRs.next()){
				videoCardId = videoCardRs.getInt("id");
			}else{
				videoCardId = new KeysDAO().insertVideoCard(computer.getVideoCardType());
			}
			
			//getting operation system id
			String operationSystemQuery = "SELECT * FROM operation_system WHERE type LIKE '" + computer.getOperationSystem() + "';";
			PreparedStatement operationSystemPs = connection.prepareStatement(operationSystemQuery);
			ResultSet operationSystemRs = operationSystemPs.executeQuery();
			int operationSystemId = 0;
			
			if(operationSystemRs.next()){
				operationSystemId = operationSystemRs.getInt("id");
			}else{
				operationSystemId = new KeysDAO().insertOperationSystem(computer.getOperationSystem());
			}
			
			//getting label id
			String labelQuery = "SELECT label FROM label WHERE label LIKE '" + computer.getLabel() + "';";
			PreparedStatement labelPs = connection.prepareStatement(labelQuery);
			ResultSet labelRs = labelPs.executeQuery();
			int labelId = 0;
			
			if(labelRs.next()){
				labelId = labelRs.getInt("id");
			}else{
				labelId = new KeysDAO().insertLabel(computer.getLabel());
			}
			
			//inserting computer into database
			PreparedStatement computerPs = connection.prepareStatement("INSERT INTO computer VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			computerPs.setInt(1, computer.getRam());
			computerPs.setDouble(2, computer.getProcessorSpeed());
			computerPs.setInt(3, computer.getHdd());
			computerPs.setString(4, computer.getModel());
			computerPs.setDouble(5, computer.getPrice());
			computerPs.setString(6, computer.getImage());
			computerPs.setInt(7, processorId);
			computerPs.setInt(8, videoCardId);
			computerPs.setInt(9, operationSystemId);
			computerPs.setInt(10, labelId);
			
			computerPs.executeUpdate();

		} catch (SQLException e) {
			throw new ArticleException();
		}

	}

	
}
