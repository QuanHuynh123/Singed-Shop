package com.Singedshop.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dto.StylesDTO;
import com.Singedshop.dto.LittleInforProductDTO;

@Service
public interface IHomeService {
	@Autowired
	public List<LittleInforProductDTO> getBestSaleProduct();
	public List<LittleInforProductDTO> getNewProduct();
	public List<StylesDTO> getStyleAllProduct();
}
