package dbms.Entity;

public class Post {
	private String post_id;
	private String post_name;
	private int salary;
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
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
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(String post_id, String post_name, int salary) {
		super();
		this.post_id = post_id;
		this.post_name = post_name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", post_name=" + post_name + ", salary=" + salary + "]";
	}

}
