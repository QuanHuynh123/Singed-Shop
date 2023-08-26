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
import com.Singedshop.dto.ProductDTO;
import com.Singedshop.service.web.ProductServiceImpl;

@Controller(value = "ProductController")
public class ProductController extends BaseController {
	
	@Autowired
	ProductServiceImpl productService;
	
	@RequestMapping(value = "/product/{id}/{idphongcach}", method = RequestMethod.GET)
	public ModelAndView productPage(@PathVariable int id,@PathVariable int idphongcach,  ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("html/web/product/product");
		ProductDTO detailQuanAo = productService.getDetailProduct(id);
		modelMap.addAttribute("detailQuanAo",detailQuanAo);
		List<LittleInforProductDTO> productCategory = productService.getProductCategory(idphongcach);
		modelMap.addAttribute("productCategory",productCategory);
		return mav;
	}
}
