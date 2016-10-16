package com.eshop.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
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
import com.eshop.models.Computer;
import com.eshop.models.Laptop;
import com.eshop.models.Tablet;
import com.eshop.models.User;

@Controller
public class AddArticleController {

	private static final String UPLOAD_LOCATION = "D:\\articlePhoto\\";

	@RequestMapping(value = "/addarticle", method = RequestMethod.GET)
	public String creatingArticles(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("isAdmin") == null || session.getAttribute("isAdmin").equals(false))
			return "404";
		System.err.println("SEGA SUM V GET METODA");

		model.addAttribute(new Computer());
		model.addAttribute(new Tablet());
		model.addAttribute(new Laptop());

		return "addarticle";

	}

	@RequestMapping(value = "/addcomputer", method = RequestMethod.POST)
	public String addNewComputer(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Computer computer,
			Model model, HttpServletRequest session)
			throws UserException, ArticleException, IOException, InvalidInputException, SQLException {

		// do something else

		String[] path = multipartFile.getOriginalFilename().split("\\\\");
		String fileName = path[path.length - 1];
		FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
		String image = ("./img/" + fileName);
		computer.setImage(image);

		if (computer.getHdd() <= 0 || (computer.getLabel().isEmpty() || computer.getLabel() == null)
				|| (computer.getModel().isEmpty() || computer.getModel() == null)
				|| (computer.getOperationSystem().isEmpty() || computer.getOperationSystem() == null)
				|| computer.getPrice() <= 0 || computer.getProcessorSpeed() <= 0
				|| (computer.getProcessorType().isEmpty() || computer.getProcessorType() == null)
				|| computer.getRam() <= 0
				|| (computer.getVideoCardType().isEmpty() || computer.getVideoCardType() == null)) {
			return "404";

		}

		new ComputerDAO().insertArticle(computer);

		return creatingArticles(model, session);
	}

	@RequestMapping(value = "/addtablet", method = RequestMethod.POST)
	public String addNewTablet(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Tablet tablet,
			Model model, HttpServletRequest session)
			throws UserException, ArticleException, IOException, InvalidInputException {

		String[] path = multipartFile.getOriginalFilename().split("\\\\");
		String fileName = path[path.length - 1];
		FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
		String image = ("./img/" + fileName);
		tablet.setImage(image);

		if ((tablet.getLabel().isEmpty() || tablet.getLabel() == null)
				|| (tablet.getModel().isEmpty() || tablet.getModel() == null)
				|| (tablet.getDisplayType().isEmpty() || tablet.getDisplayType() == null) || tablet.getPrice() <= 0
				|| tablet.getDisplaySize() <= 0 || (tablet.getLabel().isEmpty() || tablet.getLabel() == null)
				|| (tablet.getResolution().isEmpty() || tablet.getResolution() == null)
				|| tablet.getDisplaySize() <= 0) {
			return "404";

		}

		new TabletDAO().insertArticle(tablet);

		return creatingArticles(model, session);
	}

	@RequestMapping(value = "/addlaptop", method = RequestMethod.POST)
	public String addNewLaptop(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Laptop laptop,
			Model model, HttpServletRequest session)
			throws UserException, ArticleException, InvalidInputException, IOException {

		String[] path = multipartFile.getOriginalFilename().split("\\\\");
		String fileName = path[path.length - 1];
		FileCopyUtils.copy(multipartFile.getBytes(), new File(getUploadLocation() + fileName));
		String image = ("./img/" + fileName);
		laptop.setImage(image);

		if (laptop.getHdd() <= 0 || (laptop.getLabel().isEmpty() || laptop.getLabel() == null)
				|| (laptop.getModel().isEmpty() || laptop.getModel() == null)
				|| (laptop.getOperationSystem().isEmpty() || laptop.getOperationSystem() == null)
				|| laptop.getPrice() <= 0 || laptop.getProcessorSpeed() <= 0
				|| (laptop.getProcessorType().isEmpty() || laptop.getProcessorType() == null) || laptop.getRam() <= 0
				|| (laptop.getVideoCardType().isEmpty() || laptop.getVideoCardType() == null)
				|| (laptop.getResolution().isEmpty() || laptop.getResolution() == null)
				|| laptop.getDisplaySize() <= 0) {
			return "404";

		}

		new LaptopDAO().insertArticle(laptop);

		return creatingArticles(model, session);
	}

	public static String getUploadLocation() {
		return UPLOAD_LOCATION;
	}

}
