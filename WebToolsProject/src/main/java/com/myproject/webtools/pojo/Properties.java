package com.myproject.webtools.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author amishagupta
 */
@Entity
@Table(name = "Properties")
public class Properties {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "propertyId", unique = true, nullable = false)
	private int propertyId;

	@Column(name = "propertyName", unique = true, nullable = false)
	private String propertyName;

	@Column(name = "propertyAddress")
	private String propertyAddress;
	
	@Column(name = "propertyCity")
	private String propertyCity;

	@Column(name = "propertyZipCode")
	private String propertyZipCode;

	@Column(name = "propertyListingDate")
	private Date propertyListingDate;
	

	@Column(name = "propertyLastmodifiedDate")
	private Date propertyLastmodifiedDate;

	@Column(name = "available")
	private String available;

	@Column(name = "propertyOwner")
	private String propertyOwner;

	@Column(name = "intrestedBuyer")
	private String intrestedBuyer;

	@Column(name = "intrestedBuyerQuote")
	private String intrestedBuyerQuote;

	@Column(name = "approveSale")
	private String approveSale;
	
	@Column(name = "propertyBuyerID")
	private int propertyBuyerID;
	
	@Column(name = "propertySellerID")
	private int propertySellerID;
	
//	@Fetch(FetchMode.EAGER)
	@Column(name = "propertySellercomments")
	private String propertySellercomments;
	
	@Column(name = "propertyBuyercomments")
	private String propertyBuyercomments;


	
	@Column(name = "propertyAdditionalDetails")
	private String propertyAdditionalDetails;
	
	@Column(name = "propertyBuyerName")
	private String propertyBuyerName;

	@Column(name = "numrooms")
	private String numrooms;

	@Column(name = "numbathroom")
	private String numbathroom;

	@Column(name = "propertyPrice")
	private String propertyPrice;
	
	public Properties() {
		
	}
	
	public String getIntrestedBuyer() {
		return intrestedBuyer;
	}

	public void setIntrestedBuyer(String intrestedBuyer) {
		this.intrestedBuyer = intrestedBuyer;
	}

	public String getIntrestedBuyerQuote() {
		return intrestedBuyerQuote;
	}

	public void setIntrestedBuyerQuote(String intrestedBuyerQuote) {
		this.intrestedBuyerQuote = intrestedBuyerQuote;
	}

	public String getApproveSale() {
		return approveSale;
	}

	public void setApproveSale(String approveSale) {
		this.approveSale = approveSale;
	}

	public int getPropertyBuyerID() {
		return propertyBuyerID;
	}

	public void setPropertyBuyerID(int propertyBuyerID) {
		this.propertyBuyerID = propertyBuyerID;
	}

	public int getPropertySellerID() {
		return propertySellerID;
	}

	public void setPropertySellerID(int propertySellerID) {
		this.propertySellerID = propertySellerID;
	}
	

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyZipCode() {
		return propertyZipCode;
	}

	public void setPropertyZipCode(String propertyZipCode) {
		this.propertyZipCode = propertyZipCode;
	}

	public Date getPropertyListingDate() {
		return propertyListingDate;
	}

	public void setPropertyListingDate(Date propertyListingDate) {
		this.propertyListingDate = propertyListingDate;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getPropertyOwner() {
		return propertyOwner;
	}

	public void setPropertyOwner(String propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public String getPropertyBuyerName() {
		return propertyBuyerName;
	}

	public void setPropertyBuyerName(String propertyBuyerName) {
		this.propertyBuyerName = propertyBuyerName;
	}

	public String getNumrooms() {
		return numrooms;
	}
	
	public Date getPropertyLastmodifiedDate() {
		return propertyLastmodifiedDate;
	}

	public void setPropertyLastmodifiedDate(Date propertyLastmodifiedDate) {
		this.propertyLastmodifiedDate = propertyLastmodifiedDate;
	}

	public void setNumrooms(String numrooms) {
		this.numrooms = numrooms;
	}

	public String getNumbathroom() {
		return numbathroom;
	}

	public void setNumbathroom(String numbathroom) {
		this.numbathroom = numbathroom;
	}

	public String getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(String propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public String getPropertyAdditionalDetails() {
		return propertyAdditionalDetails;
	}

	public String getPropertyCity() {
		return propertyCity;
	}

	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}

	public void setPropertyAdditionalDetails(String propertyAdditionalDetails) {
		this.propertyAdditionalDetails = propertyAdditionalDetails;
	}

	public String getPropertySellercomments() {
		return propertySellercomments;
	}

	public void setPropertySellercomments(String propertySellercomments) {
		this.propertySellercomments = propertySellercomments;
	}

	public String getPropertyBuyercomments() {
		return propertyBuyercomments;
	}

	public void setPropertyBuyercomments(String propertyBuyercomments) {
		this.propertyBuyercomments = propertyBuyercomments;
	}
	
	

}