package com.Singedshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.PaginateDTO;
import com.Singedshop.service.web.HomeServiceImpl;
import com.Singedshop.service.web.PaginateServiceImpl;
import com.Singedshop.service.web.SaleAndViewAllServiceImpl;

import java.util.List;

@Controller(value = "HomeCotroller")
public class HomeController extends BaseController {
	
	@Autowired
	SaleAndViewAllServiceImpl saleAndViewAllServiceImpl;
	@Autowired
	PaginateServiceImpl paginateService ;
	@Autowired
	HomeServiceImpl homeService;
	
	@RequestMapping(value = {"/","/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap modelMap) {
		List<LittleInforProductDTO> listBestSaleQuanAo = homeService.getBestSaleProduct();
		List<LittleInforProductDTO> listNewQuanAo = homeService.getNewProduct();
		modelMap.addAttribute("listBestSaleQuanAo", listBestSaleQuanAo);
		modelMap.addAttribute("listNewQuanAo", listNewQuanAo);
		ModelAndView mav = new ModelAndView("html/web/index");
		return mav;
	}

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
	
	@RequestMapping(value = "/trang-chu/viewAll/{requestId}", method = RequestMethod.GET)
	public ModelAndView newProductPageHome(@PathVariable int requestId , Model modelMap) {
		ModelAndView mav = new ModelAndView("html/web/viewAll");
			int totalData = homeService.getNewProduct().size();
			PaginateDTO paginateInfo = paginateService.getInforPaginate(totalData, 12, 1);
			modelMap.addAttribute("paginateInfo", paginateInfo);
			List<LittleInforProductDTO> productPaginate = saleAndViewAllServiceImpl.getPaginationProductNewProduct(paginateInfo.getStart(), paginateInfo.getEnd());
			modelMap.addAttribute("viewAllProduct", productPaginate);
		return mav;
	}
	@RequestMapping(value = "/trang-chu/viewAll/{requestId}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView newProductPageHome(@PathVariable int requestId  ,@PathVariable int currentPage , ModelMap modelMap ) {
		ModelAndView mav = new ModelAndView("html/web/viewAll");

			int totalData = homeService.getNewProduct().size();
			PaginateDTO paginateInfo = paginateService.getInforPaginate(totalData, 12, currentPage);
			modelMap.addAttribute("paginateInfo", paginateInfo);
			List<LittleInforProductDTO> productPaginate = saleAndViewAllServiceImpl.getPaginationProductNewProduct(paginateInfo.getStart(), paginateInfo.getEnd()); 
			modelMap.addAttribute("viewAllProduct", productPaginate);
		return mav;
	}
	
}