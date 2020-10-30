package dbms.Services;

import java.util.List;
import dbms.Entity.Product;

public interface Product_service {
	public int insert(Product product);
	public int change(Product product,String product_id);
	public int delete(String product_id);
	public Product getProduct(String product_id);
	public List<Product> getAllProduct();
}
