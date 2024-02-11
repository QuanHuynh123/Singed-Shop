package com.Singedshop.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.BillDTO;

public class BillDTOMapper implements RowMapper<BillDTO> {
	
	@Override
	public BillDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDTO bill = new BillDTO();
		bill.setAddress(rs.getString("address"));
		bill.setEmail(rs.getString("email"));
		bill.setIdBill(rs.getInt("idBill"));
		bill.setOrderDate(rs.getString("orderDate"));
		bill.setPhone(rs.getString("phone"));
		bill.setStatus(rs.getString("status"));
		bill.setTotalQuanty(rs.getInt("totalQuanty"));
		bill.setTotalPrice(rs.getDouble("totalPrice"));
		return bill;
	}
}
