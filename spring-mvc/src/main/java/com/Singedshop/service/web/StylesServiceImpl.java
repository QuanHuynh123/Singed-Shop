package com.Singedshop.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.CategoryDAO;
import com.Singedshop.dto.LittleInforProductDTO;

@Service
public class StylesServiceImpl implements IStylesService{
	
	@Autowired	
	private CategoryDAO category;

	@Override
	public List<LittleInforProductDTO> GetAllProductCategory(int id) {
		return category.GetAllProductCategory(id);
	}

	@Override
	public List<LittleInforProductDTO> GetDataProductPaginate(int id ,int start, int end) {
		return category.GetDataProductPaginate(id,start, end);
	}

}
