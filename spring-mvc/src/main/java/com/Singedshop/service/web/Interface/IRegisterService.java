package com.Singedshop.service.web.Interface;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.UserDTO;

@Service
public interface IRegisterService {
	public int addAccount(UserDTO  user);
}
