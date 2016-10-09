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
import com.eshop.models.Camera;

public class CameraDAO implements DAO {
	Connection connection = DBConnection.getInstance().getConnection();

	@Override
	public Collection<Article> showAll() throws SQLException, InvalidInputException, InvalidInputException {
		List<Article> cameras = new ArrayList<Article>();
		String query = "SELECT c.*, l.name FROM camera c JOIN label l on(c.label_id = l.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
				String label = rs.getString("label");
				String model = rs.getString("model");
				double price = rs.getDouble("price");
				String image = rs.getString("image");
				double resolution = rs.getDouble("resolution");
				double displaySize = rs.getDouble("display_size");
				int digitalZoom = rs.getInt("digital_zoom");
				int opticalZoom = rs.getInt("optical_zoom");
				
				
				cameras.add(new Camera(image, label, model, price, resolution, opticalZoom, displaySize, digitalZoom));
						
				return Collections.unmodifiableList(cameras);
		
		}
		return Collections.unmodifiableList(cameras);
	}

	public void insertCamcorder(Camera camera) {
		try {
			String labelQuery = "SELECT label FROM label WHERE label LIKE '" + camera.getLabel() + "';";
			PreparedStatement labelPs = connection.prepareStatement(labelQuery);
			ResultSet labelRs = labelPs.executeQuery();
			int labelId = 0;

			if (labelRs.next()) {
				labelId = labelRs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(camera.getLabel());
			}

			PreparedStatement cameraPs = connection
					.prepareStatement("INSERT INTO camera VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
			cameraPs.setDouble(1, camera.getResolution());
			cameraPs.setDouble(2, camera.getDisplaySize());
			cameraPs.setInt(3, camera.getDigitalZoom());
			cameraPs.setInt(4, camera.getOpticalZoom());
			cameraPs.setDouble(5, camera.getPrice());
			cameraPs.setString(6, camera.getModel());
			cameraPs.setString(7, camera.getImage());
			cameraPs.setInt(8, labelId);

			cameraPs.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
