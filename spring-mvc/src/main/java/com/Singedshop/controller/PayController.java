package com.Singedshop.controller;

import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Singedshop.dto.BillDTO;
import com.Singedshop.dto.CartDTO;
import com.Singedshop.service.web.CartServiceImpl;
import com.Singedshop.service.web.PayServiceImpl;
import com.Singedshop.service.web.SendEmailServiceImpl;

@Controller( value = "PayController")
public class PayController extends BaseController {
	
	@Autowired
	private PayServiceImpl payService = new PayServiceImpl();
	
	@Autowired
	private CartServiceImpl cartServiceImpl; 
	
	@Autowired
	private SendEmailServiceImpl emailServiceImpl;
	
	// Mua trực tiếp 1 sản phẩm
	@RequestMapping(value = "/trang-chu/pay/{id}", method = RequestMethod.GET)	
	public ModelAndView payNowProduct(@PathVariable int id , HttpServletRequest request,HttpSession session ) {
		
		ModelAndView mav = new ModelAndView("html/web/product/pay");
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		
		cartServiceImpl.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartServiceImpl.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart",cartServiceImpl.TotalPrice(cart));
		mav.addObject("bill", new BillDTO());
		return mav;
	}
	
	// Mua sản phẩm từ giỏ hàng
	@RequestMapping(value = "/trang-chu/pay", method = RequestMethod.GET)
	public ModelAndView payPage(HttpServletRequest request,HttpSession session ) {
		ModelAndView mav = new ModelAndView("html/web/product/pay");
		
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		if( cart.size() == 0) {
			return mav = new ModelAndView("html/web/cart");
		}

		session.setAttribute("Cart",cart);
		mav.addObject("bill", new BillDTO());
		return mav;
	}
	
	// POST thông tin để tạo hóa đơn đặt hàng hoặc dùng API để POST cũng được
	@RequestMapping(value = "/trang-chu/pay", method = RequestMethod.POST)
	public String getPayPage(HttpServletRequest request, HttpSession session , @ModelAttribute("bill") BillDTO bill , ModelMap modelMap, RedirectAttributes redirectAttributes) {
		
		//bill.setQuanty(Integer.parseInt((String) session.getAttribute("TotalQuantityCart")));
		bill.setTotalQuanty((Integer) session.getAttribute("TotalQuantityCart"));
		bill.setTotalPrice((Double )session.getAttribute("TotalPriceCart"));
		
		if (bill.hasNullFields()) {
	        // Nếu có ít nhất một thuộc tính là null, thực hiện thông báo lỗi
	        // Sử dụng model để truyền thông báo lỗi về view
			redirectAttributes.addFlashAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin");
			return "redirect:/trang-chu/pay";
	    }
		
		String product =  ""; 
		
		HashMap<Long, CartDTO> cart = (HashMap<Long,CartDTO>)session.getAttribute("Cart");
		if(payService.addBill(bill) > 0 ) {
			payService.addBillDetail(cart);
		}
		
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			product += itemCart.getValue().getProductDTO().getNameProduct() + " | Số lượng " + itemCart.getValue().getProductDTO().getQuantity() +  "<br>";
					
		}
		
		String contenEmail = "Thông tin mua hàng gồm : <br>" + product; 
							
		emailServiceImpl.sendEmail("huynhminhquan07072002@gmail.com",bill.getEmail(),"Thông tin mua hàng",product );
		
		session.removeAttribute("Cart");
		session.setAttribute("TotalQuantityCart", 0);
		session.setAttribute("TotalPriceCart",0);
		
		redirectAttributes.addFlashAttribute("alert", "Mua hàng thành công");
		return "redirect:/trang-chu/cart";
	}
}
