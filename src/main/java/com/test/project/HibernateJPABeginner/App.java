package com.test.project.HibernateJPABeginner;
import java.io.File;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.test.project.HibernateJPABeginner.models.User;

/**
 * Hello world!
 *
 */
public class App {

	private static ServiceRegistry registry;
	private static SessionFactory factory;

	public static void main(String[] args) {

		try {

			// configuration
			Configuration conf = new Configuration()
					.configure(new File("src/main/java/com/test/project/HibernateJPABeginner/hibernate.cfg.xml"));
			conf.addAnnotatedClass(User.class);
			// registry
			registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

			factory = conf.buildSessionFactory(registry);

		} catch (Throwable ex) {
			ex.printStackTrace();
		}

		Transaction t = null;
		Session session = factory.openSession();
		try {

			t = session.beginTransaction();
		   //Creating a User table
		     User u = new User();
		       t.commit();
		       System.out.println("successfully created user table");
		} catch (HibernateException ex) {

			ex.printStackTrace();
			t.rollback();

		} finally {
			session.close();}
		
		
		Session session1 = factory.openSession(); 
			try {
		     //Creating User
		       t = session1.beginTransaction();
		       User uOne = new User ("Moh Haseeb","haseeb@gmail.com","has123",20,2000.69,"NYC");
		       User uTwo = new User ("James Santana","James@gmail.com","James123",25,2060.69,"Dallas");
		       User uThree = new User ("AH Shahparan","Shahparan@gmail.com","Shahparan123",30,3060.69,"Chicago");
               User uFour = new User( "Christ", "christ@gmail.com",  "147852", 35, 35000.3,"NJ");
               User uFive = new User("Sid", "Sid", "s258", 29, 4000.36, "LA");
             	session1.persist(uOne); 
            	session1.persist(uTwo); 
            	session1.persist(uThree); 
            	session1.persist(uFour); 
            	session1.persist(uFive); 
             	Integer  userid = null;
                t.commit();
                System.out.println("successfully saved");  
                
			} catch (HibernateException ex) {

				ex.printStackTrace();
				t.rollback();

			} finally {
				session1.close();

			}
			Session session2 = factory.openSession();
                try {
                //Finding User
                t=session2.beginTransaction();
                int USER_ID = 2;
        	    User uFind = session2.find(User.class, USER_ID);
        	    System.out.println("Fullname: " + uFind.getFullname());
        	    System.out.println("Email: " + uFind.getEmail());
        	    System.out.println("password: " + uFind.getPassword());
        	    t.commit();
                
        		} catch (HibernateException ex) {

        			ex.printStackTrace();
        			t.rollback();

        		} finally {
        			session2.close();

        		}
            	Session session3 = factory.openSession();
        	    try {
        	    //Updating a row in a table
        	    t=session3.beginTransaction();
        	    User uUpdate= new User();
                uUpdate.setId(3);
  		    uUpdate.setEmail("mhaseeb@perscholas");
  		    uUpdate.setFullname("M haseeb");
  		    uUpdate.setPassword("123456");
  		    session3.merge(uUpdate);
  		    t.commit();
            
        		} catch (HibernateException ex) {

        			ex.printStackTrace();
        			t.rollback();

        		} finally {
        			session3.close();

        		}
        		Session session4 = factory.openSession();
////  		    //deleting a row 
        	    try {
 		  t=session4.beginTransaction();
 		  User uDelete = new User();
 	    uDelete.setId(2);
 	   session4.remove(uDelete);
 	 
 	    t.commit();
               
                
		} catch (HibernateException ex) {

			ex.printStackTrace();
			t.rollback();

		} finally {
			session4.close();

		}

	}
}
