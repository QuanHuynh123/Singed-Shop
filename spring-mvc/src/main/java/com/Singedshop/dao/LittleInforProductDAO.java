package com.Singedshop.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.Singedshop.dto.StylesDTO;
import com.Singedshop.dto.StylesDTOMapper;
import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.LittleInforProductDTOMapper;

@Repository
public class LittleInforProductDAO extends BaseDAO {


	public List<LittleInforProductDTO> getBestSaleQuanAo() {
		String sql = "USE SingedShop\r\n"
				+ "SELECT TOP 4 idProduct, nameProduct, price, idStyle, idCategory, purchases,image\r\n"
				+ "FROM Product\r\n"
				+ "ORDER BY purchases DESC";
		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}

	public List<LittleInforProductDTO> getNewQuanAo() {

		String sql = "USE SingedShop\r\n"
				+ "SELECT TOP 8 idProduct, nameProduct, price, idStyle, idCategory, Date , image\r\n"
				+ "FROM Product\r\n"
				+ "ORDER BY  Date DESC;";

		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}

	public List<StylesDTO> getStyleAllProduct() {
		String sql = "USE SingedShop;\r\n" + "Select * from Style";

		return jdbcTemplate.query(sql, new StylesDTOMapper());
	}

}
