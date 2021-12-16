package com.myproject.webtools;

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
public class BuyerController {
	private static final Logger logger = LoggerFactory.getLogger(BuyerController.class);
//	@RequestMapping(value = "/loginuser/profile", method = RequestMethod.GET)
//	public String viewprofile(Model model,UserDAO userdao) {
//		
//		return "profile";
//	}
	

	
	@RequestMapping(value = "/loginuser/browseproperties", method = RequestMethod.GET)
	public String addedproperty(Model model,PropertyDAO propdao,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws PropertyException {
		User user=(User) session.getAttribute("dbuser");
		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getallProperties();
		model.addAttribute("proparray", proparray);
		model.addAttribute("user", user);
		return "buyerbrowseprop";
	}
	
	@RequestMapping(value = "/loginuser/searchpropertiesbuyer", method = RequestMethod.GET)
	public String soldproperty(Model model) {	
		return "soldproperties";
	}
	
	@RequestMapping(value = "/loginuser/browseprop/sendquotedamount", method = RequestMethod.POST)
	public String updateProperty(@ModelAttribute("properties") Properties prop, BindingResult result,HttpSession session,PropertyDAO propdao,HttpServletRequest request,HttpServletResponse response,Model model) throws PropertyException {
//		propValidator.validate(prop, result);
//		if(result.hasErrors()){			
//			return "newproperty";
//		}
		User user=(User) session.getAttribute("dbuser");
		String fullname=user.getfName()+ " " +user.getlName();
		propdao.updatepropquotebyID(prop.getPropertyId(),user.getUserId(), prop.getIntrestedBuyerQuote(), prop.getPropertyBuyercomments(),fullname);
		ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getallProperties();
		model.addAttribute("proparray", proparray);
		return "buyerbrowseprop";
	}
	
	@RequestMapping(value = "/view/{propertyId}")
	public String viewproperty(@PathVariable("propertyId")int pid,Model model,PropertyDAO propdao,BindingResult result) throws PropertyException {	
		Properties prop=propdao.getPropByID(pid);
		model.addAttribute("properties", prop);
		return "viewproperty";
	}
	
	@RequestMapping(value = "/buy/{propertyId}")
	public String buyproperty(@PathVariable("propertyId")int pid,Model model,PropertyDAO propdao,BindingResult result) throws PropertyException {	
		Properties prop=propdao.getPropByID(pid);
		model.addAttribute("properties", prop);
		System.out.println(prop.getPropertySellercomments());
		return "quoteprice";
	}
	
	
	@RequestMapping(value = "/loginuser/submitsearchpropertiesbuyer", method = RequestMethod.POST)
	public String submitsearchproperty(Model model,PropertyDAO propdao,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws PropertyException {
		String p1=request.getParameter("keyword");
		String p2=request.getParameter("searchproperty");
		if(p2.equals("available")) {
			ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getPropertiessearchavailable(p1);
			model.addAttribute("proparray", proparray);
			return "buyerbrowseprop";
			
		}
		else if(p2.equals("propertyCity")) {
			ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getPropertiessearchCity(p1);
			model.addAttribute("proparray", proparray);
			return "buyerbrowseprop";
			
		}
		else if(p2.equals("propertyZipCode")) {
			ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getPropertiessearchZipCode(p1);
			model.addAttribute("proparray", proparray);
			return "buyerbrowseprop";
		}
		else if(p2.equals("propertyOwner")) {
			ArrayList<Properties> proparray=(ArrayList<Properties>) propdao.getPropertiessearchPropOwner(p1);
			model.addAttribute("proparray", proparray);	
			return "buyerbrowseprop";
		}
		
		return "searchproperties";
	}
	
	
	
}
