package com.Singedshop.dto.mapper;


import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.StylesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StylesDTOMapper implements RowMapper<StylesDTO> {
		@Override
		public StylesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	 		StylesDTO phongcach = new StylesDTO();
	 		phongcach.setIdStyle(rs.getInt("IDPhongCach"));
	 		phongcach.setNameStyle(rs.getString("TenPhongCach"));
	        return phongcach;
	 	}
	 	
}
