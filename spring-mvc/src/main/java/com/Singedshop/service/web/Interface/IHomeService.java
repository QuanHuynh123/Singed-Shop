package com.Singedshop.service.web.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dto.StylesDTO;
import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.ProductDTO;

@Service
public interface IHomeService {
	@Autowired
	public List<LittleInforProductDTO> getBestSaleProduct();
	public List<LittleInforProductDTO> getNewProduct();
	public List<StylesDTO> getStyle();
	public List<LittleInforProductDTO> searchProduct(String keySearch);
}
