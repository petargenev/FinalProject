package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.activity.InvalidActivityException;

import com.eshop.connection.DBConnection;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.interfaces.DAO;
import com.eshop.models.Article;
import com.eshop.models.Monitor;

public class MonitorDAO implements DAO{
	Connection connection = DBConnection.getInstance().getConnection();
	
	public Collection<Article> showAll()
			throws SQLException, InvalidInputException, InvalidInputException, InvalidActivityException {
		List<Monitor> monitors = new ArrayList<Monitor>();
		String query = "SELECT m.*,l.*,r.* FROM monitor m" +
						"JOIN label l ON (m.label_id = l.id)"+
						"JOIN resolution r ON (m.resolution_id = r.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");
			String image = rs.getString("image");
			String displayType = rs.getString("display_type");
			double displaySize = rs.getDouble("display_size");
			String resolution = rs.getString("resolution");
			String contrast = rs.getString("contrast");
			int id = rs.getInt("id");
			
			monitors.add(new Monitor(label, model, displayType, displaySize, resolution, contrast, price, image, id));
			
		}
		return Collections.unmodifiableList(monitors);
	}
	
	public void insertMonitor(Monitor monitor) throws SQLException{
		//inserting resolution 
		String resolutionQuery = "SELECT * FROM resolution WHERE resolution LIKE '" + monitor.getResolution() + "';";
		PreparedStatement resolutionPs = connection.prepareStatement(resolutionQuery);
		ResultSet resolutionRs = resolutionPs.executeQuery();
		int resolutionId = 0;
		
		if(resolutionRs.next()){
			resolutionId = resolutionRs.getInt("id");
		}else{
			resolutionId = new KeysDAO().insertLabel(monitor.getLabel());
		}
		
		//inserting lable
		String query = "SELECT * FROM label WHERE label LIKE '" + monitor.getLabel() + "';";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		int labelId = 0;

		if (rs.next()) {
			labelId = rs.getInt("id");
		} else {
			labelId = new KeysDAO().insertLabel(monitor.getLabel());
		}
		
		//inserting monitor
		PreparedStatement monitorPs = connection.prepareStatement("INSERT INTO monitor VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
		monitorPs.setString(1, monitor.getDisplayType());
		monitorPs.setDouble(2, monitor.getDisplaySize());
		monitorPs.setString(3, monitor.getContrast());
		monitorPs.setDouble(4, monitor.getPrice());
		monitorPs.setString(5, monitor.getImage());
		monitorPs.setString(6, monitor.getModel());
		monitorPs.setInt(7, resolutionId);
		monitorPs.setInt(8, labelId);
		
		
		monitorPs.executeUpdate();
		
		
	}
}
