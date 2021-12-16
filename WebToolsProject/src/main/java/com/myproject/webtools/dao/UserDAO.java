package com.myproject.webtools.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.myproject.webtools.exception.PropertyException;
import com.myproject.webtools.exception.UserException;
import com.myproject.webtools.pojo.Properties;
import com.myproject.webtools.pojo.User;

public class UserDAO extends DAO {

	
	 public void createUser(User user){
	        try{
	        begin();
	        getSession().saveOrUpdate(user);
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
	 
	 public ArrayList<User> getUsersbyrole(String role) throws UserException {
  try {
      begin();
      Query q = getSession().createQuery("from User where role LIKE CONCAT('%',:role,'%')");
      q.setString("role", role);

      ArrayList<User> userarray = (ArrayList<User>) q.list();
      commit();
      return userarray;
  } catch (HibernateException e) {
      rollback();
      throw new UserException("Could not obtain the users" + " " + e.getMessage());
  }
  finally {
  	close();
  }
}
	 public ArrayList<User> getUsersbyfname(String fname) throws UserException {
		  try {
		      begin();
		      Query q = getSession().createQuery("from User where fname LIKE CONCAT('%',:fname,'%')");
		      q.setString("fname", fname);

		      ArrayList<User> userarray = (ArrayList<User>) q.list();
		      commit();
		      return userarray;
		  } catch (HibernateException e) {
		      rollback();
		      throw new UserException("Could not obtain the users" + " " + e.getMessage());
		  }
		  finally {
		  	close();
		  }
		}
	 
	 public ArrayList<User> getUsersbylname(String lname) throws UserException {
		  try {
		      begin();
		      Query q = getSession().createQuery("from User where lname LIKE CONCAT('%',:lname,'%')");
		      q.setString("lname", lname);

		      ArrayList<User> userarray = (ArrayList<User>) q.list();
		      commit();
		      return userarray;
		  } catch (HibernateException e) {
		      rollback();
		      throw new UserException("Could not obtain the users" + " " + e.getMessage());
		  }
		  finally {
		  	close();
		  }
		}
	 
	 public ArrayList<User> getallusers() throws UserException {
		  try {
		      begin();
		      Query q = getSession().createQuery("from User");

		      ArrayList<User> userarray = (ArrayList<User>) q.list();
		      commit();
		      return userarray;
		  } catch (HibernateException e) {
		      rollback();
		      throw new UserException("Could not obtain the users" + " " + e.getMessage());
		  }
		  finally {
		  	close();
		  }
		}
	 
	 public User getUser(int userId) throws UserException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User where userName = :userName and passWord=:passWord");
	            q.setInteger("userId", userId);
	            User user = (User) q.uniqueResult();
	            commit();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new UserException("Could not obtain the User " + " " + e.getMessage());
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
