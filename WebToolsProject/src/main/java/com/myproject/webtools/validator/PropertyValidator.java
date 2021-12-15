package com.myproject.webtools.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myproject.webtools.pojo.Properties;
import com.myproject.webtools.pojo.User;

public class PropertyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Properties.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Properties prop=(Properties) target;
		Pattern pattern1 = Pattern.compile("-?\\d+(\\.\\d+)?");
		//Pattern pattern2= Pattern.compile("^(?!.*[0-9])\/(painters|contractors)\/");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyName", "error.invalid.prop", "Property Name Required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyAddress", "error.invalid.prop", "Property Address Required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyCity", "error.invalid.prop", "Property City Required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyZipCode", "error.invalid.prop", "Property Zip Code Required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "available", "error.invalid.prop", "Property Availability Required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyAdditionalDetails", "error.invalid.prop", "Property Additonal Details Required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numrooms", "error.invalid.prop", "Rooms Required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numbathroom", "error.invalid.prop", "Restrooms Required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyPrice", "error.invalid.prop", "Property Price Required");
      
     
      if(prop.getPropertyZipCode()!=null) {
    	  
          if (!(prop.getPropertyZipCode().matches("[0-9]+") && prop.getPropertyZipCode().length() == 5)) {
        	  errors.rejectValue("propertyZipCode", "error.invalid.prop", "Invalid Zip code");
          }
      }
      
      if(prop.getNumbathroom()!=null) {
    	  if (!(prop.getNumbathroom().matches("[0-9]+"))) {
        	  errors.rejectValue("numbathroom", "error.invalid.prop", "Please enter numbers only");
          }
      }
      
      if(prop.getNumrooms()!=null) {
    	  if (!(prop.getNumrooms().matches("[0-9]+"))) {
        	  errors.rejectValue("numrooms", "error.invalid.prop", "Please enter numbers only");
          }
      }
      
      if(prop.getPropertyPrice()!=null) {
    	  if(!(pattern1.matcher(prop.getPropertyPrice()).matches())) {
    		  errors.rejectValue("propertyPrice", "error.invalid.prop", "Please enter valid price");
    	  }
      }
      
	}

}
