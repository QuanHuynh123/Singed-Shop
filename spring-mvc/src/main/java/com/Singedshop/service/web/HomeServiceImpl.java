package com.Singedshop.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.LittleInforProductDAO;
import com.Singedshop.dto.StylesDTO;
import com.Singedshop.service.web.Interface.IHomeService;
import com.Singedshop.dto.LittleInforProductDTO;

@Service
public class HomeServiceImpl implements  IHomeService {
	
	@Autowired
	private LittleInforProductDAO quanaoDAo;

	@Override
	public List<LittleInforProductDTO> getBestSaleProduct() {
			return quanaoDAo.getBestSaleProduct();
	}

	@Override
	public List<LittleInforProductDTO> getNewProduct() {
		return quanaoDAo.getNewProduct();
	}

	@Override
	public List<StylesDTO> getStyle() {
		return quanaoDAo.getStyle();
	}

	
}
