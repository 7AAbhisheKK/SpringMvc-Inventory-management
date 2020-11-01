package dbms.controller;

import java.util.List;
import java.util.Map;

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

import dbms.Entity.Category;
import dbms.Entity.Product;
import dbms.Entity.Sub_category;
import dbms.Services.Category_service;
import dbms.Services.Product_service;
import dbms.Services.Sub_cat_service;

@Controller
public class HomeController {
	@Autowired
	private Product_service product_service;
	@Autowired
	private Category_service category_service;
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
		System.out.println(Sub_cat);
		return Sub_cat;
	}
	
	
	
	@RequestMapping("/test")
	public String test(Model m)
	{
		List<Category> l=category_service.getAllcategory();
		m.addAttribute("cat",l);
		return "test";
	}
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> l=product_service.getAllProduct();
		m.addAttribute("product",l);
		System.out.println(l);
		return "index";
	}
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		List<Category> l=category_service.getAllcategory();
		m.addAttribute("cat",l);
		m.addAttribute("title", "Add Product");
		return "add_product";
	}
	@RequestMapping(value="/handle-add",method=RequestMethod.POST)
	public RedirectView handle_add(@ModelAttribute Product product,HttpServletRequest request)
	{
		System.out.println(product);
		product_service.insert(product);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/");
		return redirectview;
	}
	@RequestMapping(value="/handle-delete/{product_id}",method=RequestMethod.GET)
	public RedirectView handle_delete(@PathVariable("product_id") String product_id,HttpServletRequest request)
	{
		product_service.delete(product_id);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/");
		return redirectview;
	}
	@RequestMapping("/handle-update/{product_id}")
	
	public  String Updateform(@PathVariable("product_id") String product_id,Model model)
	{
		Boolean v=false;
		Product product=product_service.getProduct(product_id);
		if(product.getExpiry_date()==null || product.getExpiry_date().isEmpty())
		{
			v=true;
		}
		model.addAttribute("v",v);
		model.addAttribute(product);
		model.addAttribute("product_id",product_id);
		System.out.println(v);
		return "update_form";
	}
	@RequestMapping("/update/{product_id}")
	public RedirectView update(@ModelAttribute Product product,@PathVariable("product_id") String product_id,HttpServletRequest request)
	{
		product_service.change(product,product_id);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/");
		return redirectview;
	}
	
	
	
	@RequestMapping("/category")
	public String category(Model m)
	{
		List<Category> l=category_service.getAllcategory();
		m.addAttribute("category",l);
		System.out.println(l);
		return "category";
	}
	@RequestMapping("/add-category")
	public String add_category(Model m)
	{
		
		m.addAttribute("title","Add Category");
		return "add_category";
	}
	@RequestMapping(value="/handle-add_cat",method=RequestMethod.POST)
	public RedirectView handle_cat(@ModelAttribute Category category,HttpServletRequest request)
	{
		category_service.insert(category);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/category");
		return redirectview;
	}
	@RequestMapping("/sub-category")
	public String subcategory(Model m)
	{
		List<Sub_category> l=sub_category_service.getAllsub();
		m.addAttribute("sub_category",l);
		System.out.println(l);
		return "sub_cat";
	}
	@RequestMapping("/add-sub-category")
	public String add_subcategory(Model m)
	{
		m.addAttribute("title","Sub Category");
		List<Category> l=category_service.getAllcategory();
		m.addAttribute("category",l);
		return "add_sub_cat";
	}
	@RequestMapping(value="/handle-add-sub",method=RequestMethod.POST)
	public RedirectView handle_cat(@ModelAttribute Sub_category sub_category,HttpServletRequest request)
	{
		/* System.out.println(sub_category); */
		sub_category_service.insert(sub_category);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/sub-category");
		return redirectview;
	}
}
