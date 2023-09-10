package com.Singedshop.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import com.Singedshop.dto.RoleDTO;
import com.Singedshop.dto.UserDTO;
import com.Singedshop.service.web.Interface.ILoginService;
import com.Singedshop.constant.SystemConstant;
import com.Singedshop.dto.MyUserDetail;

@Service
public class CustomUserDetailsService implements UserDetailsService   {		// class này chạy đầu tiền trong security

    @Autowired
    private ILoginService userService;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO userDTO = userService.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);	// lấy ra tất cả thông tin của người dùng, user
	      if(userDTO == null){
	            throw new UsernameNotFoundException("Username not found");  
	        }
	      	
	      	List<GrantedAuthority> authorities = new ArrayList<>(); // list chứa role , 1 user có thể chứa nhiều role
	        
	      	for(RoleDTO role: userDTO.getRoles()){
	        	authorities.add(new SimpleGrantedAuthority(role.getCodeRole()));
	        }
	      	
	        // push thông tin  role	
	        MyUserDetail myuser = new MyUserDetail(username,userDTO.getPassword(),true,true,true,true,authorities);
	        myuser.setFullName(userDTO.getFullName());
	        return myuser;
	      	
	        /*
	        UserDetails userDetails = new org.springframework.security.core.userdetails.User( username,userDTO.getPassword(),true,true,true,true,authorities);
	        return userDetails;*/
	}

}
