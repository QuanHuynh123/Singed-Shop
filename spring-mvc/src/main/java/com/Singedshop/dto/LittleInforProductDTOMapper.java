package com.Singedshop.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LittleInforProductDTOMapper implements RowMapper<LittleInforProductDTO> {
	@Override
	public LittleInforProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LittleInforProductDTO display = new LittleInforProductDTO();	
		display.setIdProduct(rs.getInt("idProduct"));
		display.setNameProduct(rs.getString("nameProduct"));
		display.setImage(rs.getString("image"));
		display.setPrice(rs.getFloat("price"));
		display.setCategory(rs.getInt("idCategory"));
		display.setIdStyle(rs.getInt("idStyle"));
		return display;
	}
}
