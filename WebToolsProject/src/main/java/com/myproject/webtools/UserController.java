package com.myproject.webtools;

import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myproject.webtools.dao.PropertyDAO;
import com.myproject.webtools.dao.UserDAO;
import com.myproject.webtools.exception.PropertyException;
import com.myproject.webtools.exception.UserException;
import com.myproject.webtools.pojo.Properties;
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
	
	@RequestMapping(value = "/loginuser/adduser")
	public String saveuseradmin(@ModelAttribute("user") User user, BindingResult result,UserDAO userdao,HttpServletResponse response) {
		
		userValidator.validate(user, result);
		if(result.hasErrors()){			
			return "signup";
		}
	    
	    userdao.createUser(user);
	    
	    return "addsuccessfull";    
	    
	}
	
	@RequestMapping(value = "/loginuser/addnewuser")
	public String addnewuseradmin(@ModelAttribute("user") User user, BindingResult result,HttpSession session,Model model,UserDAO userdao,HttpServletResponse response) {
		User user1=(User) session.getAttribute("dbuser");
		model.addAttribute("user1",user1);
	    return "signup";    
	    
	}
	
	@RequestMapping(value = "/loginuser/searchuserresult" ,method = RequestMethod.POST)
	public String searchuseradminresult(UserDAO userdao,HttpServletResponse response,HttpServletRequest request,Model model) throws UserException {
		
	    String keyword=request.getParameter("keyword");
	    String param=request.getParameter("searchuser");
	    if(param.equals("role")) {
	    	ArrayList<User> userarray=(ArrayList<User>) userdao.getUsersbyrole(keyword);
			model.addAttribute("userarray", userarray);
			return "allusers";
	    }
	    else if(param.equals("fName")) {
	    	ArrayList<User> userarray=(ArrayList<User>) userdao.getUsersbyfname(keyword);
			model.addAttribute("userarray", userarray);
			return "allusers";
	    }
        else if(param.equals("lName")) {
        	ArrayList<User> userarray=(ArrayList<User>) userdao.getUsersbylname(keyword);
			model.addAttribute("userarray", userarray);
			return "allusers";
	    }     
	    return "searchuser";    
	    
	}
	
	@RequestMapping(value = "/loginuser/searchuser")
	public String searchuseradmin(HttpServletRequest request,Model model) throws UserException {
		
	  return "searchuser";
	    
	}
	
	@RequestMapping(value = "/loginuser/viewalluser", method = RequestMethod.POST)
	public String viewalluseradmin(UserDAO userdao,HttpServletResponse response,HttpServletResponse request,Model model) throws UserException {
			    
		ArrayList<User> userarray=(ArrayList<User>) userdao.getallusers();
		model.addAttribute("userarray", userarray);
		return "allusers";   
	    
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
	 	    
	 	   if(dbuser.getRole().equalsIgnoreCase("Admin"))
		         return "admin";
	 	    
	     }

		
		return "error";
		
	}
	
	@RequestMapping(value = "/loginuser/profile", method = RequestMethod.GET)
	public String viewprofile(@ModelAttribute("user") User user, BindingResult result,HttpSession session,UserDAO userdao,Model model) {
		User user1=(User) session.getAttribute("dbuser");
		model.addAttribute("user1",user1);
		return "profile";
	}
	
	@RequestMapping(value = "/updateuser/{userId}")
	public String updateuseradmin(@PathVariable("userId")int uid,Model model,UserDAO userdao,BindingResult result) throws UserException {	
		User user1=userdao.getUser(uid);
		model.addAttribute("user1", user1);
		return "updateuserview";
	}

	@RequestMapping(value = "/updateuser.htm", method = RequestMethod.POST)
	public String updateuser(@ModelAttribute("user") User user, BindingResult result,UserDAO userdao,HttpServletResponse response) {
		
		userValidator.validate(user, result);
		if(result.hasErrors()){			
			return "signup";
		}
	    
	    userdao.createUser(user);
	    
	    return "allusers";
	    
	    
	}
}
