package net.codejava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Clothing;
import net.codejava.dao.ProductDAO;
import net.codejava.model.Product;

@Controller
public class MainController {
	
	
	@RequestMapping(value = "/")
	public String display() {
		return "index";
	}
	
}
