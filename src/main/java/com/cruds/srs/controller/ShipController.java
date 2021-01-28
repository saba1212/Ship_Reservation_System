package com.cruds.srs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.srs.db.ShipDAOImpl;
import com.cruds.srs.entity.Ship;
import com.cruds.srs.service.Shipservice;

public class ShipController {
	@Autowired
	Shipservice service;
	private String shipid;


	@RequestMapping(value="/ship",method=RequestMethod.GET)
	public String showshipform(Model model)
	{
		model.addAttribute("command", new Ship());
		return "ship";

	}

	@RequestMapping(value="/ship",method=RequestMethod.POST)
	public String doShip( @RequestParam("shipid") String shipid,@RequestParam("shipname") String shipname
			,@RequestParam("seatingcapacity")int seatingcapacity,@RequestParam("reservationcapacity") int reservationcapacity,
			HttpServletRequest request,RedirectAttributes redirectattribute)
	{
		Ship shipBean=new Ship(shipid, shipname, seatingcapacity, reservationcapacity);


		System.out.println(shipBean); 
		
		if( shipBean!=null&&service.addship(shipBean)!=null)
		{	
			request.setAttribute("MESSAGE","Inseration Success");
			redirectattribute.addFlashAttribute("MESSAGE","Inseration Success");
			return "redirect:ship";

		}
		else
		{
			request.setAttribute("MESSAGE","Inseration Failed");
			return "ship";
		}
		}
	
	
		

	@RequestMapping(value="/shiplist",method=RequestMethod.GET)
	public String viewallships(Model model)
	{
		model.addAttribute("SHIP_LIST",service.viewByAllships());

		
		return "shiplist";

	}

	
	
	
	@RequestMapping(value="/shipdelete",method=RequestMethod.GET)
	public String showshipdeleteform( HttpServletRequest request,HttpSession session)
	{
		
		
		String shipid=request.getParameter("shipid");
		String shipname=request.getParameter("shipname");
		String seatingcapacity=request.getParameter("seatingcapacity");
		String reservationcapacity=request.getParameter("reservationcapacity");
		
		session.setAttribute("shipid",shipid);
		session.setAttribute("shipname",shipname);
		session.setAttribute("seatingcapacity",Integer.valueOf(seatingcapacity));
		session.setAttribute("reservationcapacity",Integer.valueOf(reservationcapacity));
			
		return "shipdelete";

	} 
	
	
	
	@RequestMapping(value="/shipdelete",method=RequestMethod.GET)
	public String getshipDeleteform( 
			HttpServletRequest request,HttpSession session)
	{
		
		 String shipid=(String)session.getAttribute("shipid");
		 System.out.println(shipid);
		
		
		if(service.removeShip(shipid)!=0)
		{
			request.setAttribute("MESSAGE", "succuessfully deleted");
	
			
			session.invalidate();
			return "shipdelete";
		}
		
		else
		{
			request.setAttribute("MESSAGE", "unsuccessfull delete");
			return "shipdelete";
			
		}
	
	}
	


	@RequestMapping(value="/shipmodify",method=RequestMethod.GET)
	public String getModifyform(HttpServletRequest request,HttpSession session)
	{
		
		String shipid=request.getParameter("flightid");
		String shipname=request.getParameter("flightname");
		String seatingcapacity=request.getParameter("seatingcapacity");
		String reservationcapacity=request.getParameter("reservationcapacity");
		
		session.setAttribute("shipid",shipid);
		session.setAttribute("shipname",shipname);
		session.setAttribute("seatingcapacity",seatingcapacity);
		session.setAttribute("reservationcapacity",reservationcapacity);
	

		return "shipmodify";

 
	}
	
	@RequestMapping(value="/shipmodify",method=RequestMethod.POST)
	public String domodifyship(HttpSession session,HttpServletRequest request)
	{
		
		 String shipid=(String)session.getAttribute("shipid");
		 String shipname=request.getParameter("shipname");
		 String seatingcapacity=request.getParameter("seatingcapacity");
		 String reservationcapacity=request.getParameter("reservationcapacity");
		 
		 Ship shipbean=new Ship(shipid, shipname, Integer.valueOf(seatingcapacity),  Integer.valueOf(reservationcapacity));
		 System.out.println(shipbean);
		if(service.modifyShip(shipbean))
		{
			session.setAttribute("MESSAGE","Updated Success");
			//session.invalidate();
			return "redirect:shiplist";
			
		}
		else
		{
			request.setAttribute("MESSAGE","Updated Failed");
			return "redirect:shipmodify";
			
		}
	
		
		
		
		
	}


}
