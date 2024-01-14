package com.Singedshop.dto;
import java.util.ArrayList;
import java.util.List;


public class UserDTO  {
	private int idUser ;	
	Long  phone;
	String password;
	String email;
	private String fullName;
	int age;
	String gender;
	String address;
	int status ;
	private List<RoleDTO> roles = new ArrayList<>();
	
	String confirmPassword;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int idUser, Long phone, String password, String email, String fullName, int age, String gender,
			String address,int status,  List<RoleDTO> roles) {
		super();
		this.idUser = idUser;
		this.phone = phone;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.roles = roles;
		this.status = status;
	}
	
	

	public UserDTO(Long phone, String password, String fullName) {
		super();
		this.phone = phone;
		this.password = password;
		this.fullName = fullName;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
