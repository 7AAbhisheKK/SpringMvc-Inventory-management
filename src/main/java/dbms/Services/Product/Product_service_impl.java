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
		String query="insert into product(selling_price,wholesale_price,Arrival_date,Expiry_date,Available_Quantity,Brand,product_id,name,sub_category_id,in_quantity,in_price,in_wholesale_price,in_expiry_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int r = this.jdbcTemplate.update(query,product.getSelling_price(),product.getWholesale_price(),product.getArrival_date(),product.getExpiry_date(),product.getAvailable_quantity(),product.getBrand(),product.getProduct_id(),product.getName(),product.getSub_category(),0,product.getSelling_price(),product.getWholesale_price(),null);
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
		String query="update product set name=?,selling_price=?,wholesale_price=?,Arrival_date=?,Expiry_date=?,Available_quantity=?,Brand=?,product_id=?,sub_category_id=?,in_quantity=?,in_price=?,in_wholesale_price=?,in_expiry_date=? where product_id=?";
		int r=this.jdbcTemplate.update(query,product.getName(),product.getSelling_price(),product.getWholesale_price(),product.getArrival_date(),product.getExpiry_date(),product.getAvailable_quantity(),product.getBrand(),product.getProduct_id(),product.getSub_category(),product.getIn_quantity(),product.getIn_price(),product.getIn_wholesale_price(),product.getIn_expiry_date(),product_id);
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
		String query="select product_id,name,in_price from product where sub_category_id=?";
		List<Product_order> product=this.jdbcTemplate.query(query, new RowMapperImpl_order(),sub_cat_id);
		System.out.println(product);
		System.out.println(sub_cat_id);
		return product;
	}
	public int getselling_price(String product_id) {
		String query="select in_price from product where product_id=?";
		int selling_price=this.jdbcTemplate.queryForObject(query,Integer.class,product_id);
		return selling_price;
	}
	public List<Product> out_of_stock() {
		String query="select * from product where in_quantity=0";
		List<Product> product=this.jdbcTemplate.query(query,new RowMapperImpl());
		return product;
	}
	public List<Product> out_stock_ware() {
		String query="select * from product where available_quantity=0";
		List<Product> product=this.jdbcTemplate.query(query,new RowMapperImpl());
		return product;
	}
	public int instock_dump(String product_id) {
		String query="update product set in_quantity=0 where product_id=?";
		System.out.println(product_id);
		int r=this.jdbcTemplate.update(query,product_id);
		return r;
	}
	public int inware_dump(String product_id) {
		String query="update product set available_quantity=0 where product_id=?";
		int r=this.jdbcTemplate.update(query,product_id);
		return r;
	}

}
