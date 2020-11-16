package dbms.Entity;

public class Employee {
	private String username;
	private String name;
	private String dob;
	private String date_joined;
	private String date_resigned;
	private String Address;
	private String email;
	private int age;
	private String password;
	private boolean enable;
	private String role;
	private String last_payment;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
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
	@Override
	public String toString() {
		return "Employee [username=" + username + ", name=" + name + ", dob=" + dob + ", date_joined=" + date_joined
				+ ", date_resigned=" + date_resigned + ", Address=" + Address + ", email=" + email + ", age=" + age
				+ ", password=" + password + ", enable=" + enable + ", role=" + role + ", last_payment=" + last_payment
				+ "]";
	}
	public Employee(String username, String name, String dob, String date_joined, String date_resigned, String address,
			String email, int age, String password, boolean enable, String role, String last_payment) {
		super();
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.date_joined = date_joined;
		this.date_resigned = date_resigned;
		Address = address;
		this.email = email;
		this.age = age;
		this.password = password;
		this.enable = enable;
		this.role = role;
		this.last_payment = last_payment;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
