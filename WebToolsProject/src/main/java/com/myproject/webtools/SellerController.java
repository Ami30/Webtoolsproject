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
import org.springframework.beans.factory.annotation.Autowired;
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
import com.myproject.webtools.validator.PropertyValidator;
import com.myproject.webtools.validator.UserValidator;

@Controller
public class SellerController {
	
	@Autowired
	PropertyValidator propValidator;

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);
	
	
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
		propValidator.validate(prop, result);
		if(result.hasErrors()){			
			return "newproperty";
		}
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
	
	@RequestMapping(value = "/loginuser/approveprice", method = RequestMethod.POST)
	public String approvepriceProperty(@ModelAttribute("properties") Properties prop, BindingResult result,HttpSession session,PropertyDAO propdao,HttpServletRequest request,HttpServletResponse response,Model model) throws PropertyException {
//		propValidator.validate(prop, result);
//		if(result.hasErrors()){			
//			return "newproperty";
//		}
		propdao.updatepropquoteapprove(prop.getPropertyId(), prop.getPropertySellercomments());
//		User user=(User) session.getAttribute("dbuser");
//		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getProperties(user.getUserId());
//		model.addAttribute("proparray", proparray);
//		return "addedproperties";
		User user=(User) session.getAttribute("dbuser");
		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getProperties(user.getUserId());
		model.addAttribute("proparray", proparray);
		return "successfull";
	}
	
	@RequestMapping(value = "/loginuser/rejectprice", method = RequestMethod.POST)
	public String rejectpriceProperty(@ModelAttribute("properties") Properties prop, BindingResult result,HttpSession session,PropertyDAO propdao,HttpServletRequest request,HttpServletResponse response,Model model) throws PropertyException {
//		propValidator.validate(prop, result);
//		if(result.hasErrors()){			
//			return "newproperty";
//		}
		propdao.updatepropquotereject(prop.getPropertyId());
//		User user=(User) session.getAttribute("dbuser");
//		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getProperties(user.getUserId());
//		model.addAttribute("proparray", proparray);
//		return "addedproperties";
		User user=(User) session.getAttribute("dbuser");
		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getProperties(user.getUserId());
		model.addAttribute("proparray", proparray);
		return "successfull";
	}
	
	@RequestMapping(value = "/loginuser/savecomments", method = RequestMethod.POST)
	public String savecomments(@ModelAttribute("properties") Properties prop, BindingResult result,HttpSession session,PropertyDAO propdao,HttpServletRequest request,HttpServletResponse response,Model model) throws PropertyException {
//		propValidator.validate(prop, result);
//		if(result.hasErrors()){			
//			return "newproperty";
//		}
		System.out.print("Controller" +prop.getPropertySellercomments());
		propdao.updatepropsellercomment(prop.getPropertyId(), prop.getPropertySellercomments());
//		User user=(User) session.getAttribute("dbuser");
//		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getProperties(user.getUserId());
//		model.addAttribute("proparray", proparray);
//		return "addedproperties";
		model.addAttribute("properties", prop);
		return "successfull";
	}
	
	@RequestMapping(value = "/update/{propertyId}")
	public String updateproperty(@PathVariable("propertyId")int pid,Model model,PropertyDAO propdao,BindingResult result) throws PropertyException {	
		Properties prop=propdao.getPropByID(pid);
		model.addAttribute("properties", prop);
		return "updateprop";
	}
	
	
	@RequestMapping(value = "/review/{propertyId}")
	public String reviewproperty(@ModelAttribute("properties") Properties prop,BindingResult result,@PathVariable("propertyId")int pid,Model model) throws PropertyException {	
		PropertyDAO propdao=new PropertyDAO();
		Properties prop1=propdao.getPropByID(pid);
	    System.out.println("prop"+prop.getPropertySellercomments());
	    System.out.println("prop1"+prop1.getPropertySellercomments());
		model.addAttribute("prop1", prop1);
		
		return "reviewprop";
	}

	
	
	
	
	

}
