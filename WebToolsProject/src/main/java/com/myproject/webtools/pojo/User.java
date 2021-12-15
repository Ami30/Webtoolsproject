/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.webtools.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="User")
public class User {
    
        @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="userId",unique=true,nullable=false)
	private int userId;
        
        @Column(name="firstName")
	private String fName;
	
	@Column(name="Role")
	private String role;

	@Column(name="lastName")
	private String lName;
	
	@Column(name="emailId")
	private String eMailID;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="address")
	private String address;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="passWord")
	private String password;
	
	@Column(name="date")
	private Date date;
	
	@Transient
    private String confirmpassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    
    public User()
	{
		
	}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String geteMailID() {
        return eMailID;
    }

    public void seteMailID(String eMailID) {
        this.eMailID = eMailID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
        
	
}
