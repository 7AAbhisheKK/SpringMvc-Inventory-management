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
		employee.setPassword(rs.getString(7));
		employee.setUsername(rs.getString(8));
		employee.setRole(rs.getString(9));
		employee.setLast_payment(rs.getString(10));
		employee.setPost_id(rs.getString(11));
		return employee;
		
	}
}
