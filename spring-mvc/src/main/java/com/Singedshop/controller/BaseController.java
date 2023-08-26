package com.Singedshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Singedshop.dto.StylesDTO;
import com.Singedshop.service.web.HomeServiceImpl;

@Controller
public class BaseController {
	
	@Autowired 
	HomeServiceImpl homeService ;
	
	@ModelAttribute("listPhongCach")
	public List<StylesDTO> getListPhongCach() {
	    return homeService.getStyleAllProduct();
	}
}
