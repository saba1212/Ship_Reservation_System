package com.cruds.srs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cruds.srs.entity.Credentials;
import com.cruds.srs.service.Credentialsservice;

@Controller
public class CredentialsController {
	
	@Autowired
	Credentialsservice credentialsservice;
	
	
	//Form
	@RequestMapping(value="/First",method=RequestMethod.GET)
	public String showloginform(Model model)
	{
		model.addAttribute("command", new Credentials());
		return "first";
		
	}


	@RequestMapping(value="/first",method=RequestMethod.POST)
	public String doAdminloginform(@RequestParam("password")String password,
									@RequestParam("usertype")String usertype,HttpSession session,HttpServletRequest request)
	{
		int loginstatus=1;
		

		Credentials credentialsBean=new Credentials(usertype, password,usertype, loginstatus);
		System.out.println(credentialsBean);

		if(credentialsservice.login(credentialsBean)!=null&&usertype.equals("Admin"))
		{
			
			session.setAttribute("MESSAGE","hi :)"+email);
				return "adminpage";

		}
		else if(credentialsservice.login(credentialsBean)!=null&&usertype.equals("Customer"))
		{
			session.setAttribute("MESSAGE","hi :)"+email);
			return "CustomerSearch";

			
		}
		else
		{
			request.setAttribute("MESSAGE","Invalid username or password or user type");
			return "first";

		}
	}
		
	@RequestMapping(value="/Register",method=RequestMethod.GET)
	public String showregisterform()
	{
		
		return "register";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String doregisterform(@RequestParam("fname") String firstname,@RequestParam("lname") String lastname,@RequestParam("DOB") String DOB,@RequestParam("gender")
	String gender,@RequestParam("phone")String phone,@RequestParam("Street")String street,@RequestParam("Location")String location,@RequestParam("City")String city,@RequestParam("State")String state,
	@RequestParam("Pincode")String pincode,@RequestParam("email")String email,@RequestParam("password")String password,HttpServletRequest request)
	{
		/*
		Profile profilebean=new Profile(firstname, lastname, Date.valueOf(DOB), gender, street, location, city, state, pincode, phone, email, password);
		
		System.out.println(profilebean);
		
	if(service.Customeradd(profilebean)){
		
		
		request.setAttribute("MESSAGE", "Successfull insert");
		return "first";
	}
	else
	{
		request.setAttribute("MESSAGE", "Failed");
		return "register";
	}*/
		
		System.out.println(firstname);
		System.out.println(DOB);
		return "first";
		
		
		
	
		
	}

}
