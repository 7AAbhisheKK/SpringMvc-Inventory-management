package dbms.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import dbms.Entity.Order;
import dbms.Entity.Product;
import dbms.Entity.Product_order;
import dbms.Entity.Sub_category;
import dbms.Entity.Wholesale_order;
import dbms.Services.Miscellaneous.Mis_service_impl;
import dbms.Services.Product.Category_service;
import dbms.Services.Product.Product_service;
import dbms.Services.Product.Sub_cat_service;
import dbms.Services.Whole_order.Whole_order;
import dbms.Services.order.Order_service_impl;

@Controller
@RequestMapping("/staff")
public class HomeController {
	@Autowired
	private Product_service product_service;
	@Autowired
	private Category_service category_service;
	@Autowired
	private Sub_cat_service sub_category_service;
	@Autowired
	private Order_service_impl order_service;
	
	@Autowired
	private Whole_order whole_service;
	
	@Autowired
	private Mis_service_impl mis_service;
	
	
	
	@RequestMapping("/test")
	public String test(Model m)
	{
		List<Category> l=category_service.getAllcategory();
		m.addAttribute("cat",l);
		return "test";
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
		redirectview.setUrl(request.getContextPath()+"/staff/category");
		return redirectview;
	}
	@RequestMapping("/sub-category")
	public String subcategory(Model m)
	{
		List<Sub_category> l=sub_category_service.getAllsub();
		m.addAttribute("sub_category",l);
		return "sub_cat";
	}
	@RequestMapping("/add-sub-category")
	public String add_subcategory(Model m)
	{
		m.addAttribute("title","Sub Category");
		List<Category> l=category_service.getAllcategory();
		return "add_sub_cat";
	}
	@RequestMapping(value="/handle-add-sub",method=RequestMethod.POST)
	public RedirectView handle_cat(@ModelAttribute Sub_category sub_category,HttpServletRequest request)
	{
		/* System.out.println(sub_category); */
		sub_category_service.insert(sub_category);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/staff/sub-category");
		return redirectview;
	}
	@RequestMapping("/handle-product-order")
	public String Product_order(Model m)
	{
		
		Product product=new Product();
		m.addAttribute("product",product);
		List<Category> l=category_service.getAllcategory();
		m.addAttribute("cat",l);
		int total=0;
		m.addAttribute("total",total);
		return "product_order";
	}
	@RequestMapping(value="/handle-whole-order",method=RequestMethod.POST)
	public RedirectView whole_order(@ModelAttribute("product") Product product,HttpServletRequest request,@ModelAttribute("total") int total)
	{
		
		Product temp=product_service.getProduct(product.getProduct_id());
		Wholesale_order w=new Wholesale_order();
		Date d1 = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		w.setOrder_date(sdf.format(d1));
		w.setPrice(product.getWholesale_price());
		w.setProduct_id(product.getProduct_id());
		w.setQuantity(product.getAvailable_quantity());
		product.setAvailable_quantity(temp.getAvailable_quantity()+product.getAvailable_quantity());
		product_service.change(product,product.getProduct_id());
		whole_service.insert(w);
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/staff/handle-product-order");
		return redirectview;
	}
	@RequestMapping("/out-stock")
	public String out_stock(Model m)
	{
		List<Product> l=product_service.out_of_stock();
		m.addAttribute("product",l);
		return "out-stock";
	}
	@RequestMapping("/expiring-soon")
	public String Exping_soon(Model m)
	{
		int interval=0;
		m.addAttribute("interval",interval);
		return "expiring-soon";
	}
	@RequestMapping(value="/expired",method=RequestMethod.GET)
	public String expired(Model m)
	{
		
		List<Product> p=mis_service.Expired_product();
		m.addAttribute("product",p);
		return "expired";
	}
	@RequestMapping(value="/expired2",method=RequestMethod.GET)
	public String expired2(Model m)
	{
		
		List<Product> p=mis_service.Expired_ware();
		m.addAttribute("product",p);
		return "expired";
	}
	@RequestMapping(value="/handle-expiring-soon",method=RequestMethod.POST)
	public String handle_Exping_soon(@ModelAttribute("interval") int interval,Model m)
	{
		List<Product> product=mis_service.Expiring_one(interval);
		m.addAttribute("product",product);
		return "expired";
	}
	@RequestMapping(value="/handle-refill/{product_id}",method=RequestMethod.POST)
	public RedirectView handle_refill(@PathVariable("product_id") String product_id,HttpServletRequest request,@ModelAttribute("quantity") int quantity)
	{
		Product p=product_service.getProduct(product_id);
		if(quantity<=p.getAvailable_quantity()&&p.getAvailable_quantity()!=0)
		{
			p.setIn_quantity(quantity);
			p.setAvailable_quantity(p.getAvailable_quantity()-quantity);
			p.setIn_wholesale_price(p.getWholesale_price());
			p.setIn_price(p.getSelling_price());
			p.setIn_expiry_date(p.getExpiry_date());
			product_service.change(p, product_id);
			RedirectView redirectview=new RedirectView();
			redirectview.setUrl(request.getContextPath()+"/staff/out-stock");
			return redirectview;
		}
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/erro");
		return redirectview;
	}
	@RequestMapping(value="/refill/{product_id}",method=RequestMethod.GET)
	public String refill(@PathVariable("product_id") String product_id,HttpServletRequest request,Model m)
	{
		m.addAttribute("product_id",product_id);
		return "refill";
	}
	@RequestMapping(value="/out-stock-ware",method=RequestMethod.GET)
	public String out_stock_ware(Model m)
	{
		List<Product> l=product_service.out_stock_ware();
		m.addAttribute("product",l);
		return "out-stock-ware";
	}
	
	
}
