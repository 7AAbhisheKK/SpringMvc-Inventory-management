package dbms.Entity;

public class Product {
	private int selling_price;
	private int wholesale_price;
	private String Arrival_date;
	private String Expiry_date;
	private int Available_quantity;
	private String Brand;
	private String product_id;
	private String name;
	private String sub_category;
	private int in_quantity;
	private int in_price;
	private int in_wholesale_price;
	private String in_expiry_date;
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
	public String getSub_category() {
		return sub_category;
	}
	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}
	public int getIn_quantity() {
		return in_quantity;
	}
	public void setIn_quantity(int in_quantity) {
		this.in_quantity = in_quantity;
	}
	public int getIn_price() {
		return in_price;
	}
	public void setIn_price(int in_price) {
		this.in_price = in_price;
	}
	public int getIn_wholesale_price() {
		return in_wholesale_price;
	}
	public void setIn_wholesale_price(int in_wholesale_price) {
		this.in_wholesale_price = in_wholesale_price;
	}
	public String getIn_expiry_date() {
		return in_expiry_date;
	}
	public void setIn_expiry_date(String in_expiry_date) {
		this.in_expiry_date = in_expiry_date;
	}
	@Override
	public String toString() {
		return "Product [selling_price=" + selling_price + ", wholesale_price=" + wholesale_price + ", Arrival_date="
				+ Arrival_date + ", Expiry_date=" + Expiry_date + ", Available_quantity=" + Available_quantity
				+ ", Brand=" + Brand + ", product_id=" + product_id + ", name=" + name + ", sub_category="
				+ sub_category + ", in_quantity=" + in_quantity + ", in_price=" + in_price + ", in_wholesale_price="
				+ in_wholesale_price + ", in_expiry_date=" + in_expiry_date + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
