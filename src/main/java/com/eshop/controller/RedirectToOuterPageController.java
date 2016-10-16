package com.eshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectToOuterPageController {

	@RequestMapping(value = { "/rdFacebook" }, method = RequestMethod.GET)
	public void redirectToFacebook(HttpServletResponse response) {
		try {
			response.sendRedirect("https://www.facebook.com/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/rdTwitter" }, method = RequestMethod.GET)
	public void redirectToTwitter(HttpServletResponse response) {
		try {
			response.sendRedirect("https://twitter.com/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/rdLinkedin" }, method = RequestMethod.GET)
	public void redirectToLinkedin(HttpServletResponse response) {
		try {
			response.sendRedirect("https://www.linkedin.com/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/rdDribbble"}, method = RequestMethod.GET)
	public void redirectToDribbble(HttpServletResponse response){
		try {
			response.sendRedirect("https://dribbble.com/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/rdGooglePlus" }, method = RequestMethod.GET)
	public void redirectToGooglePlus(HttpServletResponse response) {
		try {
			response.sendRedirect("https://plus.google.com/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
