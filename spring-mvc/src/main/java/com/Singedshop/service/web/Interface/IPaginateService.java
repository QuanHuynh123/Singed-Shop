package com.Singedshop.service.web.Interface;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.PaginateDTO;

@Service
public interface IPaginateService {
	
	public PaginateDTO getInforPaginate(int totalData, int limit , int currentPage);
	
}
