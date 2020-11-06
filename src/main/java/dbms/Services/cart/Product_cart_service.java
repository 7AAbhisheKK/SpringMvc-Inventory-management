package dbms.Services.cart;

import java.util.List;

import dbms.Entity.Cart;

public interface Product_cart_service {
	public List<Cart> get_all();
	public int insert(Cart cart);
	public int delete_all();
}
