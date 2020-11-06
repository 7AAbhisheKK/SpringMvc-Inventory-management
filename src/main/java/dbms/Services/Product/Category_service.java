package dbms.Services.Product;

import java.util.List;

import dbms.Entity.Category;

public interface Category_service {
	public int insert(Category category);
	public List<Category> getAllcategory();
}
