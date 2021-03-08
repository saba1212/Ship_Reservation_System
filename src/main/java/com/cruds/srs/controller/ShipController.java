package com.cruds.srs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.cruds.srs.entity.Ship;
import com.cruds.srs.service.Shipservice;

@Controller
public class ShipController {
	
	@Autowired
	private Shipservice  shipservice;
	

	@RequestMapping(value="/Ship",method=RequestMethod.GET)
	public String showshipform(Model model)
	{
		model.addAttribute("command", new Ship());
		
		return "ship";

	}

	@RequestMapping(value="/ship",method=RequestMethod.POST)
	public String doShip(@RequestParam("shipid") String shipid,
						 @RequestParam("shipname")String shipname,
						 @RequestParam("seatingcapacity") int seatingcapacity,
						 @RequestParam("reservationcapacity") int reservationcapacity)
			
{
		Ship shipBean=new Ship(shipid, shipname, seatingcapacity, reservationcapacity);
		System.out.println(shipBean);
		
		System.out.println(shipBean);
		if(shipservice.addship(shipBean)!=null)
		{
			
			
			return "success";
		}
		
		return "ship";
  }
	
	
	
	//ship details after adding (list)
	
		@RequestMapping(value="/Shiplist",method=RequestMethod.GET)
		public String viewByAllShips(Model model)
		{
			model.addAttribute ("SHIP_LIST", shipservice.viewByAllShips());
			
			return "shiplist";
			
			
		}
		

	//Ship Delete 
		@RequestMapping(value="/shipdelete",method=RequestMethod.GET)
		public String showshipdeleteform( HttpServletRequest request,HttpSession session)
		{

			

			String shipid=request.getParameter("shipid");
			String shipname=request.getParameter("shipname");
			String seatingcapacity=request.getParameter("seatingcapacity");
			String reservationcapacity=request.getParameter("reservationcapacity");

			session.setAttribute("shipid",shipid);
			session.setAttribute("shipname",shipname);
			session.setAttribute("seatingcapacity",seatingcapacity);
			session.setAttribute("reservationcapacity",reservationcapacity);


			
			return "shipdelete";
		}
		
		
		@RequestMapping(value="/shipdeletedo",method=RequestMethod.GET)
		public String getshipDeleteform( HttpServletRequest request,HttpSession session,Model model)
		{

			String shipid=(String)session.getAttribute("shipid");
			System.out.println(shipid);


			if(shipservice.removeShip(shipid)!=0)
			{
				request.setAttribute("MESSAGE", "succuessfully deleted");
				

				//session.invalidate();

				model.addAttribute("SHIP_LIST",shipservice.viewByAllShips());
				return "redirect:Shiplist";
			}

			else
			{
				request.setAttribute("MESSAGE", "unsuccessfull");
				return "shipdelete";
			}

			}




		
	//Ship Modify
		
		@RequestMapping(value="/shipmodify",method=RequestMethod.GET)
		public String getModifyform(HttpServletRequest request,HttpSession session)
		{

			String shipid=request.getParameter("shipid");
			String shipname=request.getParameter("shipname");
			String seatingcapacity=request.getParameter("seatingcapacity");
			String reservationcapacity=request.getParameter("reservationcapacity");

			session.setAttribute("shipid",shipid);
			session.setAttribute("shipname",shipname);
			session.setAttribute("seatingcapacity",seatingcapacity);
			session.setAttribute("reservationcapacity",reservationcapacity);


			return "shipmodify";


		}

		@RequestMapping(value="/shipmodify",method=RequestMethod.POST)
		public String domodifyship(HttpSession session,HttpServletRequest request,Model model)
		{

			String shipid=(String)session.getAttribute("shipid");
			String shipname=request.getParameter("shipname");
			String seatingcapacity=request.getParameter("seatingcapacity");
			String reservationcapacity=request.getParameter("reservationcapacity");



			Ship shipbean=new Ship(shipid, shipname, Integer.valueOf(seatingcapacity), Integer.valueOf(reservationcapacity));
			System.out.println(shipbean);
			if(shipservice.modifyShip(shipbean))
			{
				request.setAttribute("MESSAGE","Details Updated Sucessfully!");
			
				model.addAttribute("SHIP_LIST",shipservice.viewByAllShips());

				return "shiplist";

			}
			else
			{
				request.setAttribute("MESSAGE","Updated Failed");
				return "redirect:shipmodify";

			}





		}

		
	
}
