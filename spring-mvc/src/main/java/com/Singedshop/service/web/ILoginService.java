package com.Singedshop.service.web;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.UserDTO;

@Service
public interface ILoginService {
    UserDTO findOneByUserNameAndStatus(String name, int status);
}
