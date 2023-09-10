/*
package com.Singedshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;

import com.Singedshop.service.web.CustomUserDetailsService;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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
	        String storedPassword = userDetails.getPassword().toString();     
	        System.out.println("chạy trước khi so sánh !");
	        if (!passwordsEncoder.matches(presentedPassword, storedPassword)) {
	        	System.out.println("sai mk");
	            throw new BadCredentialsException("Bad credentials");
	        }
	        else {
	        	Authentication SessionAuthentication= new UsernamePasswordAuthenticationToken(userDetails, presentedPassword, userDetails.getAuthorities()) ; 
	        	System.out.println("ahahah"  + SessionAuthentication.getPrincipal());
	        	//SecurityContextHolder.getContext().setAuthentication(SessionAuthentication);
	        }
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		if(username.equals(authentication.getPrincipal())) 
		return userDetail.loadUserByUsername(username);
		else return null ; 
	}

}	*/
