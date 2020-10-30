package dbms.Services;

import java.util.List;
import java.util.Map;

import dbms.Entity.Sub_category;

public interface Sub_cat_service {
	public int insert(Sub_category sub_category);
	public List<Sub_category> getAllsub();
	public List<Sub_category> getAllsub_by_cat(String cat_id);
	public Map<String,String> getAllsub_by_cat_in_map(String cat_id);
}
