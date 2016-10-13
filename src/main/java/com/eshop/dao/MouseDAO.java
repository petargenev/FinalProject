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
import com.eshop.models.Mouse;

public class MouseDAO implements DAO{
	Connection connection = DBConnection.getInstance().getConnection();
	
	public Collection<Article> showAll()
			throws SQLException, InvalidInputException, InvalidInputException {
		List<Article> mouses = new ArrayList<Article>();
		String query = "SELECT m.*, l.* FROM mouse m JOIN label l on(m.label_id = l.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			int price = rs.getInt("price");
			String image = rs.getString("image");
			String resolution = rs.getString("resolution");
			int id = rs.getInt("id");
			
			
			mouses.add(new Mouse(label, model, price, resolution, image, id));
		}
		return Collections.unmodifiableList(mouses);
	}
	

	public void insertMouse(Mouse mouse) {

		try {
			String query = "SELECT label FROM label WHERE label LIKE '" + mouse.getLabel() + "';";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			int labelId = 0;

			if (rs.next()) {
				labelId = rs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(mouse.getLabel());
			}

			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO mouse VALUES(null, ?, ?, ?, ?, ?)");
			ps1.setDouble(1, mouse.getPrice());
			ps1.setString(2, mouse.getModel());
			ps1.setString(3, mouse.getResolution());
			ps1.setString(4, mouse.getImage());
			ps1.setInt(5, labelId);
			ps1.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}




	
	

}
