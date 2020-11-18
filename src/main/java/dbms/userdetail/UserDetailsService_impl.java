package dbms.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import dbms.Entity.Employee;
import dbms.Services.User.user_service_impl;
@Component
public class UserDetailsService_impl implements UserDetailsService {
	@Autowired
	private user_service_impl user_service;
	
	
	@SuppressWarnings("unused")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Employee employee=user_service.getUser(username);
		if(employee==null)
		{
			throw new UsernameNotFoundException("Could not found user");
		}
		CustomUserDetail customuserdetail=new CustomUserDetail(employee);
		return customuserdetail;
	}

}
