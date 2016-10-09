package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eshop.connection.DBConnection;

public class KeysDAO {
	Connection connection = DBConnection.getInstance().getConnection();

	public synchronized int insertLabel(String label) {

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO label VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, label);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}
	//inserting processor
	public synchronized int insertProcessor(String processorType) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO processor_type VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, processorType);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//inserting video card
	public synchronized int insertVideoCard(String videoCardType) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO video_card_type VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, videoCardType);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//insertiong operation system
	public synchronized int insertOperationSystem(String operationSystem) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO operation_system VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, operationSystem);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int insertEnergyClass(String energyClass) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO energy_class VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, energyClass);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized int insertColour(String colour) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO colour VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, colour);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int insertResolution(String resolution) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO resolution VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, resolution);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public synchronized int insertCpu(String cpu) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cpu VALUES(null, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cpu);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
