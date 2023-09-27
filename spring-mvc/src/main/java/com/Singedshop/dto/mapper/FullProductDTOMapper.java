package com.Singedshop.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.ProductDTO;

public class FullProductDTOMapper implements RowMapper<ProductDTO> {
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
		quanAoDTO.setIdStyle(rs.getInt("idStyle"));
		quanAoDTO.setOldPrice(rs.getFloat("oldPrice"));
		quanAoDTO.setDateCreate(rs.getString("Date"));
		return quanAoDTO;
	}
}
