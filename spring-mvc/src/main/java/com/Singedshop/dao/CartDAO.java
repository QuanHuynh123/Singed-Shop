package com.Singedshop.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Singedshop.dto.CartDTO;
import com.Singedshop.dto.ProductDTO;

@Repository
public class CartDAO extends BaseDAO {

	@Autowired
	ProductDAO productDAO = new ProductDAO();

	public HashMap<Long, CartDTO> AddCart(long id, HashMap<Long, CartDTO> cart) {

		CartDTO itemCart = new CartDTO();
		ProductDTO product = productDAO.getDetailProduct((int) id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity()+1);
			itemCart.setTotalPrice(itemCart.getQuantity()*itemCart.getProductDTO().getPrice());
		} else {
			itemCart.setProductDTO(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDTO> EditCart(long id, int quanty, HashMap<Long, CartDTO> cart) {
		if (cart == null) {
			return cart;
		}
		CartDTO itemCart = new CartDTO();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quanty);
			double totalPrice = quanty * itemCart.getProductDTO().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDTO> DeleteCart(long id, HashMap<Long, CartDTO> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public HashMap<Long, CartDTO> DeleteAllCart( HashMap<Long, CartDTO> cart) {
		cart.clear();
		return cart;
	}

	public int TotalQuanty(HashMap<Long, CartDTO> cart) {
		int totalQuanty = 0;
		for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) { // Map đại diện 1 phần tử trong cart
			totalQuanty += itemCart.getValue().getQuantity();
		}
		return totalQuanty;
	}

	public double TotalPrice(HashMap<Long, CartDTO> cart) {
		double totalPrice = 0;
		for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) { // Map đại diện 1 phần tử trong cart
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
