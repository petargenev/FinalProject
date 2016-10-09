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
import com.eshop.models.WashingMachine;

public class WashingMachineDAO {
	Connection connection = DBConnection.getInstance().getConnection();

	public Collection<WashingMachine> showAllWashingMachines()
			throws SQLException, InvalidInputException, InvalidInputException {
		List<WashingMachine> washingMachines = new ArrayList<WashingMachine>();
		String query = "SELECT w.*, l.*, e.* FROM washing_machine w"+
						"JOIN label l ON (w.label_id = l.id)"+
						"JOIN energy_class e  ON (w.energy_class_id = e.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			String kind = rs.getString("kind");
			int roundsPerMinute = rs.getInt("rounds_per_minute");
			String energyClass = rs.getString("energy_class");
			double washingCapacity = rs.getDouble("washing_capacity");

			washingMachines.add(new WashingMachine(label, model, price, kind, roundsPerMinute, energyClass, washingCapacity, image));
		}
		return Collections.unmodifiableList(washingMachines);
	}
	
	public void insertWashingMachine(WashingMachine washingMachine){
		try {
			//inserting label
			String labelQuery = "SELECT label FROM label WHERE label LIKE '" + washingMachine.getLabel() + "';";
			PreparedStatement labelPs = connection.prepareStatement(labelQuery);
			ResultSet labelRs = labelPs.executeQuery();
			int labelId = 0;

			if (labelRs.next()) {
				labelId = labelRs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(washingMachine.getLabel());
			}
			
			//inserting energy class
			
			String energyClassQuery = "SELECT * FROM energy_class WHERE energy_class LIKE '" + washingMachine.getEnergyClass() + "';";
			PreparedStatement energyClassPs = connection.prepareStatement(energyClassQuery);
			ResultSet energyClassRs = energyClassPs.executeQuery();
			int energyClassId = 0;

			if (energyClassRs.next()) {
				energyClassId = energyClassRs.getInt("id");
			} else {
				energyClassId = new KeysDAO().insertEnergyClass(washingMachine.getEnergyClass());
			}
			
			//inserting dishwasher
			PreparedStatement washingMachinePs = connection
					.prepareStatement("INSERT INTO washing_machine VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
			washingMachinePs.setString(1, washingMachine.getModel());
			washingMachinePs.setDouble(2, washingMachine.getPrice());
			washingMachinePs.setString(3, washingMachine.getKind());
			washingMachinePs.setString(4, washingMachine.getImage());
			washingMachinePs.setInt(5, washingMachine.getRoundsPerMinute());
			washingMachinePs.setDouble(5, washingMachine.getWashingCapacity());
			washingMachinePs.setInt(7, energyClassId);
			washingMachinePs.setInt(8, labelId);

			washingMachinePs.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
