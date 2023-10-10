package com.Singedshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Singedshop.dto.CategoryDTO;
import com.Singedshop.dto.mapper.CategoryDTOMapper;
import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.mapper.LittleInforProductDTOMapper;

@Repository
public class StyleDAO extends BaseDAO {

	
	public List<LittleInforProductDTO> GetAllProductCategory(int idStyle) {

		String sql = "USE SingedShop;\r\n"
				+ "SELECT idProduct, nameProduct, image, price, oldPrice, idStyle, idCategory, describe FROM Product\r\n"
				+ "WHERE idStyle = " + idStyle;

		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}

	public List<LittleInforProductDTO> GetDataProductPaginate(int id , int start, int end) {

		String sql = "USE SingedShop;\r\n"
				+ "SELECT idProduct , nameProduct , price ,oldPrice , image, Date , idStyle , idCategory \r\n"
				+ "FROM (\r\n"
				+ "    SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNumber\r\n"
				+ "    FROM Product\r\n"
				+ "    WHERE idStyle = "+ id + "\r\n"
				+ ") AS Subquery\r\n"
				+ "WHERE Subquery.RowNumber BETWEEN "+ start + " AND " + end;

		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}
	
	public List<CategoryDTO> getCategory() {

		String sql = "Use SingedShop Select * from Category";

		return jdbcTemplate.query(sql, new CategoryDTOMapper());
	}
}
