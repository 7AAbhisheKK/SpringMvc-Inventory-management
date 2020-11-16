package dbms.Services.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import dbms.Entity.Cart;


@Component("cart")
public class Product_cart_service_impl implements Product_cart_service {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Cart> get_all() {
		
		String query="Select product.product_id,name,cart.selling_price,quantity from product,cart where product.product_id=cart.product_id";
		List<Cart> c=this.jdbcTemplate.query(query,new RowMapperImpl_cart());
		return c;
		
	}

	public int insert(Cart cart) {
		String query="insert into cart(product_id,quantity,selling_price) values(?,?,?)";
		int r=this.jdbcTemplate.update(query,cart.getProduct_id(),cart.getQuantity(),cart.getPrice());
		return r;
	}

	public int delete_all() {
		String query="delete from cart";
		int r=this.jdbcTemplate.update(query);
		return r;
	}

}
