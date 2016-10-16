package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.eshop.connection.DBConnection;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.exceptions.UserException;
import com.eshop.models.User;

//data access object
@Component
public class UserDAO {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}");

	private Connection connection = DBConnection.getInstance().getConnection();

	public void registerUser(User user) throws UserException {

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES(null, ?, ?, md5(?), ?)");
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			ps.setString(1, user.getName());

			ps.setString(2, user.getEmail());

			ps.setString(3, user.getPassword());
			ps.setInt(4, 0);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new UserException("User registration failed!");
		}

	}

	public User getUser(String userEmail, String userPassword) throws InvalidInputException, SQLException {
		String query = "SELECT * FROM user WHERE email LIKE'" + userEmail + "' AND password=md5('" + userPassword
				+ "');";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		String password = null;
		String name = null;
		String email = null;
		boolean isAdmin = false;

		while (rs.next()) {
			name = rs.getString("name");
			email = rs.getString("email");
			password = rs.getString("password");
			isAdmin = rs.getInt("isAdministrator") == 1 ? true : false;

		}
		if (email != null) {
			return new User(name, email, password, isAdmin);
		} else {
			return new User();
		}

	}

	public boolean isAvailable(String email) throws SQLException {
		String query = "SELECT * FROM user WHERE email LIKE'" + email + "';";

		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isValidName(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		System.out.println("VRUSHTAM TRUE ZA IMETO!!!!!!");
		return true;
	}

	public boolean isValidEmail(String email) {
		if (email != null && !email.isEmpty()) {

			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
//			System.out.println(matcher.find() + " EMAILA ");

			return matcher.find();

		} else {
			return false;
		}

	}

	public boolean isValidPassword(String password) {
		System.out.println("PROVERQVAM PAROLATA PREDI IF-a!!!!!!!");
		boolean containsUpperCaseLetter = false;
		boolean containsLowerCaseLetter = false;
		boolean constainsNumber = false;
		if (password != null && !password.isEmpty() && password.length() >= 6) {

			for (int character = 0; character < password.length(); character++) {
				if (password.charAt(character) >= '0' && password.charAt(character) <= '9') {
					constainsNumber = true;
					System.out.println("IMA CHISLO");
				}

				if (password.charAt(character) >= 'A' && password.charAt(character) <= 'Z') {
					containsUpperCaseLetter = true;
					System.out.println("IMA GOLQMA BUKVA ");
				}

				if (password.charAt(character) >= 'a' && password.charAt(character) <= 'z') {
					containsLowerCaseLetter = true;
					System.out.println("IMA MALKA BUKVA");
				}
			}
			if (constainsNumber && containsLowerCaseLetter && containsUpperCaseLetter) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
}
