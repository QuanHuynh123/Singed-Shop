package com.Singedshop.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Singedshop.dto.ProductDTO;
import com.Singedshop.security.utils.MessageUtil;
import com.Singedshop.service.admin.AdminServiceImpl;
import com.Singedshop.service.web.CategoryServiceImpl;
import com.Singedshop.service.web.HomeServiceImpl;


@Controller(value = "AdminController")
public class AdminController {
	@Autowired
	AdminServiceImpl admin ; 
	
	@Autowired
	CategoryServiceImpl category ;
	
	@Autowired
	HomeServiceImpl style ;
	
	@Autowired
	MessageUtil messageUtil ;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap modelMap,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("html/admin/admin");
		List <ProductDTO> getAllProduct = admin.getAllProduct();
		modelMap.addAttribute("getAllProduct",getAllProduct);
		if(request.getParameter("message") != null ) {
			Map<String,String> message =  messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message",message.get("message"));
			mav.addObject("alert",message.get("alert"));
		}
		return mav;
	}
	
	@RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
	public ModelAndView createAdminPage(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer idProduct , @RequestParam(value = "category", required = false) Integer idCategory
		,HttpServletRequest request	) {
		ModelAndView mav = new ModelAndView("html/admin/edit");
		ProductDTO product = new ProductDTO();
		if(idProduct != null) {
			 product = admin.findByIdProduct(idProduct);
		}else {
			product.setIdStyle(0);
			product.setCategory(0);
		}
		
		if(request.getParameter("message") != null ) {
			Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message",message.get("message"));
			mav.addObject("alert",message.get("alert"));
		}
		mav.addObject("idProduct",idProduct);
		mav.addObject("style",style.getStyle());
		mav.addObject("categoryList",category.getCategoryProduct());
		mav.addObject("product",product);
		return mav;
	}
	
}
