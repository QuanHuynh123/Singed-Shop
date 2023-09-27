package com.Singedshop.service.web.Interface;


import java.util.List;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.ProductDTO;

@Service
public interface IProductService {
	public ProductDTO getDetailProduct(int id);
	public List<LittleInforProductDTO> getProductCategory(int idPhongCach);
}
