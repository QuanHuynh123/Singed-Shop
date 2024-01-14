package com.Singedshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.PaginateDTO;
import com.Singedshop.service.web.StyleServiceImpl;
import com.Singedshop.service.web.PaginateServiceImpl;

@Controller(value = "CategoryController")
public class StyleController extends BaseController{
	
	@Autowired
	StyleServiceImpl styleService ;
	@Autowired
	PaginateServiceImpl paginateService ;
	
	@RequestMapping(value = "/trang-chu/style/{id}", method = RequestMethod.GET)
	public ModelAndView stylePage(@PathVariable int id, ModelMap modelMap ) {
		ModelAndView mav = new ModelAndView("html/web/product/style");
		mav.addObject("id",id);

		int totalData = styleService.GetAllProductCategory(id).size();
		PaginateDTO paginateInfo = paginateService.getInforPaginate(totalData, 8, 1);
		modelMap.addAttribute("idPhongCach", id);
		modelMap.addAttribute("paginateInfo", paginateInfo);
		List<LittleInforProductDTO> productPaginate = styleService.GetDataProductPaginate(id , paginateInfo.getStart(), paginateInfo.getEnd()); 
		modelMap.addAttribute("productPaginate", productPaginate );
		return mav;
	}
	
	@RequestMapping(value = "/trang-chu/style/{id}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView stylePage(@PathVariable int id ,@PathVariable int currentPage , ModelMap modelMap ) {
		ModelAndView mav = new ModelAndView("html/web/product/style");
		mav.addObject("id",id); 
		
		int totalData = styleService.GetAllProductCategory(id).size();
		PaginateDTO paginateInfo = paginateService.getInforPaginate(totalData, 8, currentPage);
		modelMap.addAttribute("idPhongCach", id);
		modelMap.addAttribute("paginateInfo", paginateInfo);
		List<LittleInforProductDTO> productPaginate = styleService.GetDataProductPaginate(id , paginateInfo.getStart(), paginateInfo.getEnd()); 
		modelMap.addAttribute("productPaginate", productPaginate );
		return mav;
	}
}
