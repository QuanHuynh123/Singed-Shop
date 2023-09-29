package com.Singedshop.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Singedshop.dto.ProductDTO;
import com.Singedshop.service.admin.AdminServiceImpl;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	AdminServiceImpl admin ; 
	
	@PostMapping("/api/new")
	public ProductDTO  createQuanAO(@RequestBody ProductDTO quanAo){
		return admin.insert(quanAo);
	};
	
	@PutMapping("/api/new")	
	public ProductDTO  updateQuanAO(@RequestBody ProductDTO quanAo){
		return admin.update(quanAo);
	
	};
	
	@DeleteMapping("/api/new")
	public void deleteQuanAO(@RequestBody int[] ids){
		admin.delete(ids);
	};
}
