package com.Singedshop.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.ProductDTO;
import com.Singedshop.dto.mapper.LittleInforProductDTOMapper;
import com.Singedshop.dto.mapper.ProductDTOMapper;


@Repository
public class ProductDAO extends BaseDAO  {
	
	public ProductDTO getDetailProduct(int id) {
		String sql = "USE SingedShop\r\n"
				+ "SELECT  idProduct,nameProduct, price, image, quantity, describe ,idCategory ,idStyle\r\n"
				+ "FROM Product\r\n"
				+ "Where  idProduct = " +id;

		return jdbcTemplate.queryForObject(sql, new ProductDTOMapper()); 
	}
	
	public List<LittleInforProductDTO> getProductCategory(int idStyle) {
		
		String sql = "USE SingedShop;\r\n"
				+ "SELECT  idProduct ,nameProduct, price, image, quantity, describe ,idCategory , idStyle\r\n"
				+ "FROM Product\r\n"
				+ "WHERE idStyle = " + idStyle ;
		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper()); 
	}
}
