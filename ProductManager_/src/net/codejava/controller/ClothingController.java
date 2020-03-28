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

import net.codejava.dao.ClothingDAO;
import net.codejava.model.Clothing;

@Controller
public class ClothingController {

	@Autowired
	private ClothingDAO clothingDAO;
	

	@RequestMapping(value = "/new2")

	public ModelAndView listClothing(ModelAndView model) {

		List<Clothing> clothingList = clothingDAO.list();
		model.addObject("clothingList", clothingList);
		model.setViewName("index_clothing");
		return model;

	}

	@RequestMapping(value = "/return to products", method = RequestMethod.POST)

	public ModelAndView returnToProducts() {

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/newc", method = RequestMethod.GET)

	public ModelAndView newClothing(ModelAndView model) {

		Clothing newClothing = new Clothing();
		model.addObject("clothing", newClothing);
		model.setViewName("clothing_form");
		return model;

	}

	@RequestMapping(value = "/save clothing", method = RequestMethod.POST)

	public ModelAndView saveClothing(@ModelAttribute Clothing clothing) {
		if (clothing.getClothing_id() == null) {
			clothingDAO.save(clothing);
		} else {
			clothingDAO.update(clothing);
		}

		return new ModelAndView("redirect:/new2");
	}

	@RequestMapping(value = "/edit2", method = RequestMethod.GET)

	public ModelAndView editClothing(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Clothing clothing = clothingDAO.get(id);
		ModelAndView model = new ModelAndView("clothing_form");
		model.addObject("clothing", clothing);

		return model;
	}

	@RequestMapping(value = "/delete2", method = RequestMethod.GET)

	public ModelAndView deleteClothing(@RequestParam Integer id) {
		clothingDAO.delete(id);
		return new ModelAndView("redirect:/new2");
	}
}
