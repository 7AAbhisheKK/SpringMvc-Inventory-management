package dbms.Services.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import dbms.Entity.Product;
import dbms.Entity.Product_order;
@Component("productdao")
public class Product_service_impl implements Product_service {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(Product product) {
		String query="insert into product(selling_price,wholesale_price,Arrival_date,Expiry_date,Available_Quantity,minimum_quantity,Brand,product_id,name,sub_category_id) values(?,?,?,?,?,?,?,?,?,?)";
		int r = this.jdbcTemplate.update(query,product.getSelling_price(),product.getWholesale_price(),product.getArrival_date(),product.getExpiry_date(),product.getAvailable_quantity(),product.getMinimum_quantity(),product.getBrand(),product.getProduct_id(),product.getName(),product.getSub_category());
		return r;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int change(Product product,String product_id) {
		
		System.out.println(product);
		if(product.getExpiry_date().isEmpty())
		{
			product.setExpiry_date(null);
		}
		String query="update product set name=?,selling_price=?,wholesale_price=?,Arrival_date=?,Expiry_date=?,Available_quantity=?,minimum_quantity=?,Brand=?,product_id=?,sub_category_id=? where product_id=?";
		int r=this.jdbcTemplate.update(query,product.getName(),product.getSelling_price(),product.getWholesale_price(),product.getArrival_date(),product.getExpiry_date(),product.getAvailable_quantity(),product.getMinimum_quantity(),product.getBrand(),product.getProduct_id(),product_id,product.getSub_category());
		return r;
	}
	public int delete(String product_id) {
		String query="delete from product where product_id=?";
		int r=this.jdbcTemplate.update(query,product_id);
		return r;
	}
	public Product getProduct(String product_id) {
		String query="select * from product where product_id=?";
		RowMapper<Product> rowMapper=new RowMapperImpl();
		Product product=this.jdbcTemplate.queryForObject(query,rowMapper,product_id);
		return product;
	}
	public List<Product> getAllProduct() {
		String query="select * from product";
		List<Product> product=this.jdbcTemplate.query(query,new RowMapperImpl());
		return product;
	}
	public List<Product_order> getAllProduct_order(String sub_cat_id) {
		String query="select product_id,name,selling_price from product where sub_category_id=?";
		List<Product_order> product=this.jdbcTemplate.query(query, new RowMapperImpl_order(),sub_cat_id);
		System.out.println(product);
		System.out.println(sub_cat_id);
		return product;
	}
	@Override
	public int getselling_price(String product_id) {
		String query="select selling_price from product where product_id=?";
		int selling_price=this.jdbcTemplate.queryForObject(query,Integer.class,product_id);
		return selling_price;
	}

}
