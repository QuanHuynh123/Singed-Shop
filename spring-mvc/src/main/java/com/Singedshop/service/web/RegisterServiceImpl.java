package com.Singedshop.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.UserDAO;
import com.Singedshop.dto.UserDTO;

@Service
public class RegisterServiceImpl implements IRegisterService{
	
	@Autowired
	UserDAO account = new UserDAO();

	@Override
	public int addAccount(UserDTO  user) {
		account.addAccount(user);
		return 1 ;
	}

}
