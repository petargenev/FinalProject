package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eshop.connection.DBConnection;

public class KeysDAO {
	Connection connection = DBConnection.getInstance().getConnection();

	public synchronized int insertLabel(String label) throws SQLException {
System.out.println("vleznah v labela keys");
		
			PreparedStatement ps = connection.prepareStatement("INSERT INTO label VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, label);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println("VUVEDOH MARKA");
			return rs.getInt(1);
			
		

	}
	//inserting processor
	public synchronized int insertProcessor(String processorType) throws SQLException {
		
			PreparedStatement ps = connection.prepareStatement("INSERT INTO processor_type VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, processorType);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println("VUVEDOH PROCESOR");
			return rs.getInt(1);

		
	}
	//inserting video card
	public synchronized int insertVideoCard(String videoCardType) throws SQLException {
		System.out.println("VLEZNAh VIDEOKARTA");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO video_card_type VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, videoCardType);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println("VUVEDOH VIDEOKARTA");
			return rs.getInt(1);

		
	}
	//insertiong operation system
	public synchronized int insertOperationSystem(String operationSystem) throws SQLException {
		System.out.println("VLEZNAh OS");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO operation_system VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, operationSystem);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println("VUVEDOH OS");
			return rs.getInt(1);

		
		
	}
	
	public synchronized int insertEnergyClass(String energyClass) throws SQLException {
		
			PreparedStatement ps = connection.prepareStatement("INSERT INTO energy_class VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, energyClass);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println("VUVEDOH ENERGYCLASS");
			return rs.getInt(1);

		
	}

	public synchronized int insertColour(String colour) throws SQLException {
		
			PreparedStatement ps = connection.prepareStatement("INSERT INTO colour VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, colour);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		
	}
	
	public synchronized int insertResolution(String resolution) throws SQLException {
		
			PreparedStatement ps = connection.prepareStatement("INSERT INTO resolution VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, resolution);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		
	}
	
	public synchronized int insertCpu(String cpu) throws SQLException {
		
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cpu VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cpu);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			System.out.println("VUVEDOH CPU");
			return rs.getInt(1);

		
	}
	
	
}
