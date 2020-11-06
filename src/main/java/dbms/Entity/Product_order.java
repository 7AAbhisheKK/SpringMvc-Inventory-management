package dbms.Entity;

public class Product_order {
	private String product_id;
	private String name;
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
	public int getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}
	private int selling_price;
	@Override
	public String toString() {
		return "Product_order [product_id=" + product_id + ", name=" + name + ", selling_price=" + selling_price + "]";
	}
	public Product_order(String product_id, String name, int selling_price) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.selling_price = selling_price;
	}
	public Product_order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
