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

	public void createProperty(Properties prop,User user){
        try{
        begin();
        prop.setPropertySellerID(user);
        //user.addProperty(prop);
        getSession().saveOrUpdate(prop);
        commit();
        }catch(Exception e){
            rollback();
            System.out.println("There was an exception" +e);
        }              
        finally {
        	close();
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
  finally {
  	close();
  }
}
	 
	 public ArrayList<Properties> getPropertiesbystatus(String available) throws PropertyException {
  try {
      begin();
      Query q = getSession().createQuery("from Properties where available = :available");
      q.setString("propertySellerID", available);

      ArrayList<Properties> proparray = (ArrayList<Properties>) q.list();
      commit();
      return proparray;
  } catch (HibernateException e) {
      rollback();
      throw new PropertyException("Could not obtain the properties" + " " + e.getMessage());
  }
  finally {
  	close();
  }
}
	 
	 public ArrayList<Properties> getPropertiessearchCity(String propertyCity) throws PropertyException {
  try {
      begin();
      Query q = getSession().createQuery("from Properties where propertyCity LIKE CONCAT('%',:propertyCity,'%')");
      q.setString("propertyCity", propertyCity);
      ArrayList<Properties> proparray = (ArrayList<Properties>) q.list();
      commit();
      return proparray;
  } catch (HibernateException e) {
      rollback();
      throw new PropertyException("Could not obtain the properties" + " " + e.getMessage());
  }
  finally {
  	close();
  }
}
	 public ArrayList<Properties> getPropertiessearchZipCode(String propertyZipCode) throws PropertyException {
  try {
      begin();
      Query q = getSession().createQuery("from Properties where propertyZipCode LIKE CONCAT('%',:propertyZipCode,'%')");
      q.setString("propertyZipCode", propertyZipCode);
      ArrayList<Properties> proparray = (ArrayList<Properties>) q.list();
      commit();
      return proparray;
  } catch (HibernateException e) {
      rollback();
      throw new PropertyException("Could not obtain the properties" + " " + e.getMessage());
  }
  finally {
  	close();
  }
}
	 
	 public ArrayList<Properties> getPropertiessearchPropOwner(String propertyOwner) throws PropertyException {
  try {
      begin();
      Query q = getSession().createQuery("from Properties where propertyOwner LIKE CONCAT('%',:propertyOwner,'%')");
      q.setString("propertyOwner", propertyOwner);
      ArrayList<Properties> proparray = (ArrayList<Properties>) q.list();
      commit();
      return proparray;
  } catch (HibernateException e) {
      rollback();
      throw new PropertyException("Could not obtain the properties" + " " + e.getMessage());
  }
  finally {
  	close();
  }
}
	 
	 public ArrayList<Properties> getPropertiessearchavailable(String available) throws PropertyException {
  try {
      begin();
      Query q = getSession().createQuery("from Properties where available LIKE CONCAT('%',:available,'%')");
      q.setString("available", available);
      ArrayList<Properties> proparray = (ArrayList<Properties>) q.list();
      commit();
      return proparray;
  } catch (HibernateException e) {
      rollback();
      throw new PropertyException("Could not obtain the properties" + " " + e.getMessage());
  }
  finally {
  	close();
  }
}
	 
	 
 
	 public ArrayList<Properties> getallProperties() throws PropertyException {
  try {
      begin();
      Query q = getSession().createQuery("from Properties order by propertyLastmodifiedDate desc");

      ArrayList<Properties> proparray = (ArrayList<Properties>) q.list();
      commit();
      return proparray;
  } catch (HibernateException e) {
      rollback();
      throw new PropertyException("Could not obtain all the properties" + " " + e.getMessage());
  }
  finally {
  	close();
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
        finally {
        	close();
        }
    }
 
 
 public void updatepropquotebyID(int propertyId,int propertyBuyerID,String intrestedBuyerQuote,String propertyBuyercomments,String propertyBuyerName) throws PropertyException {
	 try {
			begin();
			 Query updateQuery = getSession().createQuery("update Properties p set p.intrestedBuyerQuote = :intrestedBuyerQuote,p.propertyBuyercomments=:propertyBuyercomments,p.available=:available,p.propertyBuyerID=:propertyBuyerID,p.propertyBuyerName=:propertyBuyerName,p.propertyLastmodifiedDate=:propertyLastmodifiedDate where p.propertyId = :propertyId")
		             .setParameter("intrestedBuyerQuote", intrestedBuyerQuote)
		             .setParameter("propertyBuyercomments", propertyBuyercomments)
		             .setParameter("propertyId", propertyId)
		             .setParameter("propertyLastmodifiedDate", new Date())
		             .setParameter("propertyBuyerID", propertyBuyerID)
		             .setParameter("propertyBuyerName", propertyBuyerName)
		             .setParameter("available", "In Progress");
		              updateQuery.executeUpdate();
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new PropertyException("Could not update Properties information " + e);
		}	
	 finally {
     	close();
     }
	 
 }
 
 public void updatepropsellercomment(int propertyId, String propertySellercomments) throws PropertyException {
	 try {
			begin();
			 Query updateQuery = getSession().createQuery("update Properties p set p.propertySellercomments = :propertySellercomments,p.propertyLastmodifiedDate=:propertyLastmodifiedDate where p.propertyId = :propertyId")
		             .setParameter("propertySellercomments", propertySellercomments)
		             .setParameter("propertyLastmodifiedDate", new Date())
		             .setParameter("propertyId", propertyId);		            
		              updateQuery.executeUpdate();
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new PropertyException("Could not update Properties information " + e);
		}
	 finally {
     	close();
     }
	 
 }
 
 public void updatepropquoteapprove(int propertyId, String propertySellercomments) throws PropertyException {
	 try {
			begin();
			 Query updateQuery = getSession().createQuery("update Properties p set p.propertySellercomments = :propertySellercomments,p.available=:available,p.propertyLastmodifiedDate=:propertyLastmodifiedDate where p.propertyId = :propertyId")
		             .setParameter("propertySellercomments", propertySellercomments)
		             .setParameter("propertyId", propertyId)
		             .setParameter("propertyLastmodifiedDate", new Date())
		             .setParameter("available", "Sold");
		              updateQuery.executeUpdate();
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new PropertyException("Could not update Properties information " + e);
		}
	 finally {
     	close();
     }
	 
 }
 
 public void updatepropquotereject(int propertyId) throws PropertyException {
	 try {
			begin();
			 Query updateQuery = getSession().createQuery("update Properties p set p.intrestedBuyerQuote=:intrestedBuyerQuote,p.propertySellercomments = :propertySellercomments,p.available=:available,p.propertyBuyercomments=:propertyBuyercomments,p.propertyBuyerName=:propertyBuyerName,p.propertyBuyerID=:propertyBuyerID,p.propertyLastmodifiedDate=:propertyLastmodifiedDate where p.propertyId = :propertyId")
		             .setParameter("propertySellercomments", null)
		             .setParameter("propertyId", propertyId)
		             .setParameter("propertyBuyercomments", null)
		             .setParameter("propertyBuyerID", 0)
		             .setParameter("propertyBuyerName", null)
		             .setParameter("intrestedBuyerQuote", null)
		             .setParameter("available", "Available")
		             .setParameter("propertyLastmodifiedDate", new Date());
		             
		              updateQuery.executeUpdate();
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new PropertyException("Could not update Properties information " + e);
		}	
	 finally {
     	close();
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
	 finally {
     	close();
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
	 finally {
     	close();
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
	 finally {
     	close();
     }
 }
}
