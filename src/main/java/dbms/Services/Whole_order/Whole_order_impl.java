package dbms.Services.Whole_order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import dbms.Entity.Wholesale_order;
@Component("WHole_sale")
public class Whole_order_impl implements Whole_order {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(final Wholesale_order w) {
		final String query="insert into wholesale_order(product_id,quantity,price,order_date) values(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps =
		                connection.prepareStatement(query, new String[] {"id"});
		            ps.setString(1, w.getProduct_id());
		            ps.setInt(2, w.getQuantity());
		            ps.setInt(3, w.getPrice());
		            ps.setString(4, w.getOrder_date());
		            return ps;
		        }
		    },
		    keyHolder);
		System.out.println( keyHolder.getKey());
		return (int) keyHolder.getKey().intValue();
	}

}
