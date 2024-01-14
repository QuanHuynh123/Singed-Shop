package com.Singedshop.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Singedshop.dto.UserDTO;
import com.Singedshop.service.web.ProfileServiceImpl;

@RestController(value = "ProfileAPI")
public class ProfileAPI {
	
	@Autowired
	ProfileServiceImpl profileServiceImpl;
	
	@PostMapping("/api/updateProfile")
	public void  createQuanAO(@RequestBody UserDTO user){
		 profileServiceImpl.updateProfileUser(user);
	};
}
