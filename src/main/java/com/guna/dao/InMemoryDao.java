package com.guna.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InMemoryDao {
	 public static SessionFactory buildSessionFactory(Class clazz) {
		   return new Configuration()
				   .configure()
				   .addAnnotatedClass(clazz)
				   .buildSessionFactory();
	   }

}
