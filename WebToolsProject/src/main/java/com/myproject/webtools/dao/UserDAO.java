package com.myproject.webtools.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.myproject.webtools.exception.UserException;
import com.myproject.webtools.pojo.User;

public class UserDAO extends DAO {

	
	 public void createUser(User user){
	        try{
	        begin();
	        getSession().save(user);
	        commit();
	        }catch(Exception e){
	            rollback();
	        }
	        System.out.println("user created in Database");
	    }
	 
	 
	 public User getUser(String userName,String passWord) throws UserException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User where userName = :userName and passWord=:passWord");
	            q.setString("userName", userName);
	            q.setString("passWord", passWord);
	            User user = (User) q.uniqueResult();
	            commit();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not obtain the username " + userName + " " + e.getMessage());
	        }
	    }
	 
	 public List list() throws UserException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User");
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not list the Users", e);
	        }
	    }
}
