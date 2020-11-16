package dbms.Entity;

public class Employee_payment {
	private int amount;
	private String description;
	private String date;
	private String username;
	public Employee_payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee_payment(int amount, String description, String date, String username) {
		super();
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.username = username;
	}
	@Override
	public String toString() {
		return "Employee_payment [amount=" + amount + ", description=" + description + ", date=" + date + ", username="
				+ username + "]";
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
