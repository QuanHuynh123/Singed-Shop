package com.Singedshop.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoleDTOMapper implements RowMapper<RoleDTO> {
	@Override
	public RoleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoleDTO role = new RoleDTO();
		role.setIdRole(rs.getInt("idRole"));
		role.setCodeRole(rs.getString("codeRole"));
		role.setNameRole(rs.getString("nameRole"));
		return role;
	} 
}
