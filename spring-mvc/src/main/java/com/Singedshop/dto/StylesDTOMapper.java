package com.Singedshop.dto;


import org.springframework.jdbc.core.RowMapper;

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
