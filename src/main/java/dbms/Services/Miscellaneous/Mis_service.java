package dbms.Services.Miscellaneous;

import java.util.List;

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

}
