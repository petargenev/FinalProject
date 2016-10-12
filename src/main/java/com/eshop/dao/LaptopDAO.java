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

	public Collection<Article> showAll()
			throws SQLException, InvalidInputException,InvalidInputException {
		List<Computer> laptops = new ArrayList<Computer>();
		String query = "SELECT la.*, p.*, v.*, o.*, l.*,r.* FROM laptop la " + 
						"JOIN processor_type p ON (la.processor_type_id = p.id) " +
						"JOIN video_card_type v ON (la.video_card_type_id = v.id) " +
						"JOIN operation_system o ON (la.operation_system_id = o.id) " +
						"JOIN label l ON (la.label_id = l.id) "+
						"JOIN resolution r ON(la.resolution_id = r.id) ";

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
			laptops.add(new Laptop(displaySize, resolution, model, label, ram, processorType, processorSpeed, videoCardType, hdd, operationSystem, price, image));
		}
		return Collections.unmodifiableList(laptops);
	}
	
	public void insertLaptop(Laptop laptop) throws ArticleException {

		try {
			//getting processor id
			System.out.println("VLIZAM V PROCESSOR");
			int processorId = getOrInsertProcessor(laptop);
			
			//getting video card id
			System.out.println("VLIZAM V VIDEOCARD");
			int videoCardId = getOrInserVideoCard(laptop);
			
			//getting operation system id
			System.out.println("VLIZAM V OS");
			int operationSystemId = getOrInsertOperationSystem(laptop);
			
			//getting label id
			System.out.println("VLIZAM V LABEl");
			int labelId = getOrInserLabel(laptop);
			
			//inserting resolution
			System.out.println("VLIZAM V RESOLUTION");
			int resolutionId = getOrInsertResolution(laptop);
			
			//inserting laptop into database
			PreparedStatement laptopPs = connection.prepareStatement("INSERT INTO laptop VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			laptopPs.setInt(1, laptop.getRam());
			laptopPs.setDouble(2, laptop.getDisplaySize());
			laptopPs.setInt(3, laptop.getHdd());
			laptopPs.setDouble(4, laptop.getPrice());
			laptopPs.setString(5, laptop.getModel());
			laptopPs.setDouble(6, laptop.getProcessorSpeed());
			laptopPs.setString(7, laptop.getImage());
			laptopPs.setInt(8, processorId);
			laptopPs.setInt(9, videoCardId);
			laptopPs.setInt(10, operationSystemId);
			System.out.println("PREDI DA SETNA RESOLUTION");
			System.out.println(resolutionId);
			laptopPs.setInt(11, resolutionId);
			System.out.println("SLED KATO SETVAM RESOLUTION");
			laptopPs.setInt(12, labelId);
			System.out.println("PREDI UPDATE-a");
			laptopPs.executeUpdate();
			System.out.println("SLED UPDATE-a");

		} catch (SQLException e) {
			throw new ArticleException(e);
		}

	}

	private int getOrInsertResolution(Laptop laptop) throws SQLException {
		System.out.println("VLEZNAH V RESOLUTION");
		String resolutionQuery = "SELECT * FROM resolution WHERE resolution LIKE '" + laptop.getResolution() + "';";
		PreparedStatement resolutionPs = connection.prepareStatement(resolutionQuery);
		ResultSet resolutionRs = resolutionPs.executeQuery();
		int resolutionId = 0;
		
		if(resolutionRs.next()){
			resolutionId = resolutionRs.getInt("id");
		}else{
			resolutionId = new KeysDAO().insertResolution(laptop.getResolution());
		}
		return resolutionId;
	}

	private int getOrInserLabel(Laptop laptop) throws SQLException {
		System.out.println("VLEZNAH V LABEL");
		String labelQuery = "SELECT * FROM label WHERE label LIKE '" + laptop.getLabel() + "';";
		PreparedStatement labelPs = connection.prepareStatement(labelQuery);
		ResultSet labelRs = labelPs.executeQuery();
		int labelId = 0;
		
		if(labelRs.next()){
			labelId = labelRs.getInt("id");
		}else{
			labelId = new KeysDAO().insertLabel(laptop.getLabel());
		}
		System.out.println("IZLEZNAH V LABEL");
		return labelId;
	}

	private int getOrInsertOperationSystem(Laptop laptop) throws SQLException {
		System.out.println("VLEZNAH V OS");
		String operationSystemQuery = "SELECT * FROM operation_system WHERE operation_system LIKE '" + laptop.getOperationSystem() + "';";
		PreparedStatement operationSystemPs = connection.prepareStatement(operationSystemQuery);
		ResultSet operationSystemRs = operationSystemPs.executeQuery();
		int operationSystemId = 0;
		
		if(operationSystemRs.next()){
			operationSystemId = operationSystemRs.getInt("id");
		}else{
			operationSystemId = new KeysDAO().insertOperationSystem(laptop.getOperationSystem());
		}
		return operationSystemId;
	}

	private int getOrInserVideoCard(Laptop laptop) throws SQLException {
		System.out.println("VLEZNAH V VIDEOCARD");
		String videoCardQuery = "SELECT * FROM video_card_type WHERE video_card LIKE '" + laptop.getVideoCardType() + "';";
		PreparedStatement videoCardPs = connection.prepareStatement(videoCardQuery);
		ResultSet videoCardRs = videoCardPs.executeQuery();
		int videoCardId = 0;
		
		if(videoCardRs.next()){
			videoCardId = videoCardRs.getInt("id");
		}else{
			videoCardId = new KeysDAO().insertVideoCard(laptop.getVideoCardType());
		}
		return videoCardId;
	}

	private int getOrInsertProcessor(Laptop laptop) throws SQLException {
		System.out.println("VLEZNAH V PROCESOR");
		String processorQuery = "SELECT * FROM processor_type WHERE processor_type LIKE '" + laptop.getProcessorType() + "';";
		PreparedStatement processorPs = connection.prepareStatement(processorQuery);
		ResultSet processorRs = processorPs.executeQuery();
		int processorId = 0;
		
		if(processorRs.next()){
			processorId = processorRs.getInt("id");
		}else{
			processorId = new KeysDAO().insertProcessor(laptop.getProcessorType());
		}
		return processorId;
	}
}
