package com.Singedshop.security.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import com.Singedshop.dto.MyUserDetail;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {
	
	public static Authentication au = (Authentication) (SecurityContextHolder.getContext()).getAuthentication(); 
	public static MyUserDetail my = (MyUserDetail) au.getPrincipal();

    public static String  getNameUser() {       // lấy thông tin người dùng , chính là MyUserDetail để duy trì đăng nhập (principal)
    	/*Authentication  authentication =   (Authentication) (SecurityContextHolder.getContext()).getAuthentication();
    	if(authentication == null) System.out.println("authentication ở session phiên login bị null !");*/
    	
		return my.getFullName() ;
    }
    
    @SuppressWarnings("unchecked")
    public static List<String> getAuthorities() {       					// get role
        List<String> results = new ArrayList<>();     
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());   					// lấy danh sách quyền hạn
        }
        return results;
    }
}
