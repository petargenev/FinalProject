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
			if(result == true){
				return "true";
			}else{	
				return "false";
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}
}
