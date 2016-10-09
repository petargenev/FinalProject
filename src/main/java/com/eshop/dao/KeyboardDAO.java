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
import com.eshop.models.Keyboard;


public class KeyboardDAO implements DAO {
	Connection connection = DBConnection.getInstance().getConnection();

	public Collection<Article> showAll() throws SQLException, InvalidInputException, InvalidInputException {
		List<Keyboard> keyboards = new ArrayList<Keyboard>();
		String query = "SELECT k.*, c.*, l.* FROM keyboard k" + "JOIN colour c ON (k.colour_id = c.id)"
				+ "JOIN label l ON (k.label_id = l.id);";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String label = rs.getString("label");
			String model = rs.getString("model");
			double price = rs.getDouble("price");

			String type = rs.getString("type");
			String color = rs.getString("color");
			String image = rs.getString("image");

			keyboards.add(new Keyboard(label, model, price, type, color, image));
		}
		return Collections.unmodifiableList(keyboards);
	}

	public void insertKeyboard(Keyboard keyboard) {

		try {
			
			//inserting label
			String query = "SELECT label FROM label WHERE label LIKE '" + keyboard.getLabel() + "';";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			int labelId = 0;

			if (rs.next()) {
				labelId = rs.getInt("id");
			} else {
				labelId = new KeysDAO().insertLabel(keyboard.getLabel());
			}
			
			//inserting colour
			String colourQuery = "SELECT * FROM colour WHERE colour LIKE '" + keyboard.getColour() + "';";
			PreparedStatement colourPs = connection.prepareStatement(colourQuery);
			ResultSet colourRs = colourPs.executeQuery();
			int colourId = 0;

			if (colourRs.next()) {
				colourId = colourRs.getInt("id");
			} else {
				colourId = new KeysDAO().insertColour(keyboard.getColour());
			}
			
			//inserting keyboard
			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO keyboard VALUES(null, ?, ?, ?, ?, ?, ?)");
			ps1.setDouble(1, keyboard.getPrice());
			ps1.setString(2, keyboard.getModel());
			ps1.setString(3, keyboard.getImage());
			ps1.setString(4, keyboard.getType());
			ps1.setInt(4, colourId);
			ps1.setInt(5, labelId);
			ps1.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
