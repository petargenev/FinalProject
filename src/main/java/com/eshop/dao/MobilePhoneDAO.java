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
import com.eshop.models.Article;
import com.eshop.models.MobilePhone;


public class MobilePhoneDAO {
	Connection connection = DBConnection.getInstance().getConnection();
	
	public Collection<Article> showAll()
			throws SQLException, InvalidInputException, InvalidInputException {
		List<Article> mobilePhones = new ArrayList<Article>();
		String query = "SELECT m.*, l.*, c.* FROM mobile_phone m"+
						"JOIN label l ON (m.label_id = l.id)"+
						"JOIN cpu c ON (m.cpu_id = c.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");
			double displaySize = rs.getDouble("display_size");
			double rearCamera = rs.getDouble("rear_camera");
			String cpu = rs.getString("cpu");
			String displayType = rs.getString("display_type");
			int id = rs.getInt("id");
			
			
			mobilePhones.add(new MobilePhone(label, model, price, cpu, displaySize, displayType, rearCamera, image, id));
		}
		return Collections.unmodifiableList(mobilePhones);
	}
	

	public void insertMobilePhone(MobilePhone mobilePhone) {

		try {
			//inserting lable
			String query = "SELECT * FROM label WHERE label LIKE '" + mobilePhone.getLabel() + "';";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			int labelId = 0;

			if (rs.next()) {
				labelId = rs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(mobilePhone.getLabel());
			}
			//inserting cpu
			String cpuQuery = "SELECT * FROM cpu WHERE cpu LIKE '" + mobilePhone.getCpu() + "';";
			PreparedStatement cpuPs = connection.prepareStatement(cpuQuery);
			ResultSet cpuRs = cpuPs.executeQuery();
			int cpuId = 0;

			if (cpuRs.next()) {
				cpuId = rs.getInt("id");
			} else {
				cpuId = new KeysDAO().insertCpu(mobilePhone.getCpu());
			}
			
			//inserting mobile phone
			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO mobile_phone VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps1.setDouble(1, mobilePhone.getDisplaySize());
			ps1.setDouble(2, mobilePhone.getRearCamera());
			ps1.setString(3, mobilePhone.getModel());
			ps1.setDouble(4, mobilePhone.getPrice());
			ps1.setString(5, mobilePhone.getDisplayType());
			ps1.setString(6, mobilePhone.getImage());
			ps1.setInt(7, labelId);
			ps1.setInt(8, cpuId);
			ps1.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
