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
import com.eshop.exceptions.ArticleException;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.interfaces.DAO;
import com.eshop.models.Article;
import com.eshop.models.Camcorder;
import com.eshop.models.Computer;

public class CamcorderDAO implements DAO {
	Connection connection = DBConnection.getInstance().getConnection();

	@Override
	public Collection<Article> showAll() throws SQLException, InvalidInputException, InvalidInputException {

		List<Article> camcorders = new ArrayList<Article>();
		String query = "SELECT c.*, l.* FROM camcorder c JOIN label l on(c.label_id = l.id);";

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
			String cameraType = rs.getString("camera_type");
			int id = rs.getInt("id");
			try {
				camcorders.add(new Camcorder(image, label, model, price, resolution, cameraType, displaySize, digitalZoom, id));
			} catch (InvalidActivityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		connection.close();
		return Collections.unmodifiableList(camcorders);
		
	}

	public void insertCamcorder(Camcorder camcorder) throws SQLException {
		try {
			String labelQuery = "SELECT label FROM label WHERE label LIKE '" + camcorder.getLabel() + "';";
			PreparedStatement labelPs = connection.prepareStatement(labelQuery);
			ResultSet labelRs = labelPs.executeQuery();
			int labelId = 0;

			if (labelRs.next()) {
				labelId = labelRs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(camcorder.getLabel());
			}

			PreparedStatement camcorderPs = connection
					.prepareStatement("INSERT INTO camcorder VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
			camcorderPs.setDouble(1, camcorder.getResolution());
			camcorderPs.setDouble(2, camcorder.getDisplaySize());
			camcorderPs.setInt(3, camcorder.getDigitalZoom());
			camcorderPs.setDouble(4, camcorder.getPrice());
			camcorderPs.setString(5, camcorder.getModel());
			camcorderPs.setString(6, camcorder.getImage());
			camcorderPs.setString(7, camcorder.getCameraType());
			camcorderPs.setInt(8, labelId);

			camcorderPs.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			connection.close();
			e.printStackTrace();
		}

	}

	@Override
	public Computer getArticleById(int articleId) throws SQLException, InvalidInputException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Article> getArticleByLabel(String articlelabel) throws SQLException, InvalidInputException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertArticle(Article article) throws ArticleException {
		// TODO Auto-generated method stub
		
	}

}
