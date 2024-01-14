package com.Singedshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.Singedshop.dto.UserDTO;
import com.Singedshop.service.web.RegisterServiceImpl;

@Controller(value = "LoginController")
public class LoginController  {	
	
	public ModelAndView _mvShare = new ModelAndView();
	
	@Autowired
	RegisterServiceImpl account = new RegisterServiceImpl();
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		_mvShare.setViewName("html/web/login");
		return _mvShare;
	}

	
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("redirect:/login?accessDenied");
    }   // không có role mà dám truy cập
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);         // xóa hết mọi thứ khi logout
        }
        return new ModelAndView("redirect:/login");
    }
    
	
    /////////////////////////////////////////////////////////////////////////// Tạo tài khoản /////////////////////////////////////////////////////////
    
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		_mvShare.setViewName("html/web/register");
		_mvShare.addObject("user", new UserDTO());
		return _mvShare;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView submitRegisterPage(@ModelAttribute("user") UserDTO user) {
		
		if(user.getPhone() == null || user.getPassword() == null)
			_mvShare.addObject("status","Nhập đủ thông tin cần thiết !");
		else {
		int count = account.addAccount(user);
		if(count > 0 )
			_mvShare.addObject("status","Đăng ký thành công !");
		else 
			_mvShare.addObject("status","Đăng ký thất bại !");
		}
		return _mvShare;
	}	
}
