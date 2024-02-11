package com.Singedshop.service.web.Interface;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.BillDetailDTO;

@Service
public interface IBillDetailService {
	
	public List<BillDetailDTO> getBillDetail (int idBill);
}
