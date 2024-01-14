package com.Singedshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Singedshop.dto.UserDTO;
import com.Singedshop.security.utils.SecurityUtils;
import com.Singedshop.service.web.LoginServiceImpl;

@Controller(value = "UserController")
public class UserController extends BaseController{

	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView getInforUser(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("html/user/profile");
		UserDTO userProfile = loginServiceImpl.findOneByUserNameAndStatus(SecurityUtils.my.getUsername(), 1);
		modelMap.addAttribute("userProfile",userProfile);
		return mav;
	}
}
