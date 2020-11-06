package dbms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;

import dbms.Entity.Cart;
import dbms.Entity.Category;
import dbms.Entity.Product;
import dbms.Entity.Product_order;
import dbms.Services.Product.Category_service_impl;
import dbms.Services.Product.Product_service_impl;
import dbms.Services.cart.Product_cart_service_impl;

@Controller
public class OrderController {
	
	@Autowired
	private Product_cart_service_impl cart_service;
	
	@Autowired 
	private Category_service_impl category_service;
	
	@Autowired
	private Product_service_impl product_service;

	
	@RequestMapping("/cart")
	public String test1(Model m)
	{
		List<Cart> c=cart_service.get_all();
		m.addAttribute("cart",c);
		return "cart";
	}
	@RequestMapping("/add-cart")
	public String add_cart(Model m)
	{
		List<Category> l=category_service.getAllcategory();
		Cart c=new Cart();
		m.addAttribute("cart",c);
		m.addAttribute("cat",l);
		m.addAttribute("title", "Add Product");
		return "add_cart";
	}
	
	@RequestMapping(value="/test-demo3/{product_id}",method=RequestMethod.GET)
	@ResponseBody
	public String getSellingPrice(@PathVariable("product_id") String product_id,HttpServletRequest request)
	{
		int selling_price=product_service.getselling_price(product_id);
		Gson json=new Gson();
		String price=json.toJson(selling_price);
		System.out.println(price);
		return price;
	}
	@RequestMapping(value="/handle-cart-add",method=RequestMethod.POST)
	public RedirectView handle_add_cart(@ModelAttribute Cart cart,HttpServletRequest request)
	{
		System.out.println(cart);
		cart_service.insert(cart);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/add-cart");
		return redirectview;
	}

}
