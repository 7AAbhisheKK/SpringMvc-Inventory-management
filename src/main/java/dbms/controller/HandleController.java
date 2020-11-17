package dbms.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import dbms.Entity.maintenance;
import dbms.Services.Emp_payment.Emp_pay_service_impl;
import dbms.Services.Miscellaneous.Mis_service_impl;
import dbms.Services.Post_s.Post_service_impl;
import dbms.Services.Product.Product_service;
import dbms.Services.User.user_service_impl;
import dbms.Services.maintenance.maintenance_service_impl;

@Controller
@RequestMapping("/admin")
public class HandleController {
	
	@Autowired
	private Product_service product_service;
	@Autowired
	private maintenance_service_impl maintenance_service;
	
	@Autowired
	private Post_service_impl post_service;
	@Autowired
	private user_service_impl user_service;
	@Autowired
	private Emp_pay_service_impl employee_payment_service;
	@Autowired
	private Mis_service_impl mis_service;
	
	
	
	@RequestMapping(value="/add-maintenance",method=RequestMethod.GET)
	public String maintenance(Model m)
	{
		maintenance k=new maintenance();
		m.addAttribute("maintenance",k);
		return "maintain";
	}
	@RequestMapping(value="/handle-maintenance",method=RequestMethod.POST)
	public RedirectView handle_maintenance(@ModelAttribute("maintenance") maintenance m,HttpServletRequest request)
	{
		maintenance_service.insert(m);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath());
		return redirectview;
	}
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public String employee(Model m)
	{
		List<Employee> e=user_service.getAll();
		List<Employee_extended> l=new ArrayList<Employee_extended>();
		for(Employee x:e)
		{
			Post p=post_service.getPost(x.getPost_id());
			Employee_extended temp=new Employee_extended(x,p);
			l.add(temp);
			
		}
		m.addAttribute("employee",l);
		return "employee";
	}
	@RequestMapping(value="/pay/{username}",method=RequestMethod.GET)
	public String pay(Model m,@PathVariable("username") String username)
	{
		Employee e=user_service.getUser(username);
		Post p=post_service.getPost(e.getPost_id());
		Employee_extended employee=new Employee_extended(e,p);
		String description = null;
		m.addAttribute("description",description);
		m.addAttribute("employee",employee);
		return "pay";
	}
	@RequestMapping(value="/handle-pay",method=RequestMethod.POST)
	public RedirectView pay(@ModelAttribute("employee") Employee_extended e,@ModelAttribute("description") String des,HttpServletRequest request)
	{
		Date d1 = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d1);
		employee_payment_service.insert(e.getUsername(), date, e.getSalary(),des);
		user_service.update_date(e.getUsername(), date);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath());
		return redirectview;
	}
	
	@RequestMapping(value="/sale",method=RequestMethod.GET)
	public String handle_Exping_soon(Model m)
	{
		Date d1 = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat( "MMM yyyy", Locale.getDefault() );
		String month=dateFormat.format(d1);
		int profit=mis_service.profit();
		int expenditure=mis_service.Expenditure();
		m.addAttribute("month",month);
		m.addAttribute("profit", profit);
		m.addAttribute("expenditure", expenditure);
		return "sale";
	}
	
	

}
