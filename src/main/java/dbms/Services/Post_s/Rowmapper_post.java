package dbms.Services.Post_s;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Post;

public class Rowmapper_post implements RowMapper<Post> {

	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		Post post=new Post();
		post.setPost_id(rs.getString(1));
		post.setPost_name(rs.getString(2));
		post.setSalary(rs.getInt(3));
		return post;
	}

}
