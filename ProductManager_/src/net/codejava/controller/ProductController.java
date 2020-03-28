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


import net.codejava.dao.ProductDAO;
import net.codejava.model.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/new1")

	public ModelAndView listProduct(ModelAndView model) {

		List<Product> productList = productDAO.list();
		model.addObject("productList", productList);
		model.setViewName("index_product");
		return model;

	}
	
@RequestMapping(value="/newp", method = RequestMethod.GET)
	
	public ModelAndView newProduct(ModelAndView model) {
		
		Product newProduct = new Product();
		model.addObject("product", newProduct);
		model.setViewName("product_form");
		return model;
		
	}

	@RequestMapping(value = "/save product", method = RequestMethod.POST)

	public ModelAndView saveProduct(@ModelAttribute Product product) {
		if (product.getId() == null) {
			productDAO.save(product);
		} else {
			productDAO.update(product);
		}

		return new ModelAndView("redirect:/new1");
	}

	@RequestMapping(value = "/edit1", method = RequestMethod.GET)

	public ModelAndView editProduct(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Product product = productDAO.get(id);
		ModelAndView model = new ModelAndView("product_form");
		model.addObject("product", product);

		return model;
	}

	@RequestMapping(value = "/delete1", method = RequestMethod.GET)

	public ModelAndView deleteProduct(@RequestParam Integer id) {
		productDAO.delete(id);
		return new ModelAndView("redirect:/new1");
	}

	@RequestMapping(value = "/return1", method = RequestMethod.POST)

	public ModelAndView returnToHome() {

		return new ModelAndView("redirect:index");
	}
}
