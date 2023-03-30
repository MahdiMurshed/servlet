package com.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.User;
import com.Utils.Hibernate;

public class UserDao {
	
	@Transactional
	public void saveUser(User user) {
		System.out.println(user.getName()+ " " +user.getAge());
		Transaction transaction=null;
		
		try(Session session = Hibernate.getSessionFactory().openSession()) {
//
			transaction=session.beginTransaction();
			
			session.save(user);
			transaction.commit();

			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("it's in catch");
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
	}
	@Transactional
	public List<User> getUsers(){
		
		try (Session session = Hibernate.getSessionFactory().openSession()) {
			session.beginTransaction();
            
			 List<User> userList =  session.createQuery("from User").list();
	            System.out.println("...........User data..........");
//	            for (User temp : userList) {
//	    System.out.println(temp);
//	   }
	   session.getTransaction().commit();  
	   return userList;
		}
		
	}

}
