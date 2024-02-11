package com.Singedshop.service.web.Interface;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.BillDTO;

@Service
public interface IBillService {
	public List<BillDTO> getAllBill();
	public void comfirmBill(int idBill);
	public void cancelBill(int idBill);
}
