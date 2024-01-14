package com.Singedshop.service.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.CartDAO;
import com.Singedshop.dto.CartDTO;
import com.Singedshop.service.web.Interface.ICartService;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	private CartDAO cartDAO ;

	@Override
	public HashMap<Long, CartDTO> AddCart(long id, HashMap<Long, CartDTO> cart) {
		
		return cartDAO.AddCart(id, cart);
	}

	@Override
	public HashMap<Long, CartDTO> EditCart(long id, int quanty, HashMap<Long, CartDTO> cart) {
		
		return cartDAO.EditCart(id, quanty, cart);
	}

	@Override
	public HashMap<Long, CartDTO> DeleteCart(long id, HashMap<Long, CartDTO> cart) {
		
		return cartDAO.DeleteCart(id, cart);
	}

	@Override
	public HashMap<Long, CartDTO> DeleteAllCart(HashMap<Long, CartDTO> cart) {
		return cartDAO.DeleteAllCart(cart);
	}

	@Override
	public int TotalQuanty(HashMap<Long, CartDTO> cart) {
		
		return cartDAO.TotalQuanty(cart);
	}

	@Override
	public double TotalPrice(HashMap<Long, CartDTO> cart) {
		
		return cartDAO.TotalPrice(cart);
	}
	
}
