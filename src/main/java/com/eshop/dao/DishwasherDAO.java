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
import com.eshop.models.Dishwasher;

public class DishwasherDAO implements DAO{
	Connection connection = DBConnection.getInstance().getConnection();
	
	public Collection<Article> showAll()
			throws SQLException, InvalidInputException, InvalidInputException {
		List<Dishwasher> dishwashers = new ArrayList<Dishwasher>();
		String query = "SELECT d.*,e.*,l.* FROM dishwasher d "+
						"JOIN energy_class e ON (d.energy_class_id = e.id)"+
						"JOIN label l ON(d.label_id = l.id)";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");

			int capacity = rs.getInt("capacity");
			String energyClass = rs.getString("energy_class");
			int programmesNumber = rs.getInt("number_of_programmes");
			int temperaturesNumber = rs.getInt("number_of_temperatures");
			String image = rs.getString("image");
			dishwashers.add(new Dishwasher(label, model, price, capacity, energyClass, programmesNumber, temperaturesNumber, image));
		}
		return Collections.unmodifiableList(dishwashers);
	}
	
	public void insertDishwasher(Dishwasher dishwasher){
		try {
			//inserting label
			String labelQuery = "SELECT label FROM label WHERE label LIKE '" + dishwasher.getLabel() + "';";
			PreparedStatement labelPs = connection.prepareStatement(labelQuery);
			ResultSet labelRs = labelPs.executeQuery();
			int labelId = 0;

			if (labelRs.next()) {
				labelId = labelRs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(dishwasher.getLabel());
			}
			
			//inserting energy class
			
			String energyClassQuery = "SELECT * FROM energy_class WHERE energy_class LIKE '" + dishwasher.getEnergyClass() + "';";
			PreparedStatement energyClassPs = connection.prepareStatement(energyClassQuery);
			ResultSet energyClassRs = energyClassPs.executeQuery();
			int energyClassId = 0;

			if (energyClassRs.next()) {
				energyClassId = energyClassRs.getInt("id");
			} else {
				energyClassId = new KeysDAO().insertEnergyClass(dishwasher.getEnergyClass());
			}
			
			//inserting dishwasher
			PreparedStatement dishwasherPs = connection
					.prepareStatement("INSERT INTO dishwasher VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
			dishwasherPs.setDouble(1, dishwasher.getPrice());
			dishwasherPs.setString(2, dishwasher.getModel());
			dishwasherPs.setInt(3, dishwasher.getCapacity());
			dishwasherPs.setInt(4, dishwasher.getProgrammesNumber());
			dishwasherPs.setInt(5, dishwasher.getTemperaturesNumber());
			dishwasherPs.setString(6, dishwasher.getImage());
			dishwasherPs.setInt(7, labelId);
			dishwasherPs.setInt(8, energyClassId);

			dishwasherPs.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
