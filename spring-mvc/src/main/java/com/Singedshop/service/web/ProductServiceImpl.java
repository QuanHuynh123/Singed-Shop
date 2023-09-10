package com.Singedshop.service.web;

import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.ProductDTO;
import com.Singedshop.service.web.Interface.IProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.ProductDAO;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	ProductDAO product = new ProductDAO();
	
	@Override
	public ProductDTO  getDetailProduct(int id) {
		ProductDTO detailProduct =  product.getDetailProduct(id);
		return detailProduct;
	}

	@Override
	public List<LittleInforProductDTO> getProductCategory(int idPhongCach) {
		
		return product.getProductCategory(idPhongCach);
	}

}
