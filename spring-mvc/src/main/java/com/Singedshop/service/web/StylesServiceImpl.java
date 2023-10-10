package com.Singedshop.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.StyleDAO;
import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.service.web.Interface.IStylesService;

@Service
public class StylesServiceImpl implements IStylesService{
	
	@Autowired	
	private StyleDAO category;

	@Override
	public List<LittleInforProductDTO> GetAllProductCategory(int id) {
		return category.GetAllProductCategory(id);
	}

	@Override
	public List<LittleInforProductDTO> GetDataProductPaginate(int id ,int start, int end) {
		return category.GetDataProductPaginate(id,start, end);
	}

}
