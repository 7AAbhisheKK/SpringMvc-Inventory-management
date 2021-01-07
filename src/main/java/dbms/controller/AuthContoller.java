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
import dbms.Entity.Employee_extended;
import dbms.Entity.Post;
import dbms.Entity.Product;
import dbms.Services.Miscellaneous.Mis_service_impl;
import dbms.Services.Post_s.Post_service_impl;
import dbms.Services.Product.Product_service;
import dbms.Services.User.user_service_impl;

@Controller
public class AuthContoller {
	@Autowired
	private user_service_impl user_service;
	@Autowired
	private Post_service_impl post_service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private Product_service product_service;
	
	@Autowired
	private Mis_service_impl mis_service;
	@RequestMapping(value="/error",method=RequestMethod.GET)
	public String error()
	{
		
		return "error";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String reg_page(Model m)
	{
		Employee e=new Employee();
		m.addAttribute("employee",e);
		List<Post> p=post_service.getAll();
		m.addAttribute("Post",p);
		String mob1=null,mob2=null;
		m.addAttribute("mob1",mob1);
		m.addAttribute("mob2",mob2);
		return "registration";
	}
	@RequestMapping(value="handle-registration",method=RequestMethod.POST)
	public RedirectView registration(@ModelAttribute("employee") Employee employee,HttpServletRequest request,Authentication authentication,@ModelAttribute("mob1") String mobile1,@ModelAttribute("mob2") String mobile2) throws ParseException
	{
		
//		Date d1 = new Date();
//		DateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
//		Date dob=formate.parse(employee.getDob());
//		long age1=d1.getTime()-dob.getTime();
//		System.out.println(employee);
//		int age=(int) (TimeUnit.MILLISECONDS.toDays(age1)/365l);
		RedirectView redirectview=new RedirectView();
		redirectview.setExposeModelAttributes(false);
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		try{
			this.user_service.insert(employee);
		}
		catch(Exception e)
		{
			redirectview.setUrl(request.getContextPath()+"/error");
			return redirectview;
		}
		
		this.mis_service.insert_number(mobile1, mobile2, employee.getUsername());
		String url="/error";
		
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
			return "error";
		}
		List<String> num=mis_service.mobile_num(username);
		System.out.println(num);
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority a:authorities)
		{
			roles.add(a.getAuthority());
		}
		String user=authentication.getName();
		Employee u=user_service.getUser(username);
		Post p=post_service.getPost(u.getPost_id());
		Employee_extended e=new Employee_extended(u,p);
		System.out.println(e);
		if(!user.equals(username))
		{
			if(!roles.contains("ROLE_ADMIN"))
			{
				return "error";
			}
			
		}
		boolean haspermission=false;
		if(roles.contains("ROLE_ADMIN"))
		{
			haspermission=true;
		}
		m.addAttribute("mob1",num.get(0));
		if(num.size()>1)
		{
			m.addAttribute("mob2",num.get(1));
		}
		else
		{
			m.addAttribute("mob2",null);
		}
		m.addAttribute("employee",e);
		m.addAttribute("permission", haspermission);
		return "user";
		
	}
	
	@RequestMapping(value="/user/handle-user-change-pass/{username}",method=RequestMethod.GET)
	public String useredit(@PathVariable("username") String username,Authentication authentication,Model m)
	{
		if(authentication==null)
		{
			System.out.println("hello1");
			return "error";
		}
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority a:authorities)
		{
			roles.add(a.getAuthority());
		}
		String user=authentication.getName();
		Employee u=user_service.getUser(user);
		Post p=post_service.getPost(u.getPost_id());
		Employee_extended e=new Employee_extended(u,p);
		if(!u.getUsername().equals(username) && !roles.contains("ROLE_ADMIN"))
		{
			return "error";
		}
		String password1=null;
		String password2=null;
		boolean permission=false;
		if(roles.contains("ROLE_ADMIN"))
		{
			permission=true;
		}
		m.addAttribute("permission", permission);
		m.addAttribute("password1",password1);
		m.addAttribute("password2", password2);
		return "pass-change";
		
	}
	@RequestMapping(value="/user/handle-user-change-password/{username}",method=RequestMethod.POST)
	public RedirectView userpass(@PathVariable("username") String username,@ModelAttribute("password1") String password1,Authentication authentication,@ModelAttribute("password2") String password2,HttpServletRequest request)
	{
		RedirectView redirectview=new RedirectView();
		redirectview.setExposeModelAttributes(false);
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
		String user=authentication.getName();
		Employee u=user_service.getUser(user);
		Post p=post_service.getPost(u.getPost_id());
		Employee_extended e=new Employee_extended(u,p);
		if(!u.getUsername().equals(username) && !roles.contains("ROLE_ADMIN"))
		{
			redirectview.setUrl(request.getContextPath()+"/error");
			return redirectview;
		}
		if(roles.contains("ROLE_ADMIN")||passwordEncoder.matches(password1, u.getPassword()))
		{
			user_service.updatepass(username, passwordEncoder.encode(password2));
		}
		else
		{
			redirectview.setUrl(request.getContextPath()+"/error");
			return redirectview;
		}
		
		redirectview.setUrl(request.getContextPath());
		return redirectview;
		
	}
	
	@RequestMapping(value="/user/user-edit/{username}",method=RequestMethod.GET)
	public String useredit(@PathVariable("username") String username,Authentication authentication,HttpServletRequest request,Model m)
	{
		
		if(authentication==null)
		{
			return "error";
		}
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority a:authorities)
		{
			roles.add(a.getAuthority());
		}
		if(!roles.contains("ROLE_ADMIN"))
		{
			return "error";
		}
		Employee u=user_service.getUser(username);
		Post p=post_service.getPost(u.getPost_id());
		List<Post> post=post_service.getAll();
		
		List<String> num=mis_service.mobile_num(username);
		m.addAttribute("employee", u);
		m.addAttribute("post", post);
		m.addAttribute("defaultpost", p);
		m.addAttribute("mob1", num.get(0));
		if(num.size()>1)
		{
			m.addAttribute("mob2", num.get(1));
		}
		else
		{
			m.addAttribute("mob2", null);
		}

		return "user-edit";
		
	}
	@RequestMapping(value="/user/handle-user-edit/{username}",method=RequestMethod.POST)
	public RedirectView handleuseredit(@PathVariable("username") String username,Authentication authentication,HttpServletRequest request,@ModelAttribute("employee") Employee e,@ModelAttribute("mob1") String mob1,@ModelAttribute("mob2") String mob2)
	{
		RedirectView redirectview=new RedirectView();
		redirectview.setExposeModelAttributes(false);
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
		Employee u=user_service.getUser(username);
		if(!roles.contains("ROLE_ADMIN"))
		{
			redirectview.setUrl(request.getContextPath()+"/login");
			return redirectview;
		}
		System.out.println(e);
		u.setName(e.getName());
		u.setAddress(e.getAddress());
		u.setDob(e.getDob());
		u.setPost_id(e.getPost_id());
		u.setEmail(e.getEmail());
		user_service.update(u);
		mis_service.update_number(mob1, mob2, username);
		
		redirectview.setUrl(request.getContextPath()+"/user/"+username);
		return redirectview;
		
	}
	@RequestMapping("/")
	public RedirectView Home(Model m,Authentication authentication,HttpServletRequest request)
	{
		RedirectView redirectview=new RedirectView();
		redirectview.setExposeModelAttributes(false);
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
		if(roles.contains("ROLE_ADMIN"))
		{
			redirectview.setUrl(request.getContextPath()+"/admin");
			return redirectview;
		}
		else if(roles.contains("ROLE_STAFF"))
		{
			redirectview.setUrl(request.getContextPath()+"/staff");
			return redirectview;
		}
		else if(roles.contains("ROLE_CASHIER"))
		{
			redirectview.setUrl(request.getContextPath()+"/cashier/cart");
			return redirectview;
		}
		redirectview.setUrl(request.getContextPath()+"/error");
		return redirectview;
		
		
	}
}
