package com.Singedshop.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.ProductDTO;

@Service
public interface IAdminService {
	public List<ProductDTO> getAllProduct();
	public ProductDTO findByIdProduct(int id);
	ProductDTO insert(ProductDTO newProduct);
	ProductDTO update(ProductDTO updateProduct);
	void delete(int[] ids);
}
