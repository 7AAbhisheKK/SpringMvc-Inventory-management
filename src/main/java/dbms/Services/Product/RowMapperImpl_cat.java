package dbms.Services.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Category;

public class RowMapperImpl_cat implements RowMapper<Category> {

	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category=new Category();
		category.setCategory_id(rs.getString(1));
		category.setCategory_name(rs.getString(2));
		return category;
	}

}
