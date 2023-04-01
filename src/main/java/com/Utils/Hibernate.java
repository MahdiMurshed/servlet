package com.Utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.Entity.Course;
import com.Entity.Department;
import com.Entity.Registration;
import com.Entity.Student;
import com.Entity.Teacher;
//import com.Entity.Demo;
import com.Entity.User;

public class Hibernate {
	 private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		  if (sessionFactory == null) {
		   try {
		    Configuration configuration = new Configuration();
//		    System.out.println("is this work");
		    // Hibernate settings equivalent to hibernate.cfg.xml's properties
		    Properties settings = new Properties();
		    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/servlet_project?useSSL=false");
		    settings.put(Environment.USER, "root");
		    settings.put(Environment.PASS, "{Notredame5058}");
		    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		    settings.put(Environment.FORMAT_SQL, "true");
		    settings.put(Environment.SHOW_SQL, "true");

		    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		    settings.put(Environment.HBM2DDL_AUTO, "update");
//		    settings.put(Environment.USE_SECOND_LEVEL_CACHE,"true");
		    settings.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.EhCacheRegionFactory");
		    System.out.println("dhaldhsld");
//		    settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
//		    settings.put(Environment.cache, settings)u
		    configuration.setProperties(settings);
		    configuration.addAnnotatedClass(User.class);
		    configuration.addAnnotatedClass(Course.class);
		    configuration.addAnnotatedClass(Department.class);
		    configuration.addAnnotatedClass(Student.class);
		    configuration.addAnnotatedClass(Teacher.class);
		    configuration.addAnnotatedClass(Registration.class);

		    
		    
//		    configuration.addAnnotatedClass(Demo.class);

		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    System.out.println("dhaldhsld422");

		    return sessionFactory;

		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		  return sessionFactory;
	}
}