package dbms.Entity;

public class Order {
	private String order_date;
	private String customer_name;
	private String customer_mobile_number;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String order_date, String customer_name, String customer_mobile_number) {
		super();
		this.order_date = order_date;
		this.customer_name = customer_name;
		this.customer_mobile_number = customer_mobile_number;
	}
	@Override
	public String toString() {
		return "Order [order_date=" + order_date + ", customer_name=" + customer_name + ", customer_mobile_number="
				+ customer_mobile_number + "]";
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_mobile_number() {
		return customer_mobile_number;
	}
	public void setCustomer_mobile_number(String customer_mobile_number) {
		this.customer_mobile_number = customer_mobile_number;
	}
}
