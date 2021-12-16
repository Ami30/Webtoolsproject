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

import com.myproject.webtools.dao.PropertyDAO;
import com.myproject.webtools.dao.UserDAO;
import com.myproject.webtools.exception.UserException;
import com.myproject.webtools.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UserException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws UserException {
		logger.info("Welcome to Real estate application! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		User user=new User();
		UserDAO userdao=new UserDAO();
		if(userdao.getallusers()==null) {
		user.setfName("Amisha");
		user.setlName("Gupta");
		user.setAddress("75 Saint Alphonsus Street");
		user.setContact("8572989423");
		user.setUserName("admin");
		user.setPassword("admin");
		user.seteMailID("amishagupta1930@gmail.com");
		user.setRole("Admin");
		user.setDate(new Date());
		
		userdao.createUser(user);
		}
		
		return "home";
	}
	
}
