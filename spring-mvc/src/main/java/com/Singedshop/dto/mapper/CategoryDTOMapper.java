package com.Singedshop.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.CategoryDTO;

public class CategoryDTOMapper implements RowMapper<CategoryDTO> {
	@Override
	public CategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryDTO category = new CategoryDTO();
		category.setIdCategory(rs.getInt("IDLoai"));
		category.setNameCategory(rs.getString("TenLoai"));
        return category;
 	}
 	
}
