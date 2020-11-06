package dbms.Services.Product;

import java.util.List;
import dbms.Entity.Product;
import dbms.Entity.Product_order;

public interface Product_service {
	public int insert(Product product);
	public int change(Product product,String product_id);
	public int delete(String product_id);
	public Product getProduct(String product_id);
	public List<Product> getAllProduct();
	public  List<Product_order> getAllProduct_order(String sub_cat_id);
	public int getselling_price(String product_id);
}
