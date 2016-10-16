package com.eshop.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.dao.UserDAO;

@Controller
public class EmailAvailabilityController {

	@RequestMapping(value = "/emailAvailability", method = RequestMethod.POST)
	@ResponseBody
	public String emailAvailability(HttpServletRequest request){
		try {
			boolean result = new UserDAO().isAvailable(request.getParameter("email"));
			if(result == true || !minLength(request.getParameter("email"))){
				return "true";
			}else{	
				return "false";
			}
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "false";
	}
	
	private boolean minLength(String email){
		int length = 0;
		for (int index = 0; index < email.length(); index++) {
			if(email.charAt(index) != '@'){
				length++;
			}else{
				break;
			}
		}
		return length >= 3 ? true : false;
	}
}
