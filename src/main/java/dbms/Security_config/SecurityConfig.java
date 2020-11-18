package dbms.Security_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import dbms.userdetail.UserDetailsService_impl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService_impl user_service;
	
	@Autowired
	private CustomLoginSuccessHandler successHandler;
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
    	DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(user_service);
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    	return daoAuthenticationProvider;
    }
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(user_service);
    	auth.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
   
      http.authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/staff/**").hasAnyRole("ADMIN","STAFF").antMatchers("/cashier/**").hasAnyRole("ADMIN","CASHIER")
        .and().formLogin().successHandler(successHandler).and().csrf().disable();
      
    }
    
}
