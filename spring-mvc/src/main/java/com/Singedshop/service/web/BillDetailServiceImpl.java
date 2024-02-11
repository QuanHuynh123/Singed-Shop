package com.Singedshop.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.AdminDAO;
import com.Singedshop.dto.BillDetailDTO;
import com.Singedshop.service.web.Interface.IBillDetailService;

@Service
public class BillDetailServiceImpl implements IBillDetailService{

	@Autowired
	AdminDAO adminDAO;
	
	@Override
	public List<BillDetailDTO> getBillDetail(int idBill) {
		return adminDAO.getBillDetail(idBill);
	}

}
