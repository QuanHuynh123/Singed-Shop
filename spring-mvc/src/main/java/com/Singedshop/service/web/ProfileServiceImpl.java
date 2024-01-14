package com.Singedshop.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.UserDAO;
import com.Singedshop.dto.UserDTO;
import com.Singedshop.service.web.Interface.IProfileService;

@Service
public class ProfileServiceImpl implements IProfileService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void updateProfileUser(UserDTO userDTO) {
		
		userDAO.updateProfileUser(userDTO);
	}
	
	

}
