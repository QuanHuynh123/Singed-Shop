package com.Singedshop.service.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.CategoryDAO;
import com.Singedshop.dto.CategoryDTO;
import com.Singedshop.service.web.Interface.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	CategoryDAO category ;
		
	@Override
	public Map<String,String> getCategoryProduct() {
		Map<String,String> result = new HashMap<>();
		List<CategoryDTO> category1 = category.getCategory(); 
		if(category1 == null) return null; 
		for(CategoryDTO item : category1) {
			result.put(Integer.toString(item.getIdCategory()),item.getNameCategory());
		}
		return result ;
	}
	
}
