package com.Singedshop.dao;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Singedshop.dto.CartDTO;
import com.Singedshop.dto.ProductDTO;

@Repository
public class CartDAO extends BaseDAO {

	@Autowired
	ProductDAO productDAO  ;
	
	DecimalFormat decimalFormat = new DecimalFormat("#.##");

	public HashMap<Long, CartDTO> AddCart(Long id, HashMap<Long, CartDTO> cart) {

		CartDTO itemCart = new CartDTO();
	
		ProductDTO product = productDAO.getDetailProduct( id.intValue()); // chuyển id từ Long sang int
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity()+1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProductDTO().getPrice());
			double roundedTotalPrice = Double.parseDouble(decimalFormat.format(itemCart.getTotalPrice()));
			itemCart.setTotalPrice(roundedTotalPrice);
		} else {
			itemCart.setProductDTO(product);
			itemCart.setQuantity(1);
			double roundedTotalPrice = Double.parseDouble(decimalFormat.format(product.getPrice()));
			itemCart.setTotalPrice(roundedTotalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDTO> EditCart(Long id, int quanty, HashMap<Long, CartDTO> cart) {
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

	public HashMap<Long, CartDTO> DeleteCart(Long id, HashMap<Long, CartDTO> cart) {
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
		
		if(cart.size() == 1 ) {
			Set<Long> keySet = cart.keySet(); // lấy tập hợp các khóa do chỉ có 1 khóa nếu cart chỉ có 1 sản phẩm
			Long onlyKey = keySet.iterator().next();
			return cart.get(onlyKey).getTotalPrice();
		}
		
		double totalPrice = 0;
		for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) { // Map đại diện 1 phần tử trong cart
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
