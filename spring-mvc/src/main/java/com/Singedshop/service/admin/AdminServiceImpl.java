package com.Singedshop.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Singedshop.dao.AdminDAO;
import com.Singedshop.dao.ProductDAO;
import com.Singedshop.dto.ProductDTO;

@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	ProductDAO product ;
	
	@Autowired
	AdminDAO admin ; 
	
	@Override
	public List<ProductDTO> getAllProduct() {
		return product.getAllProduct();
	}
	
	@Override
	public ProductDTO findByIdProduct(int id) {
		return product.getDetailProduct(id);
	}

	@Override
	@Transactional
	public ProductDTO insert(ProductDTO newProduct) {
		try {
		admin.addProductAdmin(newProduct);
		return newProduct;
		}catch(Exception e) {
			throw new RuntimeException("Lỗi trong quá trình thêm sản phẩm", e);
		}
	}

	@Override
	@Transactional
	public ProductDTO update(ProductDTO updateProduct) {
		try {
		admin.updateProductAdmin(updateProduct);
		return updateProduct ;
		}catch(Exception e ) {
			throw new RuntimeException("Lỗi trong quá trình thêm sản phẩm", e);
		}
	}

	@Override
	@Transactional
	public void delete(int[] ids) {
		try {
			for(int id : ids) 
				admin.deleteProductAdmin(id);
			
		}catch(Exception e ) {
			throw new RuntimeException("Lỗi trong quá trình thêm sản phẩm", e);
		}
	}


}
