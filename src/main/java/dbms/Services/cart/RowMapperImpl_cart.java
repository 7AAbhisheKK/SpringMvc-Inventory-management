package dbms.Services.cart;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Cart;

public class RowMapperImpl_cart implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart=new Cart();
		cart.setProduct_id(rs.getString(1));
		cart.setName(rs.getString(2));
		cart.setPrice(rs.getInt(3));
		cart.setQuantity(rs.getInt(4));
		return cart;
	}

}
