package com.Singedshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import com.Singedshop.dto.LittleInforProductDTO;

import java.util.List;

@Controller(value = "HomeCotroller")
public class HomeController extends BaseController {
	
	@RequestMapping(value = {"/","/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap modelMap) {
		List<LittleInforProductDTO> listBestSaleQuanAo = homeService.getBestSaleProduct();
		List<LittleInforProductDTO> listNewQuanAo = homeService.getNewProduct();
		modelMap.addAttribute("listBestSaleQuanAo", listBestSaleQuanAo);
		modelMap.addAttribute("listNewQuanAo", listNewQuanAo);
		ModelAndView mav = new ModelAndView("html/web/index");
		return mav;
	}

	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public ModelAndView salePage() {
		ModelAndView mav = new ModelAndView("html/web/sale");
		return mav;
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public ModelAndView payPage() {
		ModelAndView mav = new ModelAndView("html/web/product/pay");
		return mav;
	}

}