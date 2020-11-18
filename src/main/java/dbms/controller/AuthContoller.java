package dbms.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import dbms.Entity.Employee;
import dbms.Entity.Post;
import dbms.Services.Post_s.Post_service_impl;
import dbms.Services.User.user_service_impl;

@Controller
public class AuthContoller {
	@Autowired
	private user_service_impl user_service;
	@Autowired
	private Post_service_impl post_service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String reg_page(Model m)
	{
		Employee e=new Employee();
		m.addAttribute("employee",e);
		List<Post> p=post_service.getAll();
		m.addAttribute("Post",p);
		return "registration";
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value="handle-registration",method=RequestMethod.POST)
	public RedirectView registration(@ModelAttribute("employee") Employee employee,HttpServletRequest request,Authentication authentication) throws ParseException
	{
		
		Date d1 = new Date();
		DateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
		Date dob=formate.parse(employee.getDob());
		long age1=d1.getTime()-dob.getTime();
		System.out.println(employee);
		int age=(int) (TimeUnit.MILLISECONDS.toDays(age1)/365l);
		employee.setAge(age);
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		System.out.println(employee);
		this.user_service.insert(employee);
		String url="/error";
		RedirectView redirectview=new RedirectView();
		if(authentication==null)
		{
			redirectview.setUrl(request.getContextPath()+"/login");
			return redirectview;
		}
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority a:authorities)
		{
			roles.add(a.getAuthority());
		}
		System.out.println(roles);
		if(roles.contains("ROLE_ADMIN"))
		{
			url="/admin";
		}
		else if(roles.contains("ROLE_CASHIER"))
		{
			url="/cashier/cart";
		}
		else if(roles.contains("ROLE_STAFF"))
		{
			url="/staff";
		}
		
		redirectview.setUrl(request.getContextPath()+url);
		return redirectview;
		
	}

	
	@RequestMapping(value="/user/{username}",method=RequestMethod.GET)
	public String getUser(@PathVariable("username") String username,Authentication authentication,Model m)
	{
		if(authentication==null)
		{
			System.out.println("hello1");
			return "error";
		}
		System.out.println(username);
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority a:authorities)
		{
			roles.add(a.getAuthority());
		}
		String user=authentication.getName();
		Employee u=user_service.getUser(user);
		System.out.println(u);
		if(u.getUsername()!=username && !roles.contains("ROLE_ADMIN"))
		{
			System.out.println("hello2");
			return "error";
		}
		m.addAttribute(m);
		return "user";
		
	}
}
