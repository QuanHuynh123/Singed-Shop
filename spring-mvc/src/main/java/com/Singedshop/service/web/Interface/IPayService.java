package com.Singedshop.service.web.Interface;

import java.util.HashMap;

import com.Singedshop.dto.BillDTO;
import com.Singedshop.dto.CartDTO;

public interface IPayService {
	public int addBill(BillDTO bill);
	public int addBillDetail(HashMap<Long,CartDTO> cart) ;
}
