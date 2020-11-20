package dbms.Entity;

public class Employee_extended {
	private String name;
	private String username;
	private String dob;
	private String date_joined;
	private String date_resigned;
	private String Address;
	private String email;
	private String role;
	private String last_payment;
	private String post_name;
	private int salary;
	public Employee_extended(Employee e,Post p)
	{
		this.username=e.getUsername();
		this.name=e.getName();
		this.dob=e.getDob();
		this.date_joined=e.getDate_joined();
		this.date_resigned=e.getDate_resigned();
		this.Address=e.getAddress();
		this.email=e.getEmail();
		this.role=e.getRole();
		this.last_payment=e.getLast_payment();
		this.post_name=p.getPost_name();
		this.salary=p.getSalary();
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDate_joined() {
		return date_joined;
	}
	public void setDate_joined(String date_joined) {
		this.date_joined = date_joined;
	}
	public String getDate_resigned() {
		return date_resigned;
	}
	public void setDate_resigned(String date_resigned) {
		this.date_resigned = date_resigned;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLast_payment() {
		return last_payment;
	}
	public void setLast_payment(String last_payment) {
		this.last_payment = last_payment;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee_extended [name=" + name + ", username=" + username + ", dob=" + dob + ", date_joined="
				+ date_joined + ", date_resigned=" + date_resigned + ", Address=" + Address + ", email=" + email
				+  ", role=" + role + ", last_payment=" + last_payment + ", post_name=" + post_name
				+ ", salary=" + salary + "]";
	}
	public Employee_extended() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee_extended(String name, String username, String dob, String date_joined, String date_resigned,
			String address, String email, String role, String last_payment, String post_name, int salary) {
		super();
		this.name = name;
		this.username = username;
		this.dob = dob;
		this.date_joined = date_joined;
		this.date_resigned = date_resigned;
		Address = address;
		this.email = email;
		this.role = role;
		this.last_payment = last_payment;
		this.post_name = post_name;
		this.salary = salary;
	}

	
	
}
