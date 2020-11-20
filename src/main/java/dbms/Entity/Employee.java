package dbms.Entity;

public class Employee {
	private String username;
	private String name;
	private String dob;
	private String date_joined;
	private String date_resigned;
	private String Address;
	private String email;
	private String password;
	private String role;
	private String last_payment;
	private String post_id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	@Override
	public String toString() {
		return "Employee [username=" + username + ", name=" + name + ", dob=" + dob + ", date_joined=" + date_joined
				+ ", date_resigned=" + date_resigned + ", Address=" + Address + ", email=" + email + ", password="
				+ password + ", role=" + role + ", last_payment=" + last_payment + ", post_id=" + post_id + "]";
	}
	public Employee(String username, String name, String dob, String date_joined, String date_resigned, String address,
			String email, String password, String role, String last_payment, String post_id) {
		super();
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.date_joined = date_joined;
		this.date_resigned = date_resigned;
		Address = address;
		this.email = email;
		this.password = password;
		this.role = role;
		this.last_payment = last_payment;
		this.post_id = post_id;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
