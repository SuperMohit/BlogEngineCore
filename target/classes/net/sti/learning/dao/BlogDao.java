package net.sti.learning.dao;

import java.util.List;

import net.sti.learning.model.Post;
import net.sti.learning.model.User;

public interface BlogDao {
	public User getUserById(Integer id);
	public User getUserByName(String name);
	public User getUserByNameAndPassword(String name, String password);
	public List<User> getAllUsers();
	public void createUser(User u);
	public void deleteUser(User u);
	public void deleteUserById(Integer id);
	public void editUser(User u);
	public Post getPostById(Integer id);
	public List<Post> getPostsByUserId(Integer id);
	public List<Post> getPostsByUserName(String name);
	public void createPost(Post p, Integer userId);
	public void editPost(Post p);
	public void deletePost(Post p);
	public void deletePostById(Integer id);
}
