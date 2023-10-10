package com.Singedshop.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.LittleInforProductDAO;
import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.service.web.Interface.ISaleAndViewAllService;

@Service
public class SaleAndViewAllServiceImpl implements ISaleAndViewAllService {
	
	@Autowired
	LittleInforProductDAO littleInforProductDAO ;
	
	@Override
	public List<LittleInforProductDTO> getAllSaleProduct() {
		return littleInforProductDAO.getAllProductSale();
	}

	@Override
	public List<LittleInforProductDTO> getPaginationProductNewProduct(int start, int end) {
		return littleInforProductDAO.getPaginationProductNewProduct(start,end);
	}

	@Override
	public List<LittleInforProductDTO> getPaginationSaleProduct(int start, int end) {
		return littleInforProductDAO.getPaginationProductSale(start,end);
	}

}
