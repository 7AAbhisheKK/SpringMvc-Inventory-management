package dbms.Entity;

public class Wholesale_order {
	private String product_id;
	private int quantity;
	private int price;
	private String order_date;
	public Wholesale_order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wholesale_order(String product_id, int quantity, int price, String order_date) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return "Wholesale_order [product_id=" + product_id + ", quantity=" + quantity + ", price=" + price
				+ ", order_date=" + order_date + "]";
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}


}
