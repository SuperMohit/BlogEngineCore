package net.sti.learning.service;

import java.util.List;

import net.sti.learning.dao.BlogDao;
import net.sti.learning.model.Post;
import net.sti.learning.model.User;

public class BlogServiceImpl implements BlogService {
	
	private BlogDao blogDao;

	public BlogDao getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.getUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return blogDao.getUserByName(name);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return blogDao.getAllUsers();
	}

	@Override
	public void createUser(User u) {
		blogDao.createUser(u);
	}

	@Override
	public void deleteUser(User u) {
		blogDao.deleteUser(u);
	}

	@Override
	public void deleteUserById(Integer id) {
		blogDao.deleteUserById(id);
	}

	@Override
	public void editUser(User u) {
		blogDao.editUser(u);
	}

	@Override
	public Post getPostById(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.getPostById(id);
	}

	@Override
	public List<Post> getPostsByUserId(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.getPostsByUserId(id);
	}

	@Override
	public List<Post> getPostsByUserName(String name) {
		// TODO Auto-generated method stub
		return blogDao.getPostsByUserName(name);
	}

	@Override
	public void createPost(Post p, Integer userId) {
		blogDao.createPost(p, userId);
	}

	@Override
	public void editPost(Post p) {
		blogDao.editPost(p);
	}

	@Override
	public void deletePost(Post p) {
		blogDao.deletePost(p);
	}

	@Override
	public void deletePostById(Integer id) {
		blogDao.deletePostById(id);
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) {
		return blogDao.getUserByNameAndPassword(name, password);
	}

}
