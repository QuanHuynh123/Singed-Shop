package com.Singedshop.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.UserDTO;

public class UserDTOMapper implements RowMapper<UserDTO> {

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO user = new UserDTO();	
		user.setIdUser(rs.getInt("idUser"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setFullName(rs.getString("fullName"));
		user.setAge(rs.getInt("age"));
		user.setGender(rs.getString("gender"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getLong("phone"));
		user.setStatus(rs.getInt("status"));
		user.setRoles(null);
		return user;
	}
}
