package dbms.Services.Post_s;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import dbms.Entity.Post;
import dbms.Entity.Product;
import dbms.Services.Product.RowMapperImpl;
@Component
public class Post_service_impl implements Post_service {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Post get(String username) {
		String query="select * from post where username=?";
		RowMapper<Post> rowMapper=new Rowmapper_post();
		Post post=this.jdbcTemplate.queryForObject(query,rowMapper,username);
		return post;
	}

	public List<Post> getAll() {
		String query="select * from post where username=?";
		List<Post> post=this.jdbcTemplate.query(query,new Rowmapper_post());
		return post;
	}

}
