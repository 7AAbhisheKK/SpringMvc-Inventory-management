package dbms.Services.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import dbms.Entity.Sub_category;
@Component("Sub_catdao")
public class Sub_cat_service_impl implements Sub_cat_service {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Sub_category sub_category) {
		String query="insert into subcategory(sub_category_id,sub_Category_name,category_id) values(?,?,?)";
		int r=this.jdbcTemplate.update(query,sub_category.getSub_category_id(),sub_category.getSub_category_name(),sub_category.getCategory_id());
		return r;
	}

	public List<Sub_category> getAllsub() {
		String query="select * from subcategory";
		List<Sub_category> l=this.jdbcTemplate.query(query,new RowMapperImpl_sub());
		System.out.println(l);
		return l;
	}

	public List<Sub_category> getAllsub_by_cat(String cat_id) {
		String query="select * from subcategory where category_id=?";
		List<Sub_category> l=this.jdbcTemplate.query(query, new Object[] {cat_id},new RowMapperImpl_sub());
		return l;
	}

	public Map<String, String> getAllsub_by_cat_in_map(String cat_id) {
		String query="select * from subcategory where category_id=?";
		List<Sub_category> l=this.jdbcTemplate.query(query, new Object[] {cat_id},new RowMapperImpl_sub());
		Map<String,String> m=new HashMap<>();
		for (Sub_category s:l)
		{
			m.put(s.getSub_category_id(), s.getSub_category_name());
		}
			
		return m;
	}

}
