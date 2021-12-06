package com.myproject.webtools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.webtools.dao.UserDAO;
import com.myproject.webtools.exception.UserException;
import com.myproject.webtools.pojo.User;
import com.myproject.webtools.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	UserValidator userValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/saveuser.htm", method = RequestMethod.POST)
	public String user(@ModelAttribute("user") User user, BindingResult result,UserDAO userdao,HttpServletResponse response) {
		
//		String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String emailId = request.getParameter("emailId");
//        String contact = request.getParameter("contact");
//        String address = request.getParameter("address");        
//        String role = request.getParameter("role");
//        String username = request.getParameter("username");
//        String pwd = request.getParameter("pwd");
		
//		User user=new User();
//		
//	    user.setfName(firstName);
//	    user.setlName(lastName);
//	    user.seteMailID(emailId);
//	    user.setContact(contact);
//	    user.setAddress(address);
//	    user.setRole(role);
//	    user.setUserName(username);
//	    user.setPassword(pwd);
		userValidator.validate(user, result);
		if(result.hasErrors()){			
			return "signup";
		}
	    
	    userdao.createUser(user);
	    
	    if(user.getRole().equalsIgnoreCase("Buyer"))
		return "buyer";
	    
	    if(user.getRole().equalsIgnoreCase("Seller"))
        return "seller";
	    
	    return "error";
	    
	}
	
	@RequestMapping(value = "/loginuser.htm", method = RequestMethod.POST)
	public String loginuser(@ModelAttribute("user") User user, BindingResult result,UserDAO userdao,HttpServletRequest request,HttpServletResponse response) throws UserException {
		
//		 String username = request.getParameter("username");
//	     String pwd = request.getParameter("pwd");
		userValidator.validate(user, result);
		if(result.hasErrors()){			
			return "login";
		}
	     
	     User dbuser=userdao.getUser(user.getUserName(), user.getPassword());
		
	     if(dbuser.getRole().equalsIgnoreCase("Buyer"))
	 		return "buyer";
	 	    
	 	    if(dbuser.getRole().equalsIgnoreCase("Seller"))
	         return "seller";
	     
		
		
		return "error";
		
	}

}
