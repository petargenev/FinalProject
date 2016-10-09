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
import com.eshop.models.WebCamera;

public class WebCameraDAO implements DAO{
	Connection connection = DBConnection.getInstance().getConnection();

	public Collection<Article> showAll()
			throws SQLException, InvalidInputException, InvalidInputException {
		List<WebCamera> webCameras = new ArrayList<WebCamera>();
		String query = "SELECT w.*, l.*, r.* FROM web_cam w" +
						"JOIN label l ON (w.label_id = l.id)"+
						"JOIN resolution r  ON (w.resolution_id = r.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			String resolution = rs.getString("resolution");
			int framesPerSecond = rs.getInt("frames_per_second");
			
			
		
			webCameras.add(new WebCamera(label, model, price, resolution, framesPerSecond,image));
		}
		return Collections.unmodifiableList(webCameras);
	}
	
	public void insertWebCamera(WebCamera webCamera) {

		try {
			//inserting label
			String query = "SELECT label FROM label WHERE label LIKE '" + webCamera.getLabel() + "';";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			int labelId = 0;

			if (rs.next()) {
				labelId = rs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(webCamera.getLabel());
			}
			
			//inserting resolution 
			String resolutionQuery = "SELECT * FROM resolution WHERE resolution LIKE '" + webCamera.getResolution() + "';";
			PreparedStatement resolutionPs = connection.prepareStatement(resolutionQuery);
			ResultSet resolutionRs = resolutionPs.executeQuery();
			int resolutionId = 0;
			
			if(resolutionRs.next()){
				resolutionId = resolutionRs.getInt("id");
			}else{
				resolutionId = new KeysDAO().insertLabel(webCamera.getLabel());
			}
			
			

			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO mouse VALUES(null, ?, ?, ?, ?, ?, ?)");
			ps1.setInt(1, webCamera.getFramesPerSecond());
			ps1.setString(2, webCamera.getModel());
			ps1.setDouble(3, webCamera.getPrice());
			ps1.setString(4, webCamera.getImage());
			ps1.setInt(5, labelId);
			ps1.setInt(6, resolutionId);
			ps1.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
