package dbms.Services.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import dbms.Entity.Order;
@Component("order")
public class Order_service_impl implements Order_service{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(final Order order,final int amount) {
		final String query="insert into orders(order_date,amount,customer_name,customer_mobile_number) values(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps =
		                connection.prepareStatement(query, new String[] {"id"});
		            ps.setString(1, order.getOrder_date());
		            ps.setInt(2, amount);
		            ps.setString(3, order.getCustomer_name());
		            ps.setString(4, order.getCustomer_mobile_number());
		            return ps;
		        }
		    },
		    keyHolder);
		System.out.println( keyHolder.getKey());
		return (int) keyHolder.getKey().intValue();
	}

}
