package com.Singedshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Singedshop.service.web.CustomUserDetailsService;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider  {
	
	@Autowired
	CustomUserDetailsService userDetail ;
	
    @Autowired
    private BCryptPasswordEncoder  passwordsEncoder;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		 	String presentedPassword =  authentication.getCredentials().toString();  
	        String storedPassword = userDetails.getPassword();
	        
	        System.out.println("PassWord user nhập : " + presentedPassword + "   |     PassWord từ db : " + storedPassword);
	        
	        if (!passwordsEncoder.matches(presentedPassword, storedPassword)) {
	        	System.out.println("mật khẩu sai !");
	            throw new BadCredentialsException("Bad credentials");
	        }	
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		if(username.equals(authentication.getPrincipal())) 
		return userDetail.loadUserByUsername(username);
		else return null ; 
	}

}
