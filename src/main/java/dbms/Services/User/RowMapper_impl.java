package dbms.Services.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dbms.Entity.Employee;

public class RowMapper_impl implements RowMapper<Employee> {
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		employee.setName(rs.getString(1));
		employee.setDob(rs.getString(2));
		employee.setDate_joined(rs.getString(3));
		employee.setDate_resigned(rs.getString(4));
		employee.setAddress(rs.getString(5));
		employee.setEmail(rs.getString(6));
		employee.setAge(rs.getInt(7));
		employee.setPassword(rs.getString(8));
		employee.setEnable(rs.getBoolean(9));
		employee.setUsername(rs.getString(10));
		employee.setRole(rs.getString(11));
		employee.setLast_payment(rs.getString(12));
		return employee;
		
	}
}
