package dbms.Entity;

public class Order {
	private int order_date;
	private String customer_name;
	private String customer_mobile_number;
	private String month_year;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int order_date, String customer_name, String customer_mobile_number, String month_year) {
		super();
		this.order_date = order_date;
		this.customer_name = customer_name;
		this.customer_mobile_number = customer_mobile_number;
		this.month_year = month_year;
	}
	@Override
	public String toString() {
		return "Order [order_date=" + order_date + ", customer_name=" + customer_name + ", customer_mobile_number="
				+ customer_mobile_number + ", month_year=" + month_year + "]";
	}
	public int getOrder_date() {
		return order_date;
	}
	public void setOrder_date(int order_date) {
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
	public String getMonth_year() {
		return month_year;
	}
	public void setMonth_year(String month_year) {
		this.month_year = month_year;
	}
}
