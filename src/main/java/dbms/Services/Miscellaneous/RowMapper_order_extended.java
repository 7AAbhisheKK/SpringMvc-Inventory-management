package dbms.Services.Miscellaneous;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Order_extended;

public class RowMapper_order_extended implements RowMapper<Order_extended> {

	public Order_extended mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order_extended o=new Order_extended();
		o.setAmount(rs.getInt(1));
		o.setCustomer_name(rs.getString(2));
		o.setQuantity(rs.getInt(3));
		o.setName(rs.getString(4));
		o.setProduct_id(rs.getString(5));
		o.setPrice(rs.getInt(6));
		o.setDate(rs.getString(7));
		return o;
	}

}
