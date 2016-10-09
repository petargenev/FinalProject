package com.eshop.models;

import com.eshop.exceptions.InvalidInputException;

public class User {
	private String firstName;
	private String email;
	private String password;
	
	public User(){
		
	}
	public User(String firstName, String email, String password) throws InvalidInputException {
		setFirstName(firstName);
		setEmail(email);
		setPassword(password);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName +  ", email=" + email  + ", password=" + password + "]";

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws InvalidInputException {
		if (firstName != null && !firstName.isEmpty()){
			this.firstName = firstName;
		}else{
			throw new InvalidInputException();
		}
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws InvalidInputException {
		if (email != null && !email.isEmpty()){
			this.email = email;
		}else{
			throw new InvalidInputException();
		}
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws InvalidInputException {
		if (password != null && !password.isEmpty()){
			this.password = password;
		}else{
			throw new InvalidInputException();
		}
	}

}
