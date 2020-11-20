package dbms.Services.Miscellaneous;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Row_mapper_string implements RowMapper<String> {

	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		String s=rs.getString(1);
		return s;
	}

}
