package net.sti.learning.dao;

import java.util.List;

import junit.framework.TestCase;
import net.sti.learning.model.Post;
import net.sti.learning.model.User;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlogDaoImplTest extends TestCase {

	BlogDao blogDao;
	ClassPathXmlApplicationContext appContext;
	
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		blogDao = (BlogDaoImpl) appContext.getBean("myBlogDaoTest");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetUserById() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		// Nous voulons recuperer l'utilisateur qui a l'id 1
		User myUser = blogDao.getUserById(1);
		// L'objet recupere est non null
		assertNotNull(myUser);
		// L'id de l'objet attendu doit etre egal a 1
		assertEquals(1, myUser.getId().intValue());
	}

	public void testGetUserByName() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		// Nous voulons recuperer l'utilisateur fabien
		User myUser = blogDao.getUserByName("fabien");
		assertNotNull(myUser);
		assertEquals("fabien", myUser.getName());
	}
	
	public void testGetUserByNameAndPassword() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		// Nous voulons recuperer l'utilisateur fabien
		User myUser = blogDao.getUserByNameAndPassword("fabien","p@ssw0rd");
		assertNotNull(myUser);
		assertEquals("fabien", myUser.getName());
		assertEquals("p@ssw0rd", myUser.getPassword());
	}

	public void testGetAllUsers() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		// Nous avons en tout 3 utilisateurs a recuperer
		List<User> myUsers = blogDao.getAllUsers();
		assertNotNull(myUsers);
		assertEquals(3, myUsers.size());
	}

	public void testCreateUser() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		String username = "dominique";
		String password = "qwerty";
		User myUser = new User();
		myUser.setName(username);
		myUser.setPassword(password);
		blogDao.createUser(myUser);
		// Maintenant myUser devrait avoir un ID
		assertNotNull(myUser.getId());
		
		// Recuperons l'utilisateur que nous venons de creer
		User userFromDb = blogDao.getUserById(myUser.getId());
		assertEquals(username, userFromDb.getName());
		assertEquals(password, userFromDb.getPassword());
	}

	public void testDeleteUser() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		// Supprimons le lapin id 3! Jean si tu me lis :D
		User myUser = blogDao.getUserById(3);
		blogDao.deleteUser(myUser);
		User userFromDb = blogDao.getUserById(3);
		assertNull(userFromDb);
	}

	public void testDeleteUserById() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		// Supprimons encore ce bon vieux lapin (qui a pour id 3) :D
		blogDao.deleteUserById(3);
		User userFromDb = blogDao.getUserById(3);
		assertNull(userFromDb);
	}

	public void testEditUser() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		String username = "canardwc";
		User userFromDb = blogDao.getUserById(1);
		userFromDb.setName(username);
		
		blogDao.editUser(userFromDb);
		
		User myUser = blogDao.getUserById(1);
		assertEquals(username, myUser.getName());
	}

	public void testGetPostById() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		Post myPost = blogDao.getPostById(1);
		assertNotNull(myPost);
	}

	public void testGetPostsByUserId() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		List<Post> myPosts = blogDao.getPostsByUserId(1);
		assertNotNull(myPosts);
		assertEquals(5, myPosts.size());
	}

	public void testGetPostsByUserName() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		// Recuperons les posts de jean
		List<Post> myPosts = blogDao.getPostsByUserName("jean");
		assertNotNull(myPosts);
		assertEquals(5, myPosts.size());
	}

	public void testCreatePost() {
		// Nous utilisons le fichier de insert.sql qui peuple la base de test
		// Creons un nouveau post a l'utilisateur fabien
		Post myPost = new Post();
		String title = "Nouvel article";
		String content = "Nouveau contenu";
		myPost.setTitle(title);
		myPost.setContent(content);
		
		blogDao.createPost(myPost, 2);
		
		// Chaque utilisateur ayant seulement 5 posts chacun, nous devrions maintenant en avoir 6
		List<Post> postsFromDb = blogDao.getPostsByUserId(2);
		// Vu que c'est un index 0, le 6eme post s'obtient avec l'index 5
		Post lastOne = postsFromDb.get(5);
		assertNotNull(lastOne);
		assertNotNull(lastOne.getId());
		assertEquals(title, lastOne.getTitle());
		assertEquals(content, lastOne.getContent());
		assertNotNull(lastOne.getDate_created());
		assertNotNull(lastOne.getDate_modified());
	}

	public void testEditPost() {
		String title = "Titre modifie";
		Post myPost = blogDao.getPostById(1);
		myPost.setTitle(title);
		blogDao.editPost(myPost);
		
		Post postFromDb = blogDao.getPostById(1);
		assertEquals(title, postFromDb.getTitle());
		assertNotSame(myPost.getDate_modified(), postFromDb.getDate_modified());
	}

	public void testDeletePost() {
		Post myPost = blogDao.getPostById(1);
		blogDao.deletePost(myPost);
		Post postFromDb = blogDao.getPostById(1);
		assertNull(postFromDb);
	}

	public void testDeletePostById() {
		Post myPost = blogDao.getPostById(1);
		blogDao.deletePostById(1);
		Post postFromDb = blogDao.getPostById(1);
		assertNull(postFromDb);
	}

}
