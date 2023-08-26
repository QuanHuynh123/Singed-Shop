package com.Singedshop.dto;

public class StylesDTO {
	int idStyle ;
	String nameStyle;
	
	public StylesDTO() {
		super();
	}

	public StylesDTO(int idStyle, String nameStyle) {
		super();
		this.idStyle = idStyle;
		this.nameStyle = nameStyle;
	}

	public int getIdStyle() {
		return idStyle;
	}

	public void setIdStyle(int idStyle) {
		this.idStyle = idStyle;
	}

	public String getNameStyle() {
		return nameStyle;
	}

	public void setNameStyle(String nameStyle) {
		this.nameStyle = nameStyle;
	}
	
	
	
	
}
