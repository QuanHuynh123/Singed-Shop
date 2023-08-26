package com.Singedshop.dto;

public class LittleInforProductDTO {
	private int idProduct ;
	private String nameProduct;
	private String image;
	private float price;
	private float oldPrice;
	private int Category; 
	private int IdStyle;
	
	public LittleInforProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LittleInforProductDTO(int idProduct, String nameProduct, String image, float price, float oldPrice,
			int category, int idStyle) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.image = image;
		this.price = price;
		this.oldPrice = oldPrice;
		Category = category;
		IdStyle = idStyle;
	}

	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(float oldPrice) {
		this.oldPrice = oldPrice;
	}

	public int getCategory() {
		return Category;
	}
	public void setCategory(int category) {
		Category = category;
	}
	public int getIdStyle() {
		return IdStyle;
	}
	public void setIdStyle(int idStyle) {
		IdStyle = idStyle;
	}
	
	
	
}
