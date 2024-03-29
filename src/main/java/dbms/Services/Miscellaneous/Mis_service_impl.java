package dbms.Services.Miscellaneous;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import dbms.Entity.Employee_payment_extended;
import dbms.Entity.Order_extended;
import dbms.Entity.Product;
import dbms.Entity.Product_order;
import dbms.Services.Product.RowMapperImpl;
import dbms.Services.Product.RowMapperImpl_order;
@Component
public class Mis_service_impl implements Mis_service {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Product> Expired_product() {
		Date d1 = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d1);
		String query="select * from product where in_expiry_date< ? and in_quantity>0";
		List<Product> product=this.jdbcTemplate.query(query, new RowMapperImpl(),date);
		return product;
	}

	public List<Product> Expired_ware() {
		Date d1 = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d1);
		String query="select * from product where expiry_date< ? and available_quantity>0";
		List<Product> product=this.jdbcTemplate.query(query, new RowMapperImpl(),date);
		return product;
	}

	public List<Product> Expiring_one(int interval) {
		String query="select * from product where expiry_date <date_add(now(),interval ? month) and expiry_date >=now() and available_quantity>0";
		List<Product> product=this.jdbcTemplate.query(query, new RowMapperImpl(),interval);
		return product;
	}

	public int Expenditure() {

		String query1="select sum(price) from wholesale_order where month(order_date)=month(now())";
		int amount1=this.jdbcTemplate.queryForObject(query1, new RowMapper_int());
		String query2="select sum(amount) from maintenance where month(date)=month(now())";
		String query3="select sum(amount) from employee_payment where month(date)=month(now())";
		int amount2=this.jdbcTemplate.queryForObject(query2, new RowMapper_int());
		int amount3=this.jdbcTemplate.queryForObject(query3, new RowMapper_int());
		return amount1+amount2+amount3;
	}

	public int profit() {
		String query="select sum(amount) from orders where month(order_date)=month(now())";
		int amount=this.jdbcTemplate.queryForObject(query, new RowMapper_int());
		return amount;
	}

	public List<String> mobile_num(String username) {
		String query="select number from mobile_num where username=?";
		List<String> number=this.jdbcTemplate.query(query, new Row_mapper_string(),username);
		return number;
	}

	public int insert_number(String num1, String num2,String username) {
		String query="insert into mobile_num(number,username) values(?,?)";
		int r=this.jdbcTemplate.update(query,num1,username);
		if(num2.length()!=0)
		{
			r=this.jdbcTemplate.update(query,num2,username);
		}
		return r;
	}

	public boolean validation(String username) {
		String query="select count(*) from employee where username=?";
		int r=this.jdbcTemplate.queryForObject(query, new RowMapper_int(),username);
		if(r==1)
			return true;
		return false;
	}

	public int update_number(String num1, String num2, String username) {
		String query1="select number from mobile_num where username =?";
		List<String> s=this.jdbcTemplate.query(query1, new Row_mapper_string(),username);
		String query2;
		if(s.get(0)!=num1)
		{
			query2="update mobile_num set number=? where username=? and number=?";
			this.jdbcTemplate.update(query2,num1,username,s.get(0));
		}
		if(s.size()>1)
		{
			if(s.get(1)!=num2)
			{
				query2="update mobile_num set number=? where username=? and number=?";
				this.jdbcTemplate.update(query2,num2,username,s.get(1));
			}
		}
		else
		{
			if(num2!=null)
			{
				insert_number(num2,"",username);
			}
		}
		return 0;
	}

	public List<Employee_payment_extended> getEmployee_payment_all() {
		String query="select amount,description,date,name,employee.username from employee_payment,employee where employee.username=employee_payment.username";
		List<Employee_payment_extended> e=this.jdbcTemplate.query(query, new RowMapper_employee_payment_extended());
		return e;
	}

	public List<Employee_payment_extended> getEmployee_payment(String username) {
		String query="select amount,description,date,name,employee.username from employee_payment,employee where employee.username=employee_payment.username and employee_payment.username=?";
		List<Employee_payment_extended> e=this.jdbcTemplate.query(query, new RowMapper_employee_payment_extended(),username);
		return e;
	}

	public int get_maintenance(String month,String year) {
		String query="select sum(amount) from maintenance where month(date)=? and year(date)=?";
		int sum=this.jdbcTemplate.queryForObject(query, new RowMapper_int(),month,year);
		return sum;
	}

	public int get_salary(String month, String year) {
		String query="select sum(amount) from employee_payment where month(date)=? and year(date)=?";
		int sum=this.jdbcTemplate.queryForObject(query, new RowMapper_int(),month,year);
		return sum;
	}

	public int get_order(String month, String year) {
		String query="select sum(amount) from orders where month(order_date)=? and year(order_date)=?";
		int sum=this.jdbcTemplate.queryForObject(query, new RowMapper_int(),month,year);
		return sum;
	}

	public List<Order_extended> get_order_list(String order_id) {
		String query="select amount,customer_name,quantity,(select name from product where product.product_id=purchase_detail.product_id) as name,purchase_detail.product_id,price,order_date from orders,purchase_detail where orders.order_id=? and orders.order_id=purchase_detail.order_id";
		List<Order_extended> l=this.jdbcTemplate.query(query, new RowMapper_order_extended(),order_id);
		return l;
	}

	public int get_whole_order(String month, String year) {
		String query="select sum(price) from wholesale_order where month(order_date)=? and year(order_date)=?";
		int sum=this.jdbcTemplate.queryForObject(query, new RowMapper_int(),month,year);
		return sum;
	}

}
