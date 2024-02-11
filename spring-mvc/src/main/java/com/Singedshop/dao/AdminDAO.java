package com.Singedshop.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Singedshop.dto.BillDTO;
import com.Singedshop.dto.BillDetailDTO;
import com.Singedshop.dto.DashBoardDTO;
import com.Singedshop.dto.ProductDTO;
import com.Singedshop.dto.mapper.BillDTOMapper;
import com.Singedshop.dto.mapper.BillDetailDTOMapper;
import com.Singedshop.dto.mapper.DashBoardDTOMapper;

@Repository
public class AdminDAO extends BaseDAO {
	
		
	public void addProductAdmin(ProductDTO newProduct) {
		LocalDate timeCreate = LocalDate.now();
		String sql= "USE SingedShop\r\n"
				+ "INSERT INTO Product(nameProduct, quantity, price , describe , idStyle , idCategory , image, Date)\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?);";
		jdbcTemplate.update(sql,newProduct.getNameProduct(), newProduct.getQuantity(),newProduct.getPrice(),newProduct.getDescribe(),newProduct.getIdStyle(),newProduct.getCategory(),"null", timeCreate);
	} 
	
	public void updateProductAdmin(ProductDTO updateProduct) {
		String sql= "Use SingedShop\r\n"
				+ "Update Product Set nameProduct = ?  , quantity = ? , price  = ?, describe  = ?, idStyle = ?, idCategory = ?  Where idProduct  = ?  ";
		jdbcTemplate.update(sql,updateProduct.getNameProduct(),updateProduct.getQuantity(), updateProduct.getPrice(),updateProduct.getDescribe(),updateProduct.getIdStyle(),updateProduct.getCategory(),updateProduct.getIdProduct());
	}
	
	public void deleteProductAdmin(int id) {
		 String sql = "Use SingedShop  DELETE FROM Product WHERE idProduct = ?";
	     jdbcTemplate.update(sql, id);
	}
	
	public List<BillDTO> getAllBill() {
		String sql = " Use SingedShop Select * from Bill" ; 
		return jdbcTemplate.query(sql, new BillDTOMapper());
	}
	
	public List<BillDetailDTO> getBillDetail(int idBill ) {
		String sql = " Use SingedShop Select * from BillDetail where idBill = " + idBill  ; 
		return jdbcTemplate.query(sql, new BillDetailDTOMapper());
	}
	
	public int comfirmBill(int idBill) {
		String sql= "Use SingedShop\r\n"
				+ "Update Bill Set status = ?  Where idBill  = ?  ";
		return jdbcTemplate.update(sql,"Confirmed",idBill);
	}
	
	public int cancelBill(int idBill) {
		String sql= "Use SingedShop\r\n"
				+ "Update Bill Set status = ?  Where idBill  = ?  ";
		return jdbcTemplate.update(sql,"Cancel",idBill);
	}
	
	public List<DashBoardDTO> getMonthAndQuantity(List<Integer> listMonth) {
		
		LocalDate month = LocalDate.now();
	
		String sql= "USE SingedShop;\r\n"
				+ "SELECT months.month AS month, COUNT(bill.orderDate) AS quantity\r\n"
				+ "FROM (\r\n"
				+ "    SELECT 1 AS month\r\n"
				+ "    UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6\r\n"
				+ "    UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12\r\n"
				+ ") AS months\r\n"
				+ "LEFT JOIN Bill ON MONTH(bill.orderDate) = months.month AND YEAR(bill.orderDate) = YEAR(GETDATE())\r\n"
				+ "WHERE months.month IN ("+listMonth.get(2)+", "+listMonth.get(1)+", "+listMonth.get(0)+", "+month.getMonthValue()+")\r\n"
				+ "GROUP BY months.month\r\n"
				+ "ORDER BY months.month;";
		return jdbcTemplate.query(sql,new DashBoardDTOMapper());
	}
}
