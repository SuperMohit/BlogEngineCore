package net.sti.learning;

import net.sti.learning.model.Post;
import net.sti.learning.model.User;
import net.sti.learning.service.BlogService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    	
		BlogService blogService = (BlogService)appContext.getBean("myBlogService");
		User u = new User();
		u.setName("Laurent");
		u.setPassword("canardWc");
		blogService.createUser(u);
		Post p = new Post();
		p.setTitle("Un titre");
		blogService.createPost(p, 1);
    }
}
