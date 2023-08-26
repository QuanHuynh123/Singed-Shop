package com.Singedshop.security.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.Singedshop.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {

    public static UserDTO getPrincipal() {         							// lấy thông tin người dùng , chính là MyUserDetail
        return (UserDTO) (SecurityContextHolder
                .getContext()).getAuthentication().getPrincipal();
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
