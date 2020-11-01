package dbms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dbms.Entity.Product;
import dbms.Entity.Product_order;

@Controller
public class OrderController {
	
	@RequestMapping("/test1")
	public String test1(Model m)
	{
		List<Product_order> p=new ArrayList<Product_order>(20);
		m.addAttribute("products", p);
		return "test";
	}

}
