package dbms.Entity;

public class Product {
	private int selling_price;
	private int wholesale_price;
	private String Arrival_date;
	private String Expiry_date;
	private int Available_quantity;
	private int minimum_quantity;
	private String Brand;
	private String product_id;
	private String name;
	private String sub_category;
	public Product(int selling_price, int wholesale_price, String arrival_date, String expiry_date,
			int available_quantity, int minimum_quantity, String brand, String product_id, String name,
			String sub_category) {
		super();
		this.selling_price = selling_price;
		this.wholesale_price = wholesale_price;
		Arrival_date = arrival_date;
		Expiry_date = expiry_date;
		Available_quantity = available_quantity;
		this.minimum_quantity = minimum_quantity;
		Brand = brand;
		this.product_id = product_id;
		this.name = name;
		this.sub_category = sub_category;
	}
	public String getSub_category() {
		return sub_category;
	}
	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}
	@Override
	public String toString() {
		return "Product [selling_price=" + selling_price + ", wholesale_price=" + wholesale_price + ", Arrival_date="
				+ Arrival_date + ", Expiry_date=" + Expiry_date + ", Available_quantity=" + Available_quantity
				+ ", minimum_quantity=" + minimum_quantity + ", Brand=" + Brand + ", product_id=" + product_id
				+ ", name=" + name + ", sub_category=" + sub_category + "]";
	}
	public Product() {
		super();
	}
	public Product(int selling_price, int wholesale_price, String arrival_date, String expiry_date,
			int available_quantity, int minimum_quantity, String brand, String product_id, String name) {
		super();
		this.selling_price = selling_price;
		this.wholesale_price = wholesale_price;
		this.Arrival_date = arrival_date;
		this.Expiry_date = expiry_date;
		this.Available_quantity = available_quantity;
		this.minimum_quantity = minimum_quantity;
		this.Brand = brand;
		this.product_id = product_id;
		this.name = name;
	}
	
	public int getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}
	public int getWholesale_price() {
		return wholesale_price;
	}
	public void setWholesale_price(int wholesale_price) {
		this.wholesale_price = wholesale_price;
	}
	public String getArrival_date() {
		return Arrival_date;
	}
	public void setArrival_date(String arrival_date) {
		Arrival_date = arrival_date;
	}
	public String getExpiry_date() {
		return Expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		Expiry_date = expiry_date;
	}
	public int getAvailable_quantity() {
		return Available_quantity;
	}
	public void setAvailable_quantity(int available_quantity) {
		Available_quantity = available_quantity;
	}
	public int getMinimum_quantity() {
		return minimum_quantity;
	}
	public void setMinimum_quantity(int minimum_quantity) {
		this.minimum_quantity = minimum_quantity;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
