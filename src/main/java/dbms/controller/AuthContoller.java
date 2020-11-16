package dbms.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import dbms.Entity.Employee;
import dbms.Services.User.user_service_impl;

@Controller
public class AuthContoller {
	@Autowired
	private user_service_impl user_service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String reg_page(Model m)
	{
		Employee e=new Employee();
		m.addAttribute("employee",e);
		return "registration";
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value="handle-registration",method=RequestMethod.POST)
	public RedirectView registration(@ModelAttribute("employee") Employee employee,HttpServletRequest request) throws ParseException
	{
		Date d1 = new Date();
		DateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
		Date dob=formate.parse(employee.getDob());
		long age1=d1.getTime()-dob.getTime();
		System.out.println(employee);
		int age=(int) (TimeUnit.MILLISECONDS.toDays(age1)/365l);
		employee.setAge(age);
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		this.user_service.insert(employee);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath());
		return redirectview;
		
	}

}
