package com.myproject.webtools.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myproject.webtools.pojo.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String regex2="^[0-9]{10}$";
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eMailID", "error.invalid.user", "Email ID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "error.invalid.user", "Phone number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.user", "Address Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "error.invalid.user", "Please select Role");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmpassword", "error.invalid.user", "Confirm Your Password");
		
        
        if(user.getPassword()!=null && user.getConfirmpassword()!=null) {
        	if(!(user.getPassword().equals(user.getConfirmpassword()))) {
        		errors.rejectValue("confirmpassword", "error.invalid.prop", "Password does not match");
        	}
        }
        if(user.geteMailID()!=null ||user.geteMailID()!=" ") {
        	if(!(user.geteMailID().matches(regex))) {
        		errors.rejectValue("eMailID", "error.invalid.prop", "Invalid email Address");
        	}
        }
        
        if(user.getContact()!=null) {
        	if(!(user.getContact().matches(regex2))) {
        		errors.rejectValue("contact", "error.invalid.prop", "Invalid contact number");
        	}
        }
	}

}
