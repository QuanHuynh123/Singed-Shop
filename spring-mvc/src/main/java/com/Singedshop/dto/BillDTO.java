package com.Singedshop.dto;

import java.util.List;

public class BillDTO {
	private int idBill;
	private String phone;
	private String email;
	private int totalQuanty;
	private String address;
	boolean gender ;
	String orderDate ; 
	boolean status ;
	private double totalAmount;
	BillDetailDTO billDetail ; 
	
	

	public BillDetailDTO getBillDetail() {
		return billDetail;
	}
	public void setBillDetail(BillDetailDTO billDetail) {
		this.billDetail = billDetail;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalQuanty() {
		return totalQuanty;
	}
	public void setTotalQuanty(int totalQuanty) {
		this.totalQuanty = totalQuanty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	} 
	
	
	
}
