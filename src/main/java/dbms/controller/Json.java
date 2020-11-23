package dbms.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;

import dbms.Entity.Cart;
import dbms.Entity.Product;
import dbms.Entity.Product_order;
import dbms.Entity.Sub_category;
import dbms.Services.Miscellaneous.Mis_service;
import dbms.Services.Product.Product_service;
import dbms.Services.Product.Sub_cat_service;
@Controller
public class Json {
	
	@Autowired
	private Product_service product_service;
	@Autowired
	private Sub_cat_service sub_category_service;
	@Autowired
	private Mis_service mis_service;
	
	@ResponseBody
	@RequestMapping(value="/test-demo/{cat_id}",method=RequestMethod.GET)
	public String sub(@PathVariable("cat_id") String cat_id,HttpServletRequest request)
	{
		List<Sub_category> l=sub_category_service.getAllsub_by_cat(cat_id);
//		Map<String,String> l= sub_category_service.getAllsub_by_cat_in_map(cat_id);
		
		Gson json=new Gson();
		String Sub_cat=json.toJson(l);
		return Sub_cat;
	}
	@ResponseBody
	@RequestMapping(value="/test-demo2/{sub_cat_id}",method=RequestMethod.GET)
	public String sub_cat(@PathVariable("sub_cat_id") String sub_cat_id,HttpServletRequest request)
	{
		List<Product_order> l=product_service.getAllProduct_order(sub_cat_id);
		
		Gson json=new Gson();
		String product=json.toJson(l);
		return product;
	}
	@ResponseBody
	@RequestMapping(value="/test-demo4/{product_id}",method=RequestMethod.GET)
	public String get_product(@PathVariable("product_id") String product_id,HttpServletRequest request)
	{
		Product l=product_service.getProduct(product_id);
		
		Gson json=new Gson();
		String product=json.toJson(l);
		return product;
	}
	@ResponseBody
	@RequestMapping(value="/test-demo5/{username}",method=RequestMethod.GET)
	public String username_validation(@PathVariable("username") String username,HttpServletRequest request)
	{
		boolean b=mis_service.validation(username);
		Gson json=new Gson();
		String product=json.toJson(b);
		return product;
	}
	
	@RequestMapping(value="/test-demo3/{product_id}",method=RequestMethod.GET)
	@ResponseBody
	public String getSellingPrice(@PathVariable("product_id") String product_id,HttpServletRequest request)
	{
		int selling_price=product_service.getselling_price(product_id);
		Gson json=new Gson();
		String price=json.toJson(selling_price);
		return price;
	}
	@RequestMapping(value="/test-demo6/{product_id}",method=RequestMethod.GET)
	public RedirectView remove_itme(@PathVariable("product_id") String product_id,HttpSession session,HttpServletRequest request)
	{
		List<Cart> c=(List<Cart>) session.getAttribute("cart1");
		Iterator<Cart> iter=c.iterator();
		while(iter.hasNext())
		{
			if(iter.next().getProduct_id().equals(product_id))
			{
				System.out.println("hello");
				iter.remove();
			}
		}
		if(c.size()==0)
		{
			session.setAttribute("cart1", c);
		}
		session.setAttribute("cart1", c);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/cashier/cart");
		return redirectview;
		
	}
	@RequestMapping(value="/test-demo7/",method=RequestMethod.GET)
	public RedirectView remove_itme_all(HttpSession session,HttpServletRequest request)
	{
		session.removeAttribute("cart1");
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/cashier/cart");
		return redirectview;
	}
}
