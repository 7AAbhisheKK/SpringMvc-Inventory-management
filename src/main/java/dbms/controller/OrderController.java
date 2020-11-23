package dbms.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import dbms.Entity.Cart_extended;
import dbms.Entity.Category;
import dbms.Entity.Order;
import dbms.Entity.Product;
import dbms.Entity.Purchase_detail;
import dbms.Services.Product.Category_service_impl;
import dbms.Services.Product.Product_service_impl;
import dbms.Services.Purchase.Purchase_service_impl;
import dbms.Services.cart.Product_cart_service_impl;
import dbms.Services.order.Order_service_impl;

@Controller
@RequestMapping("/cashier")
public class OrderController {
	
	
	@Autowired 
	private Category_service_impl category_service;
	
	@Autowired
	private Product_service_impl product_service;
	
	@Autowired
	private Order_service_impl order_service;
	
	@Autowired
	private Purchase_service_impl purchase_service;
	

	
	@RequestMapping("/cart")
	public String test1(Model m,HttpSession session)
	{
		List<Cart> c=(List<Cart>) session.getAttribute("cart1");
		List<Cart_extended> cx=null;
		if(c!=null)
		{
			cx=new ArrayList<Cart_extended>();
			for(Cart x:c)
			{
				Product p=product_service.getProduct(x.getProduct_id());
				Cart_extended temp=new Cart_extended();
				temp.setName(p.getName());
				temp.setQuantity(x.getQuantity());
				temp.setProduct_id(x.getProduct_id());
				temp.setPrice(p.getIn_price());
				cx.add(temp);
			}
		}
		m.addAttribute("cart",cx);
		return "cart";
	}
	@RequestMapping("/add-cart")
	public String add_cart(Model m)
	{
		List<Category> l=category_service.getAllcategory();
		Cart c=new Cart();
		m.addAttribute("cat",l);
		m.addAttribute("title", "Add Product");
		return "add_cart";
	}
	
	
	@RequestMapping(value="/handle-cart-add",method=RequestMethod.POST)
	public RedirectView handle_add_cart(@ModelAttribute Cart cart,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		List<Cart> c=(List<Cart>) session.getAttribute("cart1");
		if(c==null)
		{
			c=new ArrayList<Cart>();
			c.add(cart);
			session.setAttribute("cart1", c);
		}
		else
		{
			c=(List<Cart>) session.getAttribute("cart1");
			c.add(cart);
			session.setAttribute("cart1", c);
		}
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/cashier/add-cart");
		return redirectview;
	}
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String order(Model m,HttpSession session)
	{
		List<Cart> c=(List<Cart>) session.getAttribute("cart1");
		if(c==null)
		{
			return "error";
		}
		Order order=new Order();
		Date d1 = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		order.setOrder_date(sdf.format(d1));
		m.addAttribute("order",order);
		return "order";
	}
	@RequestMapping(value="/handle-order",method=RequestMethod.POST)
	public String handle_order(@ModelAttribute Order order,HttpServletRequest request,Model m,HttpSession session)
	{
		List<Cart> c=(List<Cart>) session.getAttribute("cart1");
		Purchase_detail purchase=new Purchase_detail();
		List<Cart_extended> cx = null;
		if(c!=null)
		{
			cx=new ArrayList<Cart_extended>();
			for(Cart x:c)
			{
				Product p=product_service.getProduct(x.getProduct_id());
				Cart_extended temp=new Cart_extended();
				temp.setName(p.getName());
				temp.setQuantity(x.getQuantity());
				temp.setProduct_id(x.getProduct_id());
				temp.setPrice(p.getIn_price());
				cx.add(temp);
			}
		}
		int sum=0;
		for(Cart_extended x:cx)
		{
			sum+=x.getPrice()*x.getQuantity();
		}
		int order_id=order_service.insert(order,sum);
		for(Cart_extended x:cx)
		{
			purchase.setProduct_id(x.getProduct_id());
			purchase.setQuantity(x.getQuantity());
			purchase.setOrder_id(order_id);
			purchase.setPrice(x.getPrice());
			purchase_service.insert(purchase);
			Product temp=product_service.getProduct(x.getProduct_id());
			temp.setIn_quantity(temp.getIn_quantity()-x.getQuantity());
			product_service.change(temp, temp.getProduct_id());
		}
		m.addAttribute("products",cx);
		m.addAttribute("total_price",sum);
		m.addAttribute("order",order);
		m.addAttribute("order_id",order_id);
		session.removeAttribute("cart1");
		return "bill";
		
		
	}

}
