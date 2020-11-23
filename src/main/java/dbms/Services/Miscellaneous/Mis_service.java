package dbms.Services.Miscellaneous;

import java.util.List;

import dbms.Entity.Employee_payment_extended;
import dbms.Entity.Order_extended;
import dbms.Entity.Product;

public interface Mis_service {
	public List<Product> Expired_product();
	public List<Product> Expired_ware();
	public List<Product> Expiring_one(int interval);
	public int Expenditure();
	public int profit();
	public List<String> mobile_num(String username);
	public int insert_number(String num1,String num2,String username);
	public int update_number(String num1,String num2,String username);
	public boolean validation(String username);
	public List<Employee_payment_extended> getEmployee_payment_all();
	public List<Employee_payment_extended> getEmployee_payment(String username);
	public int get_maintenance(String month,String year);
	public int get_salary(String month,String year);
	public int get_order(String month,String year);
	public int get_whole_order(String month,String year);
	public List<Order_extended> get_order_list(String order_id);
	

}
