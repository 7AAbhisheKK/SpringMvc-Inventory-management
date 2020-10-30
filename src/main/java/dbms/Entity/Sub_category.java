package dbms.Entity;

public class Sub_category {
	private String sub_category_name;
	private String sub_category_id;
	private String category_id;
	public Sub_category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sub_category(String sub_category_name, String sub_category_id, String category_id) {
		super();
		this.sub_category_name = sub_category_name;
		this.sub_category_id = sub_category_id;
		this.category_id = category_id;
	}
	public String getSub_category_name() {
		return sub_category_name;
	}
	public void setSub_category_name(String sub_category_name) {
		this.sub_category_name = sub_category_name;
	}
	public String getSub_category_id() {
		return sub_category_id;
	}
	public void setSub_category_id(String sub_category_id) {
		this.sub_category_id = sub_category_id;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "Sub_category [sub_category_name=" + sub_category_name + ", sub_category_id=" + sub_category_id
				+ ", category_id=" + category_id + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
