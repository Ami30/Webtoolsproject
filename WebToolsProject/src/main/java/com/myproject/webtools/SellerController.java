package com.myproject.webtools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.webtools.dao.PropertyDAO;
import com.myproject.webtools.dao.UserDAO;
import com.myproject.webtools.exception.PropertyException;
import com.myproject.webtools.pojo.Properties;
import com.myproject.webtools.pojo.User;

@Controller
public class SellerController {

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);
	@RequestMapping(value = "/loginuser/profile", method = RequestMethod.GET)
	public String viewprofile(Model model,UserDAO userdao) {
		
		return "profile";
	}
	
	@RequestMapping(value = "/loginuser/newproperty", method = RequestMethod.GET)
	public String addproperty(Model model) {
		model.addAttribute("properties",new Properties());
		return "newproperty";
	}
	
	
	@RequestMapping(value = "/loginuser/addedproperties", method = RequestMethod.GET)
	public String addedproperty(Model model,PropertyDAO propdao,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws PropertyException {
		User user=(User) session.getAttribute("dbuser");
		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getProperties(user.getUserId());
		model.addAttribute("proparray", proparray);
		return "addedproperties";
	}
	
	@RequestMapping(value = "/loginuser/soldproperties", method = RequestMethod.GET)
	public String soldproperty(Model model) {	
		return "soldproperties";
	}
	
	@RequestMapping(value = "/loginuser/newproperty/saveproperty", method = RequestMethod.POST)
	public String saveProperty(@ModelAttribute("properties") Properties prop, BindingResult result,HttpSession session,PropertyDAO propdao,HttpServletRequest request,HttpServletResponse response,Model model) throws PropertyException {
		
		prop.setApproveSale("No");
		User user=(User) session.getAttribute("dbuser");
		prop.setPropertyOwner(user.getfName()+" "+ user.getlName());
		prop.setPropertySellerID(user.getUserId());
		prop.setPropertyListingDate(new Date());
		prop.setPropertyLastmodifiedDate(new Date());
		propdao.createProperty(prop);
		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getProperties(user.getUserId());
		model.addAttribute("proparray", proparray);
		return "addedproperties";
	}
	
	@RequestMapping(value = "/update/{productId}")
	public String soldproperty(@PathVariable("productId")int pid,Model model,PropertyDAO propdao,BindingResult result) throws PropertyException {	
		Properties prop=propdao.getPropByID(pid);
		model.addAttribute("properties", prop);
		return "updateprop";
	}
	

	
	
	
	
	

}
