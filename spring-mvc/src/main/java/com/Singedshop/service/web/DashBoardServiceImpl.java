package com.Singedshop.service.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Singedshop.dao.AdminDAO;
import com.Singedshop.dto.DashBoardDTO;
import com.Singedshop.service.web.Interface.IDashBoardService;

@Service
public class DashBoardServiceImpl implements IDashBoardService{
	
	@Autowired
	AdminDAO adminDAO ; 

	@Override
	public List<Integer> calMonth() {
		LocalDate month = LocalDate.now();
		
		List<Integer> listMonth = new ArrayList<Integer>();
		for(int i = 1 ; i <= 3 ; i ++) 
			listMonth.add(month.minusMonths(i).getMonthValue());
		return listMonth;
	}

	@Override
	public List<DashBoardDTO> getMonth() {
		List<DashBoardDTO> dashBoardDTOs =   adminDAO.getMonthAndQuantity(calMonth());
		
		int sum  = 0 ;
		for (DashBoardDTO dashBoardDTO : dashBoardDTOs) {
			sum += dashBoardDTO.getQuantity();
		}
		float count  ; 
		for ( DashBoardDTO dashBoardDTO : dashBoardDTOs) 
			dashBoardDTO.setScale( ((float)dashBoardDTO.getQuantity() / sum )*100 );
		
		

		return dashBoardDTOs ; 
	}	

}
