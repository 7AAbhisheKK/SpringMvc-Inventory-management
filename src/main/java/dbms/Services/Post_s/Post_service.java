package dbms.Services.Post_s;

import java.util.List;

import dbms.Entity.Post;

public interface Post_service {
	public List<Post> getAll();
	public Post getPost(String post_id);

}
