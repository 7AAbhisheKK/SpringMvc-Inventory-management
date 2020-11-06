package dbms.Entity;

public class Purchase_detail {
	private int quantity;
	private String product_id;
	private int order_id;
	public Purchase_detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchase_detail(int quantity, String product_id, int order_id) {
		super();
		this.quantity = quantity;
		this.product_id = product_id;
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "Purchase_detail [quantity=" + quantity + ", product_id=" + product_id + ", order_id=" + order_id + "]";
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
}
