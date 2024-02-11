package com.Singedshop.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Singedshop.dto.DashBoardDTO;
import com.Singedshop.dto.ProductDTO;
import com.Singedshop.service.admin.AdminServiceImpl;
import com.Singedshop.service.web.DashBoardServiceImpl;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	AdminServiceImpl admin ; 
	
	@Autowired
	DashBoardServiceImpl boardServiceImpl;
	
	@PostMapping("/api/new")
	public ProductDTO  createClothes(@RequestBody ProductDTO quanAo){
		return admin.insert(quanAo);
	};
	
	@PutMapping("/api/new")	
	public ProductDTO  updateClothes(@RequestBody ProductDTO quanAo){
		return admin.update(quanAo);
	
	};
	
	@DeleteMapping("/api/new")
	public void deleteClothes(@RequestBody int[] ids){
		admin.delete(ids);
	};
	
	@GetMapping("/api/dashboard")
	public List<DashBoardDTO> getDashBoard () {
		return boardServiceImpl.getMonth();
	}
	
}
