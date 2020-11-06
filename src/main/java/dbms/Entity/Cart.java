package dbms.Entity;

public class Cart {
	private String product_id;
	private String name;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String product_id, String name, int price, int quantity) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [product_id=" + product_id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ "]";
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private int price;
	private int quantity;

}
