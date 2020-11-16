package dbms.Entity;

public class maintenance {
	private String description;
	private int amount;
	private String date;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "maintenance [description=" + description + ", amount=" + amount + ", date=" + date + "]";
	}
	public maintenance(String description, int amount, String date) {
		super();
		this.description = description;
		this.amount = amount;
		this.date = date;
	}
	public maintenance() {
		super();
		// TODO Auto-generated constructor stub
	}

}
