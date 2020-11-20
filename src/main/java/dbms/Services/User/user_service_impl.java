package dbms.Services.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dbms.Entity.Employee;
import dbms.Entity.Post;
import dbms.Services.Post_s.Rowmapper_post;

@Service
public class user_service_impl implements user_service {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employee getUser(String username) {
		String query="Select * from employee where username=?";
		System.out.println(username);
		RowMapper<Employee> rowMapper=new RowMapper_impl();
		Employee employee=jdbcTemplate.queryForObject(query,rowMapper,username);
		return employee;
	}

	public int insert(Employee employee) {
		String query="insert into employee(name,dob,date_joined,date_resigned,address,email,password,username,role,last_payment,post_id) values(?,?,?,?,?,?,?,?,?,?,?)";
		int r=jdbcTemplate.update(query,employee.getName(),employee.getDob(),employee.getDate_joined(),employee.getDate_resigned(),employee.getAddress(),employee.getEmail(),employee.getPassword(),employee.getUsername(),employee.getRole(),employee.getLast_payment(),employee.getPost_id());
		return r;
	}

	public List<Employee> getAll() {
		String query="select * from employee";
		List<Employee> employee=this.jdbcTemplate.query(query,new RowMapper_impl());
		return employee;
	}

	public int update_date(String username,String date) {
		String query="update employee set last_payment=? where username=?";
		int r=jdbcTemplate.update(query,date,username);
		return r;
	}

	public int updatepass(String username, String password) {
		String query="update employee set password=? where username=?";
		int r=jdbcTemplate.update(query,password,username);
		return r;
	}

	public int update(Employee employee) {
		String query="update employee set name=?,dob=?,date_joined=?,date_resigned=?,address=?,email=?,password=?,role=?,last_payment=?,post_id=? where username=?";
		int r=jdbcTemplate.update(query,employee.getName(),employee.getDob(),employee.getDate_joined(),employee.getDate_resigned(),employee.getAddress(),employee.getEmail(),employee.getPassword(),employee.getRole(),employee.getLast_payment(),employee.getPost_id(),employee.getUsername());
		return r;
	}

}
