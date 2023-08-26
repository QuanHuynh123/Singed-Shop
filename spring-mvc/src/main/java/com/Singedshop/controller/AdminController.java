package com.Singedshop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller(value = "AdminController")
public class AdminController {
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("html/admin/admin");
		return mav;
	}
}
