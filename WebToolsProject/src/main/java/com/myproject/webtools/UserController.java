package com.myproject.webtools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myproject.webtools.dao.UserDAO;
import com.myproject.webtools.exception.UserException;
import com.myproject.webtools.pojo.User;
import com.myproject.webtools.validator.LoginValidator;
import com.myproject.webtools.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	UserValidator userValidator;
	@Autowired
	LoginValidator loginValidator;

	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/saveuser.htm", method = RequestMethod.POST)
	public String user(@ModelAttribute("user") User user, BindingResult result,UserDAO userdao,HttpServletResponse response) {
		
		userValidator.validate(user, result);
		if(result.hasErrors()){			
			return "signup";
		}
	    
	    userdao.createUser(user);
	    
	    return "login";
	    
	    
	}
	
	
	@RequestMapping(value = "/loginuser.htm", method = RequestMethod.POST)
	public String loginuser(@ModelAttribute("user") User user, BindingResult result,HttpSession session,UserDAO userdao,HttpServletRequest request,HttpServletResponse response) throws UserException {

		loginValidator.validate(user, result);
		if(result.hasErrors()){			
			return "login";
		}
//		System.out.print(user.getUserName());
//		System.out.print(user.getPassword());
	     User dbuser=userdao.getUser(user.getUserName(), user.getPassword());
	    // System.out.print(dbuser);
	     
	     
	     if(dbuser!=null) {
	    	session.setAttribute("dbuser", dbuser);		
	     if(dbuser.getRole().equalsIgnoreCase("Buyer"))
	 		return "buyer";
	 	    
	 	    if(dbuser.getRole().equalsIgnoreCase("Seller"))
	         return "seller";
	     }

		
		return "error";
		
	}
	
	@RequestMapping(value = "/loginuser/profile", method = RequestMethod.GET)
	public String viewprofile(@ModelAttribute("user") User user, BindingResult result,HttpSession session,UserDAO userdao,Model model) {
		User user1=(User) session.getAttribute("dbuser");
		model.addAttribute("user1",user1);
		return "profile";
	}

}
