package dbms.Entity;

public class Cart_extended {
	private String product_id;
	private String name;
	private int quantity;
	private int price;
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
	public Cart_extended() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart_extended(String product_id, String name, int quantity, int price) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart_extended [product_id=" + product_id + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
}
