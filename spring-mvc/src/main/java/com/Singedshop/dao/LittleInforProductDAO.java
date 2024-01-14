package com.Singedshop.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.Singedshop.dto.StylesDTO;
import com.Singedshop.dto.mapper.CategoryDTOMapper;
import com.Singedshop.dto.mapper.FullProductDTOMapper;
import com.Singedshop.dto.mapper.LittleInforProductDTOMapper;
import com.Singedshop.dto.mapper.StylesDTOMapper;
import com.Singedshop.dto.CategoryDTO;
import com.Singedshop.dto.LittleInforProductDTO;
import com.Singedshop.dto.ProductDTO;

@Repository
public class LittleInforProductDAO extends BaseDAO {


	public List<LittleInforProductDTO> getBestSaleProduct() {
		String sql = "USE SingedShop\r\n"
				+ "SELECT idProduct, nameProduct, price,oldPrice, idStyle, idCategory, purchases,image\r\n"
				+ "FROM Product\r\n"
				+ "ORDER BY purchases DESC";
		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}

	public List<LittleInforProductDTO> getNewProduct() {

		String sql = "USE SingedShop\r\n"
				+ "SELECT idProduct, nameProduct, price,oldPrice, idStyle, idCategory, Date , image\r\n"
				+ "FROM Product\r\n"
				+ "ORDER BY  Date DESC;";

		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}

	public List<StylesDTO> getStyle() {
		String sql = "USE SingedShop Select * from Style";

		return jdbcTemplate.query(sql, new StylesDTOMapper());
	}
	
	public List<LittleInforProductDTO> getAllProductSale(){ 
		
		String sql = "Use SingedShop select idProduct, nameProduct, price,oldPrice, idStyle, idCategory , image , Sale from Product where Sale > 0" ; 
		return jdbcTemplate.query(sql,  new LittleInforProductDTOMapper()) ; 
	}
	
	
	public List<LittleInforProductDTO> getPaginationProductNewProduct(int start , int end) {

		String sql = "USE SingedShop;\r\n"
				+ "SELECT idProduct , nameProduct , price ,oldPrice , image, Date , idStyle , idCategory \r\n"
				+ "FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY  Date DESC) AS RowNumber FROM Product ) AS Subquery \r\n"
				+ "WHERE Subquery.RowNumber BETWEEN "+ start+" AND "+end ;

		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}

	public List<LittleInforProductDTO> getPaginationProductSale(int start, int end) {

		String sql = "USE SingedShop\r\n"
				+ "SELECT idProduct , nameProduct , price ,oldPrice , image, Date , idStyle , idCategory \r\n"
				+ "FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) AS RowNumber\r\n"
				+ "FROM Product WHERE Sale > 0 ) AS Subquery\r\n"
				+ "WHERE Subquery.RowNumber BETWEEN "+ start +" AND " + end;

		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}
	
	public List<LittleInforProductDTO> getPaginationProductBestSale(int start, int end) {

		String sql = "USE SingedShop\r\n"
				+ "SELECT idProduct , nameProduct , price ,oldPrice , image, Date , idStyle , idCategory \r\n"
				+ "FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY purchases DESC) AS RowNumber FROM Product ) AS Subquery \r\n"
				+ "WHERE Subquery.RowNumber BETWEEN "+ start +" AND " + end;

		return jdbcTemplate.query(sql, new LittleInforProductDTOMapper());
	}


}
