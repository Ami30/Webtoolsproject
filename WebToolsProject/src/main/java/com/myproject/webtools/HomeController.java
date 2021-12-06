package com.myproject.webtools;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.webtools.dao.UserDAO;
import com.myproject.webtools.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome to Real estate application! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	public String user(Model model,UserDAO userdao) {
//		
//		User user=new User();
//	    user.setAddress("75 Saint alphonsus");
//	    user.setContact("8577876655");
//	    user.setUserName("user");
//	    userdao.createUser(user);
//		return "user";
//	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(Model model,UserDAO userdao) {
//		
//		
//		return "login";
//	}
//	
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public String signup(Model model,UserDAO userdao) {
//		
//		
//		return "signup";
//	}
	
}