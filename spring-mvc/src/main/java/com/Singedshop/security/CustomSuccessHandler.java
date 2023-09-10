package com.Singedshop.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.Singedshop.security.utils.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {   // xử lý việc sau khi xác thực thành công, bắt đầu phân quyền authorilation
	
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
 
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            System.out.println("Đăng nhập không thành công !");
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    public String determineTargetUrl(Authentication authentication) { 		//	trả về mục tiêu theo ROLE nếu tài khoản hợp lệ
    	  	    	
    	 List<String> roles = SecurityUtils.getAuthorities();
    	 if(isAdmin(roles)) {
    		 return "/admin";
    	 }
    	 else if(isUser(roles)) {
    		 return "/trang-chu";
    	 }
    	 return null ; 
    }   
    
    private boolean isAdmin(List<String> roles) {
    	if(roles.contains("ADMIN")) {
    		return true;
    	}
    	return false;
    }
    
    private boolean isUser(List<String> roles) {
    	if(roles.contains("USER")) {
    		return true;
    	}
    	return false;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

}
