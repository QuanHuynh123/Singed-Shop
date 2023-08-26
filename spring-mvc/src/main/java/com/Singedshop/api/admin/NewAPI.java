package com.Singedshop.api.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Singedshop.dto.ProductDTO;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	@PostMapping("/api/new")
	public ProductDTO  newQuanAO(@RequestBody ProductDTO quanAo){
		return quanAo;
	};
	
	@PutMapping("/api/new")
	public ProductDTO  createQuanAO(@RequestBody ProductDTO quanAo){
		return quanAo;
	};
	
	@DeleteMapping("/api/new")
	public void deleteQuanAO(@RequestBody long[] IdQuanAo){
		System.out.println("ok");
	};
}
