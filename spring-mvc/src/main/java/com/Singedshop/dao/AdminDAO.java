package com.Singedshop.dao;

import org.springframework.stereotype.Repository;

import com.Singedshop.dto.ProductDTO;

@Repository
public class AdminDAO extends BaseDAO {
	
	
	public void addProductAdmin(ProductDTO newProduct) {
		String sql= "USE SingedShop\r\n"
				+ "INSERT INTO Product(nameProduct, quantity, price , describe , idStyle , idCategory , image)\r\n"
				+ "VALUES (?,?,?,?,?,?,?);";
	jdbcTemplate.update(sql,newProduct.getNameProduct(), newProduct.getQuantity(),newProduct.getPrice(),newProduct.getDescribe(),newProduct.getIdStyle(),newProduct.getCategory(),"");
	} 
	public void updateProductAdmin(ProductDTO updateProduct) {
		String sql= "Use SingedShop\r\n"
				+ "Update Product Set nameProduct = ?  , quantity = ? , price  = ?, describe  = ?, idStyle = ?, idCategory = ?  Where idProduct  = ?  ";
	jdbcTemplate.update(sql,updateProduct.getNameProduct(),updateProduct.getQuantity(), updateProduct.getPrice(),updateProduct.getDescribe(),updateProduct.getIdStyle(),updateProduct.getCategory(),updateProduct.getIdProduct());
	}
	
	public void deleteProductAdmin(int id) {
		 String sql = "Use SingedShop  DELETE FROM Product WHERE idProduct = ?";
	        jdbcTemplate.update(sql, id);
	}
}
