package com.Singedshop.dao;


import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import com.Singedshop.dto.BillDTO;
import com.Singedshop.dto.BillDetailDTO;

@Repository
public class PayDAO  extends BaseDAO{

	public int  addBill(BillDTO bill) {
		LocalDate timeOrder = LocalDate.now();
		String sql = "USE SingedShop;\r\n"
				+ "  INSERT INTO Bill (phone, email, totalQuanty,address , orderDate , status, totalPrice , orderDate)\r\n"
				+ "  VALUES (?, ?, ? , ?, ? , ?, ? , ? );";
		int insert =  jdbcTemplate.update(sql, bill.getPhone(), bill.getEmail(), bill.getTotalQuanty(), bill.getAddress(), bill.getOrderDate(),"Pending confirmation", bill.getTotalPrice(), timeOrder);
		return insert;
	}
	
	public int addBillDetail(BillDetailDTO billDetail) {
		String sql = "USE SingedShop \r\n"
				+ " INSERT INTO BillDetail (idProduct , quanty, totalPrice, idCategory, nameProduct, idBill , image)\r\n"
				+ " VALUES (?, ?, ? , ? , ? , ? , ?);"; 
		int insert =  jdbcTemplate.update(sql, billDetail.getIdProduct() , billDetail.getQuanty(), billDetail.getTotalPrice(), billDetail.getIdCategory(), billDetail.getNameProduct(), billDetail.getIdBill(), billDetail.getImage());
		return insert ; 
	}
	
	public long getIdBill() {
		String sql = "Use SingedShop Select Max(idBill) from Bill";
		long id = jdbcTemplate.queryForObject(sql, new Object[] {}, Long.class);
		return id ;
	}
	
//	public List<BillDTO> getAllBill(){
//		String sql= "Use SingedShop\r\n"
//				+ "SELECT\r\n"
//				+ "    BD.idBillDetail AS idDetail,\r\n"
//				+ "    BD.quanty,\r\n"
//				+ "    BD.totalPrice,\r\n"
//				+ "    BD.idProduct,\r\n"
//				+ "    BD.idCategory,\r\n"
//				+ "    BD.nameProduct,\r\n"
//				+ "    B.idBill,\r\n"
//				+ "    B.phone,\r\n"
//				+ "    B.email,\r\n"
//				+ "    B.totalQuanty,\r\n"
//				+ "    B.address,\r\n"
//				+ "    B.gender,\r\n"
//				+ "    B.status,\r\n"
//				+ "    B.orderDate,\r\n"
//				+ "    B.totalAmount\r\n"
//				+ "FROM\r\n"
//				+ "    [SingedShop].[dbo].[BillDetail] BD\r\n"
//				+ "INNER JOIN\r\n"
//				+ "    [SingedShop].[dbo].[Bill] B\r\n"
//				+ "ON\r\n"
//				+ "    BD.idBill = B.idBill" ;
//		return null ; 
//	}
}
