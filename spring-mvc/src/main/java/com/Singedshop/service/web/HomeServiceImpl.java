package com.Singedshop.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.LittleInforProductDAO;
import com.Singedshop.dao.ProductDAO;
import com.Singedshop.dto.StylesDTO;
import com.Singedshop.service.web.Interface.IHomeService;
import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.ProductDTO;

@Service
public class HomeServiceImpl implements  IHomeService {
	
	@Autowired
	private LittleInforProductDAO littleInforProductDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<LittleInforProductDTO> getBestSaleProduct() {
			return littleInforProductDAO.getBestSaleProduct();
	}

	@Override
	public List<LittleInforProductDTO> getNewProduct() {
		return littleInforProductDAO.getNewProduct();
	}

	@Override
	public List<StylesDTO> getStyle() {
		return littleInforProductDAO.getStyle();
	}

	@Override
	public List<LittleInforProductDTO> searchProduct(String keySearch) {
		return productDAO.searchProduct(keySearch);
	}
	
	
}
