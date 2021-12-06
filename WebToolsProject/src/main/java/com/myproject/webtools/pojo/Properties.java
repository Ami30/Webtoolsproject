package com.myproject.webtools.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author amishagupta
 */
@Entity
@Table(name="Properties")
public class Properties {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="propertyId",unique=true,nullable=false)
	private long propertyId;
        
    @Column(name="propertyAddress")
	private String propertyAddress;
	
	@Column(name="propertyZipCode")
	private String propertyZipCode;
        
        @Column(name="propertyListingDate")
	private String propertyListingDate;
        
        @Column(name="available")
	private String available;
        
        @Column(name="propertyOwner")
	private String propertyOwner;
        
        @Column(name="propertyBuyer")
	private String propertyBuyer;
        
        @Column(name="numrooms")
	private int numrooms;
        
        @Column(name="numbathroom")
	private int numbathroom;
        
        @Column(name="propertyPrice")
	private float propertyPrice;

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyZipCode() {
        return propertyZipCode;
    }

    public void setPropertyZipCode(String propertyZipCode) {
        this.propertyZipCode = propertyZipCode;
    }

    public String getPropertyListingDate() {
        return propertyListingDate;
    }

    public void setPropertyListingDate(String propertyListingDate) {
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

    public String getPropertyBuyer() {
        return propertyBuyer;
    }

    public void setPropertyBuyer(String propertyBuyer) {
        this.propertyBuyer = propertyBuyer;
    }

    public int getNumrooms() {
        return numrooms;
    }

    public void setNumrooms(int numrooms) {
        this.numrooms = numrooms;
    }

    public int getNumbathroom() {
        return numbathroom;
    }

    public void setNumbathroom(int numbathroom) {
        this.numbathroom = numbathroom;
    }

    public float getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(float propertyPrice) {
        this.propertyPrice = propertyPrice;
    }
        
        
        
}