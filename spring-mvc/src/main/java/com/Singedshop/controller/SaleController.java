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
import com.Singedshop.service.web.PaginateServiceImpl;
import com.Singedshop.service.web.SaleAndViewAllServiceImpl;

@Controller(value = "SaleController")
public class SaleController extends BaseController{
	
	@Autowired
	SaleAndViewAllServiceImpl saleAndViewAllServiceImpl;
	@Autowired
	PaginateServiceImpl paginateService ;
	
	@RequestMapping(value = "/trang-chu/sale", method = RequestMethod.GET)
	public ModelAndView salePage(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("html/web/sale");
		int totalData = saleAndViewAllServiceImpl.getAllSaleProduct().size();
		PaginateDTO paginateInfo = paginateService.getInforPaginate(totalData, 12, 1);
		modelMap.addAttribute("paginateInfo", paginateInfo);
		List<LittleInforProductDTO> productPaginate = saleAndViewAllServiceImpl.getPaginationSaleProduct(paginateInfo.getStart(), paginateInfo.getEnd());
		modelMap.addAttribute("viewAllProduct", productPaginate);
		return mav;
	}
	
	@RequestMapping(value = "/trang-chu/sale/{currentPage}", method = RequestMethod.GET)
	public ModelAndView salePage(ModelMap modelMap, @PathVariable int currentPage) {
		ModelAndView mav = new ModelAndView("html/web/sale");
		int totalData = saleAndViewAllServiceImpl.getAllSaleProduct().size();
		PaginateDTO paginateInfo = paginateService.getInforPaginate(totalData, 12, currentPage);
		modelMap.addAttribute("paginateInfo", paginateInfo);
		List<LittleInforProductDTO> productPaginate = saleAndViewAllServiceImpl.getPaginationSaleProduct(paginateInfo.getStart(), paginateInfo.getEnd());
		modelMap.addAttribute("viewAllProduct", productPaginate);
		return mav;
	}

}
