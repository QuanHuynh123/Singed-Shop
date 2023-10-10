package com.Singedshop.service.web.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Singedshop.dto.LittleInforProductDTO;

@Service
public interface ISaleAndViewAllService {
	List<LittleInforProductDTO> getAllSaleProduct();
	List<LittleInforProductDTO> getPaginationProductNewProduct(int start, int end);
	List<LittleInforProductDTO> getPaginationSaleProduct(int start, int end);
}
