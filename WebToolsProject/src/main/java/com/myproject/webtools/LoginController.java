package com.myproject.webtools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.webtools.dao.UserDAO;
import com.myproject.webtools.pojo.User;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,UserDAO userdao) {
		
		model.addAttribute("user",new User());
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String signup(Model model,UserDAO userdao) {
		model.addAttribute("user",new User());
		
		return "signup";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
	    return "redirect:/"; 
	}
}
