package com.Singedshop.dto;

public class CartDTO {
	private int quantity;
	private double totalPrice;
	private ProductDTO productDTO ;
	
	public CartDTO() {
	}

	public CartDTO(int quantity, double totalPrice, ProductDTO productDTO) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.productDTO = productDTO;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPice) {
		this.totalPrice = totalPice;
	}


	public ProductDTO getProductDTO() {
		return productDTO;
	}


	public void setProductDTO(ProductDTO quanAoDTO) {
		this.productDTO = quanAoDTO;
	}

	
}
