package com.Singedshop.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.UserDTO;

public class RegisterMapper implements RowMapper<UserDTO> {
	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO user = new UserDTO();	
		user.setPhone(rs.getLong("phone"));
		user.setPassword(rs.getString("password"));
		user.setFullName(rs.getString("fullName"));
		return user;
	}
}
