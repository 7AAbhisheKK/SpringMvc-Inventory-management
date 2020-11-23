package dbms.Services.Miscellaneous;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Employee_payment_extended;

public class RowMapper_employee_payment_extended implements RowMapper<Employee_payment_extended> {

	public Employee_payment_extended mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee_payment_extended e=new Employee_payment_extended();
		e.setAmount(rs.getInt(1));
		e.setDescription(rs.getString(2));
		e.setDate(rs.getString(3));
		e.setName(rs.getString(4));
		e.setUsername(rs.getString(5));
		return e;
	}

}
