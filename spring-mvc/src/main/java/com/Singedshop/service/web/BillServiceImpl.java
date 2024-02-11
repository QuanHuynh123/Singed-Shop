package com.Singedshop.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.AdminDAO;
import com.Singedshop.service.web.Interface.IBillService;
import com.Singedshop.dto.BillDTO;

@Service
public class BillServiceImpl implements IBillService {

	@Autowired
	AdminDAO adminDAO ;  
	
	@Override
	public List<BillDTO> getAllBill() {
		return adminDAO.getAllBill();
	}

	@Override
	public void comfirmBill(int idBill) {
		adminDAO.comfirmBill(idBill);
	}

	@Override
	public void cancelBill(int idBill) {
		adminDAO.cancelBill(idBill);
	}

}
