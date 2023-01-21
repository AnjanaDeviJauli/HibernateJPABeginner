package com.test.project.HibernateJPABeginner.controller;
import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.project.HibernateJPABeginner.models.User;


public class DeletingUser {
	public static void main(String[] args) {
SessionFactory factory = new Configuration()
.configure(new File("src/main/java/com/test/project/HibernateJPABeginner/hibernate.cfg.xml"))
.addAnnotatedClass(User.class)
.buildSessionFactory();		
Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		User u = new User();
	    u.setId(4);
	    session.remove(u);
	    tx.commit();
	    session.close();
	    factory.close();
		}
	}
