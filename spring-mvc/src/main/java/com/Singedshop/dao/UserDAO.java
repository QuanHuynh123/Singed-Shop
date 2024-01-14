package com.Singedshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.Singedshop.constant.SystemConstant;
import com.Singedshop.dto.UserDTO;
import com.Singedshop.dto.ProductDTO;
import com.Singedshop.dto.RoleDTO;
import com.Singedshop.dto.mapper.RoleDTOMapper;
import com.Singedshop.dto.mapper.UserDTOMapper;

@Repository
public class UserDAO extends BaseDAO {
	
	@Autowired
	private BCryptPasswordEncoder  passwordEncoder ;
	
//	@Autowired
//	private Md5PasswordEncoder md5Encoder;
	
	 public int addAccount(UserDTO user) {
	    	
	        if (isPhoneExist(user.getPhone())) {
	    	        return -1; 	}
	    	
//	    	String hashPass = md5Encoder.encodePassword(user.getPassword(), null);
	        String hashPass = passwordEncoder.encode(user.getPassword());
			
			String sql = "INSERT INTO Users (phone, password, fullName, status) VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, user.getPhone(), hashPass, user.getFullName(), SystemConstant.ACTIVE_STATUS);
			addRoleAccount(user.getPhone());
			return 1;
	}
    
    private boolean isPhoneExist(Long phone) {
        String sql = "SELECT COUNT(*) FROM Users WHERE phone = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{phone}, Integer.class);
        return count > 0;
    }
    
    public void addRoleAccount(Long  phone) {
    	
    	int idUser = findIdUser(phone);
		String sql = "Insert into User_Role(idUser,idRole) values(?,?);";
		jdbcTemplate.update(sql, idUser, 2);
	}	
    
    public int findIdUser(Long phone) {
        String sql = "USE SingedShop;\r\n"
                + "SELECT idUser FROM Users \r\n"
                + "WHERE phone = ?";
        int idUser = jdbcTemplate.queryForObject(sql, new Object[]{phone}, Integer.class);
        return idUser;
    }

	
	public UserDTO findOneByUserNameAndStatus(String phone, int status) {
	    String sql = "USE SingedShop SELECT U.idUser, U.fullName, U.phone, U.password, U.gender, U.address, U.age, U.email,"
	            + "UR.idRole, R.codeRole, R.nameRole, U.status "
	            + "FROM Users U JOIN User_Role UR ON U.idUser = UR.idUser "
	            + "JOIN Role R ON UR.idRole = R.idRole WHERE U.phone = ? AND U.status = ? ";

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
	
	public void updateProfileUser(UserDTO userDTO) {
		String sql= "Use SingedShop Update Users Set phone = ? , address = ?  , email = ? , gender  = ?, age  = ?  Where phone = ?  ";
	jdbcTemplate.update(sql,  userDTO.getPhone(),userDTO.getAddress() , userDTO.getEmail(),userDTO.getGender(),userDTO.getAge(),userDTO.getPhone());
	}
}
