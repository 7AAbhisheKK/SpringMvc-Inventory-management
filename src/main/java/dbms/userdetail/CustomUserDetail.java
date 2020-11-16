package dbms.userdetail;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.tools.javac.util.List;

import dbms.Entity.Employee;

public class CustomUserDetail implements UserDetails{
	
	private Employee employee;
	
	public CustomUserDetail(Employee employee) {
		super();
		this.employee = employee;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simplegranted=new SimpleGrantedAuthority(employee.getRole());
		System.out.println(employee.getRole());
		return List.of(simplegranted);
	}

	public String getPassword() {
		return employee.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return employee.getUsername();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
