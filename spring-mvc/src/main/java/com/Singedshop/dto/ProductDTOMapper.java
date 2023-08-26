package com.Singedshop.dto;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDTOMapper implements RowMapper<ProductDTO> {
	@Override
	public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDTO quanAoDTO = new ProductDTO();
		quanAoDTO.setIdProduct(rs.getInt("idProduct"));
		quanAoDTO.setNameProduct(rs.getString("nameProduct"));
		quanAoDTO.setPrice(rs.getFloat("price"));
		quanAoDTO.setImage(rs.getString("image"));
		quanAoDTO.setQuantity(rs.getInt("quantity"));
		quanAoDTO.setDescribe(rs.getString("describe"));
		quanAoDTO.setCategory(rs.getInt("idCategory"));
		quanAoDTO.setIdStyle(rs.getInt("idStyle"));
		return quanAoDTO;
	}
}
