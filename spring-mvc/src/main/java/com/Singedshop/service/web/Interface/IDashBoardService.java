package com.Singedshop.service.web.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.DashBoardDTO;

@Service
public interface IDashBoardService {
	public List<Integer> calMonth();
	public List<DashBoardDTO> getMonth();
	
}
