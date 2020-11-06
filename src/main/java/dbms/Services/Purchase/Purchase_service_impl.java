package dbms.Services.Purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import dbms.Entity.Purchase_detail;
@Component("purchase")
public class Purchase_service_impl implements Purchase_service{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Purchase_detail purchase) {
		String query="insert into purchase_detail(quantity,product_id,order_id) values(?,?,?)";
		int r=this.jdbcTemplate.update(query,purchase.getQuantity(),purchase.getProduct_id(),purchase.getOrder_id());
		return r;
	}

}
