package dbms.Entity;

public class Order_extended {
	private int amount;
	private String customer_name;
	private int quantity;
	private String name;
	private String product_id;
	private int price;
	private String Date;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@Override
	public String toString() {
		return "Order_extended [amount=" + amount + ", customer_name=" + customer_name + ", quantity=" + quantity
				+ ", name=" + name + ", product_id=" + product_id + ", price=" + price + ", Date=" + Date + "]";
	}
	public Order_extended(int amount, String customer_name, int quantity, String name, String product_id, int price,
			String date) {
		super();
		this.amount = amount;
		this.customer_name = customer_name;
		this.quantity = quantity;
		this.name = name;
		this.product_id = product_id;
		this.price = price;
		Date = date;
	}
	public Order_extended() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
