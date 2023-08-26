package com.Singedshop.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.UserDAO;
import com.Singedshop.dto.UserDTO;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	UserDAO account  ;
	
	@Override
	public UserDTO findOneByUserNameAndStatus(String name, int status) {
		UserDTO user = new UserDTO();
		user = account.findOneByUserNameAndStatus(name, status);
		if(user != null) { user.setRoles(account.findRoleUser(user.getIdUser()));
		return user; }
		else return null ;
	}


}
