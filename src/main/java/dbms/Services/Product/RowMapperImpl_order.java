package dbms.Services.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Product_order;

public class RowMapperImpl_order implements RowMapper<Product_order> {

	@Override
	public Product_order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product_order product_order=new Product_order();
		product_order.setProduct_id(rs.getString(1));
		product_order.setName(rs.getString(2));
		product_order.setSelling_price(rs.getInt(3));
		return product_order;
	}
	
}
