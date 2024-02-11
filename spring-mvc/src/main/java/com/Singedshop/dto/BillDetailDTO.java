package com.Singedshop.dto;

public class BillDetailDTO {
	private int idBillDetail ; 
	private int quanty;
	private double totalPrice;
	private int idProduct ; 
	private String nameProduct ; 
	private int idCategory ;
	private long idBill ; 
	private String image;
	
	public BillDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdBillDetail() {
		return idBillDetail;
	}
	
	public void setIdBillDetail(int idBillDetail) {
		this.idBillDetail = idBillDetail;
	}
	
	public int getQuanty() {
		return quanty;
	}
	
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;

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
	
	public int getIdCategory() {
		return idCategory;
	}
	
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public long getIdBill() {
		return idBill;
	}
	
	public void setIdBill(long idBill2) {
		this.idBill = idBill2;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	} 
	
	
	
	
}
