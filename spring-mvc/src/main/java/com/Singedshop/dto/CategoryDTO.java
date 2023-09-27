package com.Singedshop.dto;

public class CategoryDTO {
	private int idCategory ;
	private String nameCategory;
	
	
	
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CategoryDTO(int idCategory, String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}


	public int getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}


	public String getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	
	
}
