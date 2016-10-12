package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import org.springframework.stereotype.Component;

import com.eshop.connection.DBConnection;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.exceptions.UserException;
import com.eshop.models.Camcorder;
import com.eshop.models.User;

//data access object
@Component
public class UserDAO {
	
	private Connection connection = DBConnection.getInstance().getConnection();
	
	public void registerUser(User user) throws UserException{
		
		
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES(null, ?, ?, md5(?))");	
			ps.setString(1, user.getName());
			
			ps.setString(2, user.getEmail());
			
			ps.setString(3, user.getPassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new UserException("User registration failed!");
		}
		
	}
	
	public User getUser(String userEmail, String userPassword) throws InvalidInputException, SQLException{
		String query = "SELECT * FROM user WHERE email LIKE'" + userEmail + "' AND password=md5('"+userPassword+"');";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		String password = null;
		String name =null;
		String email = null;
		
		while (rs.next()) {
			 name = rs.getString("name");
			 email = rs.getString("email");
			 password = rs.getString("password");
		
		}
		if(email != null){
			return new User(name, email, password);
		}else{
			return new User();
		}

		
	}
	
	public boolean isAvailable(String email) throws SQLException{
		String query = "SELECT * FROM user WHERE email LIKE'" + email + "';";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()){
			return true;
		}else{
			return false;
		}
		
	}
}
