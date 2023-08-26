package com.Singedshop.dto;

public class RoleDTO {
	private int idRole;
    private String codeRole;
    private String nameRole;
    
    
    
    
    
	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleDTO(int idRole, String codeRole, String nameRole) {
		super();
		this.idRole = idRole;
		this.codeRole = codeRole;
		this.nameRole = nameRole;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getCodeRole() {
		return codeRole;
	}
	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
    
    
}
