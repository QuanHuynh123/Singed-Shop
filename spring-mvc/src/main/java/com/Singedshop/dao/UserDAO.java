package com.Singedshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.Singedshop.constant.SystemConstant;
import com.Singedshop.dto.UserDTO;
import com.Singedshop.dto.RoleDTO;
import com.Singedshop.dto.UserDTOMapper;
import com.Singedshop.dto.RoleDTOMapper;

@Repository
public class UserDAO extends BaseDAO {
	
    @Autowired
    public BCryptPasswordEncoder  passwordEncoder;
	
	public int addAccount(UserDTO user) {
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		System.out.println("Mật khẩu mã hóa vào db : " + encodedPassword );
		
		String sql = "INSERT INTO Users (phone, password, fullName, status) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getPhone(), encodedPassword, user.getFullName(), SystemConstant.ACTIVE_STATUS);
		return 1;
	}	
	
	public UserDTO findOneByUserNameAndStatus(String phone, int status) {
	    String sql = "SELECT U.idUser, U.fullName, U.phone, U.password, U.gender, U.address, U.yearOld, U.email, "
	            + "UR.idRole, R.codeRole, R.nameRole, U.status "
	            + "FROM Users U "
	            + "JOIN User_Role UR ON U.idUser = UR.idUser "
	            + "JOIN Role R ON UR.idRole = R.idRole "
	            + "WHERE U.phone = ? AND U.status = ?";

	    List<UserDTO> users = jdbcTemplate.query(sql, new Object[]{phone, status}, new UserDTOMapper());
	    return users.isEmpty() ? null : users.get(0);
	}

	
	public List<RoleDTO> findRoleUser(int idUser) {
		String sql ="SELECT UR.idUser, UR.idRole, R.codeRole, R.nameRole\r\n"
				+ "FROM [SingedShop].[dbo].[User_Role] UR\r\n"
				+ "JOIN [SingedShop].[dbo].[Role] R ON UR.idRole = R.idRole\r\n"
				+ "Where idUser  = " + idUser ; 
			
		return jdbcTemplate.query(sql, new RoleDTOMapper()); 
	}
}
