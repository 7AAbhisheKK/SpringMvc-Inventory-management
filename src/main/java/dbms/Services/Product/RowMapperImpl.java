package dbms.Services.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Category;
import dbms.Entity.Product;


public class RowMapperImpl implements RowMapper<Product> {
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product=new Product();
		product.setProduct_id(rs.getString(7));
		product.setSelling_price(rs.getInt(1));
		product.setArrival_date(rs.getString(3));
		product.setAvailable_quantity(rs.getInt(5));
		product.setBrand(rs.getString(6));
		product.setExpiry_date(rs.getString(4));
		product.setName(rs.getString(8));
		product.setWholesale_price(rs.getInt(2));
		product.setSub_category(rs.getString(9));
		product.setIn_quantity(rs.getInt(10));
		product.setIn_price(rs.getInt(11));
		product.setIn_wholesale_price(rs.getInt(12));
		product.setIn_expiry_date(rs.getString(13));
		return product;
	}
}
