package com.Singedshop.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Singedshop.dto.BillDetailDTO;

public class BillDetailDTOMapper implements RowMapper<BillDetailDTO> {
	
	@Override
	public BillDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetailDTO billDetail = new  BillDetailDTO();
	
		billDetail.setIdBillDetail(rs.getInt("idBillDetail"));
		billDetail.setIdCategory(rs.getInt("idCategory"));
		billDetail.setIdProduct(rs.getInt("idProduct"));
		billDetail.setQuanty(rs.getInt("quanty"));
		billDetail.setTotalPrice(rs.getDouble("totalPrice"));
		billDetail.setImage(rs.getString("image"));
		billDetail.setNameProduct(rs.getString("nameProduct"));
		return billDetail;
	}
}
