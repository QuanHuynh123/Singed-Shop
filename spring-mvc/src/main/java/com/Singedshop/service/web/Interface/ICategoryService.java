package com.Singedshop.service.web.Interface;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {
	
	public Map<String,String> getCategoryProduct();
}