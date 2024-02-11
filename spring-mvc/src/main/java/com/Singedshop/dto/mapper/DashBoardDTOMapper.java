package com.Singedshop.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.DashBoardDTO;


public class DashBoardDTOMapper implements RowMapper<DashBoardDTO>{
	
	@Override
	public DashBoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DashBoardDTO dashboard = new DashBoardDTO();
		dashboard.setMonth(rs.getInt("month"));
		dashboard.setQuantity(rs.getInt("quantity"));
		return dashboard;
	}
}
