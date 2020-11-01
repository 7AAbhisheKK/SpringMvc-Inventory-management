package dbms.Entity;

public class Product_order {
	private String product_id;
	private int quantity;
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
	@Override
	public String toString() {
		return "Product_order [product_id=" + product_id + ", quantity=" + quantity + "]";
	}
	public Product_order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product_order(String product_id, int quantity) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
	}

}
