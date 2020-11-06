package dbms.Services.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import dbms.Entity.Category;
@Component("categorydao")
public class Category_service_impl implements Category_service {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Category category) {
		String query="insert into category(category_id,Category_name) values(?,?)";
		int r=this.jdbcTemplate.update(query,category.getCategory_id(),category.getCategory_name());
		return r;
	}

	public List<Category> getAllcategory() {
		String query="select * from category";
		List<Category> l=this.jdbcTemplate.query(query,new RowMapperImpl_cat());
		System.out.println(l);
		return l;
	}

}
