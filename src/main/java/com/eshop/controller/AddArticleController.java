package com.eshop.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.dao.ComputerDAO;
import com.eshop.dao.LaptopDAO;
import com.eshop.dao.TabletDAO;
import com.eshop.exceptions.ArticleException;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.exceptions.UserException;
import com.eshop.models.Article;
import com.eshop.models.Computer;
import com.eshop.models.Laptop;
import com.eshop.models.Tablet;

@Controller
public class AddArticleController {
	
	private static final String UPLOAD_LOCATION = "D:\\articlePhoto\\";
	
	
	
	@RequestMapping(value = "/addarticle", method = RequestMethod.GET)
	public String creatingArticles(Model model) {
		System.err.println("SEGA SUM V GET METODA");
		model.addAttribute(new Computer());
		model.addAttribute(new Tablet());
		model.addAttribute(new Laptop());
		
		return "addarticle";
	}
	
	
	@RequestMapping(value="/addcomputer", method = RequestMethod.POST)
	public String addNewComputer(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Computer computer, Model model) throws UserException, ArticleException, IOException, InvalidInputException, SQLException {
		
		String[] path = multipartFile.getOriginalFilename().split("\\\\");
		String fileName = path[path.length-1];
		FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
		String image = ("./img/" + fileName);
		computer.setImage(image);
		
		new ComputerDAO().insertComputer(computer);
		Collection<Article> computers = new ComputerDAO().showAll();
		for (Article article : computers) {
			if(article instanceof Computer){
				System.out.println(((Computer)article));
			}
		}
		
		
		
		return  creatingArticles(model);
	}
	
	@RequestMapping(value="/addtablet", method = RequestMethod.POST)
	public String addNewTablet(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Tablet tablet, Model model) throws UserException, ArticleException, IOException, InvalidInputException {
		
		String[] path = multipartFile.getOriginalFilename().split("\\\\");
		String fileName = path[path.length-1];
		FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
		String image = ("./img/" + fileName);
		tablet.setImage(image);
		
		new TabletDAO().insertTable(tablet);
		
		
		return  creatingArticles(model);
	}
	
	@RequestMapping(value="/addlaptop", method = RequestMethod.POST)
	public String addNewLaptop(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Laptop laptop, Model model) throws UserException, ArticleException, InvalidInputException, IOException {
		
		String[] path = multipartFile.getOriginalFilename().split("\\\\");
		String fileName = path[path.length-1];
		FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
		String image = ("./img/" + fileName);
		laptop.setImage(image);
		
		new LaptopDAO().insertLaptop(laptop);
		
		
		return  creatingArticles(model);
	}


	public static String getUploadLocation() {
		return UPLOAD_LOCATION;
	}
	
	

}
