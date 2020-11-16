package dbms.Services.Miscellaneous;

import java.util.List;

import dbms.Entity.Product;

public interface Mis_service {
	public List<Product> Expired_product();
	public List<Product> Expired_ware();
	public List<Product> Expiring_one(int interval);
	public int Expenditure();
	public int profit();

}
