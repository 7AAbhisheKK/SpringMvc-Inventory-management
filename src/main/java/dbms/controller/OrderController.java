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
import dbms.Entity.Order;
import dbms.Entity.Purchase_detail;
import dbms.Services.Product.Category_service_impl;
import dbms.Services.Product.Product_service_impl;
import dbms.Services.Purchase.Purchase_service_impl;
import dbms.Services.cart.Product_cart_service_impl;
import dbms.Services.order.Order_service_impl;

@Controller
public class OrderController {
	
	@Autowired
	private Product_cart_service_impl cart_service;
	
	@Autowired 
	private Category_service_impl category_service;
	
	@Autowired
	private Product_service_impl product_service;
	
	@Autowired
	private Order_service_impl order_service;
	
	@Autowired
	private Purchase_service_impl purchase_service;
	

	
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
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String order(Model m)
	{
		Order order=new Order();
		m.addAttribute("order",order);
		return "order";
	}
	@RequestMapping(value="/handle-order",method=RequestMethod.POST)
	public String handle_order(@ModelAttribute Order order,HttpServletRequest request,Model m)
	{
		List<Cart> c=cart_service.get_all();
		Purchase_detail purchase=new Purchase_detail();
		int sum=0;
		for(Cart x:c)
		{
			sum+=x.getPrice()*x.getQuantity();
		}
		int order_id=order_service.insert(order,sum);
		for(Cart x:c)
		{
			purchase.setProduct_id(x.getProduct_id());
			purchase.setQuantity(x.getQuantity());
			purchase.setOrder_id(order_id);
			purchase.setPrice(x.getPrice());
			purchase_service.insert(purchase);
		}
		m.addAttribute("products",c);
		m.addAttribute("total_price",sum);
		m.addAttribute("order",order);
		m.addAttribute("order_id",order_id);
		cart_service.delete_all();
		return "bill";
		
	}

}
