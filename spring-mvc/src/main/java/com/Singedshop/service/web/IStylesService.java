package com.Singedshop.service.web;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.LittleInforProductDTO;

@Service
public interface IStylesService {
	public List<LittleInforProductDTO> GetAllProductCategory(int id );
	public List<LittleInforProductDTO> GetDataProductPaginate(int id , int start , int end);
}
