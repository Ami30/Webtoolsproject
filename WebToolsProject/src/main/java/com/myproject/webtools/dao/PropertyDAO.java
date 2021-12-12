package com.myproject.webtools.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.myproject.webtools.exception.PropertyException;
import com.myproject.webtools.pojo.Properties;
import com.myproject.webtools.pojo.User;

public class PropertyDAO extends DAO {

	public void createProperty(Properties prop){
        try{
        begin();
        getSession().saveOrUpdate(prop);
        commit();
        }catch(Exception e){
            rollback();
            System.out.println("There was an exception" +e);
        }
        System.out.println("Property added in Database");
    }
 
 
// public User getUser(String userName,String passWord) throws PropertyException {
//        try {
//            begin();
//            Query q = getSession().createQuery("from User where userName = :userName and passWord=:passWord");
//            q.setString("userName", userName);
//            q.setString("passWord", passWord);
//            User user = (User) q.uniqueResult();
//            commit();
//            return user;
//        } catch (HibernateException e) {
//            rollback();
//            throw new UserException("Could not obtain the username " + userName + " " + e.getMessage());
//        }
//    }
	
	 public ArrayList<Properties> getProperties(int propertySellerID) throws PropertyException {
  try {
      begin();
      Query q = getSession().createQuery("from Properties where propertySellerID = :propertySellerID");
      q.setInteger("propertySellerID", propertySellerID);

      ArrayList<Properties> proparray = (ArrayList<Properties>) q.list();
      commit();
      return proparray;
  } catch (HibernateException e) {
      rollback();
      throw new PropertyException("Could not obtain the properties" + " " + e.getMessage());
  }
}
 
 public List list() throws PropertyException {
        try {
            begin();
            Query q = getSession().createQuery("from Properties");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new PropertyException("Could not list the Properties", e);
        }
    }
 
// public int updateprop(int propertyId,String numbathroom,String numrooms,String propertyAdditionalDetails,String propertyAddress, String propertyCity,String propertyName,String propertyPrice,String propertyZipCode,Date propertyLastmodifiedDate)throws PropertyException
//	{
//		try{
//			begin();
//			Query q = getSession().createQuery("UPDATE Properties SET numbathroom = :numbathroom, numrooms= :numrooms,propertyAdditionalDetails= :propertyAdditionalDetails,propertyAddress = :propertyAddress,propertyCity = :propertyCity,propertyName = :propertyName,propertyPrice = :propertyPrice,propertyZipCode = :propertyZipCode,propertyLastmodifiedDate = :propertyLastmodifiedDate WHERE propertyId = :propertyId");
//	      
//			q.setString("numbathroom", numbathroom);
//			q.setString("numrooms",numrooms);
//			q.setString("propertyAdditionalDetails",propertyAdditionalDetails);
//			q.setString("propertyAddress",propertyAddress);
//			q.setString("propertyCity",propertyCity);
//			q.setString("propertyName",propertyName);
//			q.setString("propertyPrice",propertyPrice);
//			q.setString("propertyZipCode",propertyZipCode);
//			q.setDate("propertyLastmodifiedDate",propertyLastmodifiedDate);
//			q.setInteger("propertyId",propertyId);
//			int result=q.executeUpdate();
//			commit();
//			return result;
//			}
//		catch(HibernateException e)
//		{
//			rollback();
//			throw new PropertyException("Could not update Properties information " + e);
//		}
//	}
//	
 
 
 
 public void updateprop(Properties properties) throws PropertyException {
	 try {
			begin();
			getSession().update(properties);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new PropertyException("Could not update Properties information " + e);
		}
	 
 }
 
 public Properties getPropByID(int propertyid) throws PropertyException {
	 try{
			begin();
			Query q = getSession().createQuery("from Properties where propertyid = " + propertyid);
			Properties prop = (Properties) q.uniqueResult();
			commit();
			return prop;
		}
		catch(HibernateException e){
			rollback();
			throw new PropertyException("Could not get Property information " + e);
		}
 }
 
 public boolean updatePropbyId(int propertyId) throws PropertyException {

	 try {
			begin();
			Query q = getSession().createQuery("from Properties where propertyId = :propertyId");
			q.setInteger("propertyId", propertyId);
			Properties prop = (Properties) q.uniqueResult();
			if(prop!=null){				
//				prop.setName(name);
//				prop.setPrice(price);
//				prop.setStock(stock);
				getSession().update(prop);
				commit();
				return true;
			}else{
				return false;
			}
			

		} catch (HibernateException e) {
			rollback();
			throw new PropertyException("Could not update Properties information " + e);
		}
	 
 }
 
 public void deleteprop(int propertyId) {
	 try {
			begin();
			Query q = getSession().createQuery("from Properties where propertyId = " + propertyId);
			Properties prop = (Properties) q.uniqueResult();
			getSession().delete(prop);
			commit();
		} 
		catch (HibernateException e) {
			rollback();
			System.out.println("Could not delete property: " + propertyId +  e.getMessage());
		}	
 }
}
