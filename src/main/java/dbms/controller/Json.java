package dbms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import dbms.Entity.Product;
import dbms.Entity.Product_order;
import dbms.Entity.Sub_category;
import dbms.Services.Product.Product_service;
import dbms.Services.Product.Sub_cat_service;
@Controller
public class Json {
	
	@Autowired
	private Product_service product_service;
	@Autowired
	private Sub_cat_service sub_category_service;
	
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
	
	@RequestMapping(value="/test-demo3/{product_id}",method=RequestMethod.GET)
	@ResponseBody
	public String getSellingPrice(@PathVariable("product_id") String product_id,HttpServletRequest request)
	{
		int selling_price=product_service.getselling_price(product_id);
		Gson json=new Gson();
		String price=json.toJson(selling_price);
		return price;
	}
}
