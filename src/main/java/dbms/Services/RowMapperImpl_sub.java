package dbms.Services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Sub_category;

public class RowMapperImpl_sub implements RowMapper<Sub_category> {

	@Override
	public Sub_category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sub_category sub_category=new Sub_category();
		sub_category.setCategory_id(rs.getString(3));
		sub_category.setSub_category_id(rs.getString(1));
		sub_category.setSub_category_name(rs.getString(2));
		return sub_category;
	}

}
