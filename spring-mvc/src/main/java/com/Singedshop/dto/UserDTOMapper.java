package com.Singedshop.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserDTOMapper implements RowMapper<UserDTO> {

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO user = new UserDTO();	
		user.setIdUser(rs.getInt("idUser"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setFullName(rs.getString("fullName"));
		user.setYearOld(rs.getInt("yearOld"));
		user.setGender(rs.getBoolean("gender"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getLong("phone"));
		user.setStatus(rs.getInt("status"));
		user.setRoles(null);
		return user;
	}
}
