package com.Singedshop.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.UserDAO;
import com.Singedshop.dto.UserDTO;
import com.Singedshop.service.web.Interface.IRegisterService;

@Service
public class RegisterServiceImpl implements IRegisterService{
	
	@Autowired
	UserDAO account = new UserDAO();

	@Override
	public int addAccount(UserDTO  user) {
		if(account.addAccount(user) < 0  ) return 0;
		return 1 ;
	}

}
