/*package com.Singedshop.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.BillDTO;
import com.Singedshop.dto.BillDetailDTO;

public class BillDTOMapper implements RowMapper<BillDTO> {
	@Override
	public BillDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDTO bill = new BillDTO();
		BillDetailDTO billDetail = new  BillDetailDTO();
		bill.setAddress(rs.getString("address"));
		bill.setEmail(rs.getString("email"));
		bill.setIdBill(rs.getInt("idBill"));
		bill.setOrderDate("");
		bill.setPhone(rs.getString("phone"));
		bill.setTotalQuanty(rs.getInt("totalQuanty"));
		bill.setTotalAmount(rs.getDouble("totlalAmount"));
		billDetail.setIdBillDetail(rs.getInt("idDetail"));
		billDetail.setIdCategory(rs.getInt("idCategory"));
		billDetail.setIdProduct(rs.getInt("idProduct"));
		billDetail.setQuanty(rs.getInt("quanty"));
		billDetail.setTotalPrice(rs.getDouble("totalPrice"));
		bill.setBillDetail(billDetail);
		return bill;
	}
}*/
