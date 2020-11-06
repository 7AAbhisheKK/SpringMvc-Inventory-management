package dbms.Services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import dbms.Entity.Order;

public class Order_service_impl implements Order_service{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int insert(Order order) {
		String query="insert into order(order_id,product_id,quantity,order_date,month_year) values(?,?,?,?,?)";
		int r=this.jdbcTemplate.update(query,order.getOrder_id(),order.getProduct_id(),order.getQuantity(),order.getOrder_date(),order.getMonth_year());
		return r;
	}

}
