package net.sti.learning.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.sti.learning.model.Post;
import net.sti.learning.model.User;

public class BlogDaoImpl implements BlogDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUserById(Integer id) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		User u = (User) s.get(User.class, id);
		tx.commit();
		return u;
	}

	@Override
	public User getUserByName(String name) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from User as u where u.name like :name");
		q.setParameter("name", name);
		User u = (User) q.uniqueResult();
		tx.commit();
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		List<User> users = s.createQuery("from User").list();
		tx.commit();
		return users;
	}

	@Override
	public void createUser(User u) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.save(u);
		tx.commit();
	}

	@Override
	public void deleteUser(User u) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(u);
		tx.commit();
	}

	@Override
	public void deleteUserById(Integer id) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		User u = (User) s.get(User.class, id);
		s.delete(u);
		tx.commit();
	}

	@Override
	public void editUser(User u) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.update(u);
		tx.commit();
	}

	@Override
	public Post getPostById(Integer id) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Post p = (Post) s.get(Post.class, id);
		tx.commit();
		return p;
	}

	@Override
	public List<Post> getPostsByUserId(Integer id) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Post as p where p.author.id = :id");
		q.setParameter("id", id);
		List<Post> posts = q.list();
		tx.commit();
		return posts;
	}

	@Override
	public List<Post> getPostsByUserName(String name) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s
				.createQuery("from Post as p where p.author.name like :name");
		q.setParameter("name", name);
		List<Post> posts = q.list();
		tx.commit();
		return posts;
	}

	@Override
	public void createPost(Post p, Integer userId) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Date date = new Date();
		// Get the user
		User u = (User) s.get(User.class, userId);
		if (u != null) {
			p.setDate_created(date);
			p.setDate_modified(date);
			u.getPosts().add(p);
			p.setAuthor(u);
		}
		tx.commit();
	}

	@Override
	public void editPost(Post p) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		p.setDate_modified(new Date());
		s.update(p);
		tx.commit();
	}

	@Override
	public void deletePost(Post p) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(p);
		tx.commit();
	}

	@Override
	public void deletePostById(Integer id) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Post p = (Post) s.get(Post.class, id);
		s.delete(p);
		tx.commit();
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) {
		Session s = this.sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from User u where u.name like :name and u.password like :password");
		q.setString("name", name);
		q.setString("password", password);
		User u = (User) q.uniqueResult();
		tx.commit();
		return u;
	}

}
