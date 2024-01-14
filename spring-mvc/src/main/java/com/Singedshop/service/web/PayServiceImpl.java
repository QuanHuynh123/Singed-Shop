package com.Singedshop.service.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.PayDAO;
import com.Singedshop.dto.BillDTO;
import com.Singedshop.dto.CartDTO;
import com.Singedshop.service.web.Interface.IPayService;
import com.Singedshop.dto.BillDetailDTO;

@Service
public class PayServiceImpl implements IPayService {
	
	@Autowired
	private PayDAO pay;
	
	@Override
	public int addBill(BillDTO bill) {
		return pay.addBill(bill);
	}

	@Override
	public int addBillDetail(HashMap<Long, CartDTO> cart) {
		
		long idBill = pay.getIdBill();
		
		// chuyển giao bill vào billDetail
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			BillDetailDTO billDetail = new BillDetailDTO();
			billDetail.setIdBill(idBill);
			billDetail.setIdProduct(itemCart.getValue().getProductDTO().getIdProduct());
			billDetail.setQuanty(itemCart.getValue().getQuantity());
			billDetail.setTotalPrice(itemCart.getValue().getTotalPrice());
			billDetail.setIdCategory(itemCart.getValue().getProductDTO().getCategory());
			billDetail.setNameProduct(itemCart.getValue().getProductDTO().getNameProduct());
			pay.addBillDetail(billDetail);
		}
		return 1;
	}
	
}
