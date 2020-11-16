package dbms.Services.Post_s;

import java.util.List;

import dbms.Entity.Post;

public interface Post_service {
	public Post get(String username);
	public List<Post> getAll();

}
