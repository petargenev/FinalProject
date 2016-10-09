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
import com.eshop.exceptions.InvalidInputException;
import com.eshop.interfaces.DAO;
import com.eshop.models.Article;
import com.eshop.models.Refrigerator;

public class RefrigeratorDAO implements DAO {
	Connection connection = DBConnection.getInstance().getConnection();
	
	public Collection<Article> showAll()
			throws SQLException, InvalidInputException, InvalidInputException {
		List<Refrigerator> refrigerators = new ArrayList<Refrigerator>();
		String query = "SELECT r.*, l.*, c.*, e.* FROM refrigerator r"+
						"JOIN label l ON (r.label_id = l.id)"+
						"JOIN colour c ON (r.colour_id = c.id)"+
						"JOIN energy_class e ON (r.energy_class_id = e.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			
			int totalCapacity = rs.getInt("total_capacity");
			String energyClass = rs.getString("energy_class");
			String colour = rs.getString("colour");
			
			
			refrigerators.add(new Refrigerator(label, model, price, totalCapacity, energyClass, colour, image));
		}
		return Collections.unmodifiableList(refrigerators);
	}
	
	public void insertRefrigerator(Refrigerator refrigerator) throws SQLException{
		//inserting energy class
		
		String energyClassQuery = "SELECT * FROM energy_class WHERE energy_class LIKE '" + refrigerator.getEnergyClass() + "';";
		PreparedStatement energyClassPs = connection.prepareStatement(energyClassQuery);
		ResultSet energyClassRs = energyClassPs.executeQuery();
		int energyClassId = 0;

		if (energyClassRs.next()) {
			energyClassId = energyClassRs.getInt("id");
		} else {
			energyClassId = new KeysDAO().insertEnergyClass(refrigerator.getEnergyClass());
		}
		
		//inserting colour
		String colourQuery = "SELECT * FROM colour WHERE colour LIKE '" + refrigerator.getColour() + "';";
		PreparedStatement colourPs = connection.prepareStatement(colourQuery);
		ResultSet colourRs = colourPs.executeQuery();
		int colourId = 0;

		if (colourRs.next()) {
			colourId = colourRs.getInt("id");
		} else {
			colourId = new KeysDAO().insertColour(refrigerator.getColour());
		}
		
		//inserting label
		String query = "SELECT label FROM label WHERE label LIKE '" + refrigerator.getLabel() + "';";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		int labelId = 0;

		if (rs.next()) {
			labelId = rs.getInt("id");
		} else {
			labelId = new KeysDAO().insertLabel(refrigerator.getLabel());
		}
		
		//inserting refrigerator
		
		PreparedStatement refrigeratorPs = connection
				.prepareStatement("INSERT INTO refrigerator VALUES(null, ?, ?, ?, ?, ?, ?, ?)");
		refrigeratorPs.setInt(1, refrigerator.getTotalCapacity());
		refrigeratorPs.setDouble(2, refrigerator.getPrice());
		refrigeratorPs.setString(3, refrigerator.getModel());
		refrigeratorPs.setString(4, refrigerator.getImage());
		refrigeratorPs.setInt(5, energyClassId);
		refrigeratorPs.setInt(6, colourId);
		refrigeratorPs.setInt(7, labelId);
		

		refrigeratorPs.executeUpdate();
	}
}
