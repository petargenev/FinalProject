package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.eshop.connection.DBConnection;
import com.eshop.exceptions.UserException;
import com.eshop.models.User;

//data access object
public class UserDAO {
	
	Connection connection = DBConnection.getInstance().getConnection();
	
	public void registerUser(User user) throws UserException{
		
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES(null, ?, ?, ?)");	
			ps.setString(1, user.getName());
			
			ps.setString(2, user.getEmail());
			
			ps.setString(3, user.getPassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new UserException("User registration failed!");
		}
		
	}
}
