package dbms.Entity;

public class Employee_payment_extended {
	private int amount;
	private String description;
	private String date;
	private String name;
	public Employee_payment_extended() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee_payment_extended(int amount, String description, String date, String name, String username) {
		super();
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.name = name;
		this.username = username;
	}
	@Override
	public String toString() {
		return "Employee_payment_extended [amount=" + amount + ", description=" + description + ", date=" + date
				+ ", name=" + name + ", username=" + username + "]";
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String username;
}
