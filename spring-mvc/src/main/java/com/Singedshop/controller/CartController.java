package com.Singedshop.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Singedshop.service.web.PayServiceImpl;
import com.Singedshop.service.web.CartServiceImpl;
import com.Singedshop.dto.BillDTO;
import com.Singedshop.dto.CartDTO;

@Controller(value = "CartController")
public class CartController extends BaseController {
	
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl() ;
	@Autowired
	private PayServiceImpl payService = new PayServiceImpl();
	
	@RequestMapping(value = "/trang-chu/cart", method = RequestMethod.GET)
	public ModelAndView cartPage() {
		ModelAndView mav = new ModelAndView("html/web/cart");
		return mav;
	}
	
	@RequestMapping(value = "Addcart/{id}/{idStyle}", method = RequestMethod.GET)
	public String AddCart(HttpServletRequest request,HttpSession session , @PathVariable long id , @PathVariable int  idStyle ,  ModelMap modelMap  ) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("CartSinged");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("CartSinged", cart);
		session.setAttribute("TotalQuantityCartSinged", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCartSinged",cartService.TotalPrice(cart));
		return "redirect:/trang-chu/product/"+id +"/"+idStyle;
		//return "redirect:"+request.getHeader("Referer"); 			// trở lại đường dẫn trước đó khi add card , liên quan tới  HttpServletRequest
	}
	
	@RequestMapping(value = "Deletecart/{id}", method = RequestMethod.GET)
	public String DeleteCart(HttpServletRequest request,HttpSession session , @PathVariable long id , ModelMap modelMap ) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("CartSinged");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("CartSinged", cart);
		session.setAttribute("TotalQuantityCartSinged", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCartSinged",cartService.TotalPrice(cart));
		return "redirect:/trang-chu/cart";
	}
	
	@RequestMapping(value = "DeleteAllcart", method = RequestMethod.GET)
	public String DeleteAllCart(HttpServletRequest request,HttpSession session , ModelMap modelMap  ) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("CartSinged");
	
		cart = cartService.DeleteAllCart(cart);
		session.setAttribute("CartSinged", cart);
		session.setAttribute("TotalQuantityCartSinged", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCartSinged",cartService.TotalPrice(cart));
		return "redirect:/trang-chu/cart";

	}
	
	@RequestMapping(value = "Editcart/{id}/{quantity}", method = RequestMethod.GET)
	public String EditCart(HttpServletRequest request,HttpSession session , @PathVariable long id , @PathVariable int quantity , ModelMap modelMap  ) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("CartSinged");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.EditCart(id, quantity, cart);
		session.setAttribute("CartSinged", cart);
		session.setAttribute("TotalQuantityCartSinged", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCartSinged",cartService.TotalPrice(cart));
		return "redirect:/trang-chu/cart";
	}
	
	@RequestMapping(value = "/trang-chu/pay", method = RequestMethod.GET)
	public ModelAndView payPage(HttpServletRequest request,HttpSession session ) {
		ModelAndView mav = new ModelAndView("html/web/product/pay");
		mav.addObject("bill", new BillDTO());
		return mav;
	}
	
	@RequestMapping(value = "/trang-chu/pay", method = RequestMethod.POST)
	public String getPayPage(HttpServletRequest request,HttpSession session , @ModelAttribute("bill") BillDTO bill ) {
		//bill.setQuanty(Integer.parseInt((String) session.getAttribute("TotalQuantityCartSinged")));
		bill.setQuanty((Integer) session.getAttribute("TotalQuantityCartSinged"));

		bill.setTotalAmount((Double )session.getAttribute("TotalPriceCartSinged"));
		if(payService.addBill(bill) > 0 ) {
			HashMap<Long, CartDTO> cart = (HashMap<Long,CartDTO>)session.getAttribute("CartSinged");
			payService.addBillDetail(cart);
		}
		session.removeAttribute("CartSinged");
		return "redirect:/trang-chu/cart";
	}
}
