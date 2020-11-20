package dbms.Services.User;

import java.util.List;

import dbms.Entity.Employee;

public interface user_service {
	public Employee getUser(String username);
	public int insert(Employee employee);
	public List<Employee> getAll();
	public int update_date(String username,String date);
	public int updatepass(String username,String password);
	public int update(Employee e);
}
