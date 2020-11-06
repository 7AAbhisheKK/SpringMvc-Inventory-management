package dbms.Entity;

public class Order {
	private int order_id;
	private int product_id;
	private int quantity;
	private String order_date;
	private String month_year;
	public Order(int order_id, int product_id, int quantity, String order_date, String month_year) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.order_date = order_date;
		this.month_year = month_year;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", product_id=" + product_id + ", quantity=" + quantity + ", order_date="
				+ order_date + ", month_year=" + month_year + "]";
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getMonth_year() {
		return month_year;
	}
	public void setMonth_year(String month_year) {
		this.month_year = month_year;
	}

}
