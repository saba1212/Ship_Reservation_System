package com.cruds.srs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cruds.srs.entity.Route;
import com.cruds.srs.entity.Ship;
import com.cruds.srs.service.Routeservice;
import com.cruds.srs.service.Shipservice;

@Controller
public class RouteController {
	
	@Autowired
	private Routeservice  routeservice;
	
	
	@RequestMapping(value="/Routeaddition",method=RequestMethod.GET)
	public String showrouteform(Model model)
	{
		model.addAttribute("command", new Route());

		return "Routeaddition";
	}


	@RequestMapping(value="/Routeaddition",method=RequestMethod.POST)
	public String doRouteForm(@RequestParam("routeid") String routeid,
							@RequestParam("source") String source,
							@RequestParam("destination") String destination,
							@RequestParam("travelduration")String travelduration,
							@RequestParam("fare")int fare ,HttpServletRequest request)
	{
		
		Route Routebean=new Route(routeid, source, destination, travelduration, fare);
		System.out.println(Routebean);

	  if(source.equals(destination))
		{
			request.setAttribute("MESSAGE", "please change source or destination ");
			return "Routeaddition";

		}
	  else if(routeservice.addRoute(Routebean)!=null)

		{
			request.setAttribute("MESSAGE","Insertion Successful! ");

			return "Routeaddition";

		}

		else 
		{
			request.setAttribute("MESSAGE","Insertion Failed  duplicate key!!\n"+routeid+"\nalready there");
			return "Routeaddition";

		}

	}
	
	@RequestMapping(value="/Routelist",method=RequestMethod.GET)
	public String ViewRoutetable(Model model)
	{
		model.addAttribute("ROUTE_LIST",routeservice.viewByAllRoute());
		
		return "Routelist";
		
	}
	
//delete
	
	@RequestMapping(value="/Routedelete",method=RequestMethod.GET)
	public String showDeletepage(HttpServletRequest request,HttpSession session)
	{
		String routeid=request.getParameter("routeid");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String travelduration=request.getParameter("travelduration");
		String fare=request.getParameter("fare");
		
		
		session.setAttribute("routeid",routeid);
		session.setAttribute("source",source);
		session.setAttribute("destination",destination);
		session.setAttribute("travelduration",travelduration);
		session.setAttribute("fare",fare);
		
		
		return "Routedelete";
		
	}
	
	@RequestMapping(value="/Routedelete",method=RequestMethod.GET)
	public String dodeleteRoute(HttpSession session,HttpServletRequest request,Model model)
	{
		
		 String routeid=(String)session.getAttribute("Routeid");
		 System.out.println(routeid);
		
		
		if(routeservice.removeRoute(routeid)!=0)
		{
			request.setAttribute("MESSAGE", "succuessfully deleted");
			
			
			model.addAttribute("ROUTE_LIST",routeservice.viewByAllRoute());
			return "Routelist";
			
		}
		
		else
		{
			request.setAttribute("MESSAGE", "unsuccessfull delete its mapped with schedule");
			return "Routedelete";
			
		}
		
	}
	
	@RequestMapping(value="/RouteModify",method=RequestMethod.GET)
	public String showroutemodifyform( HttpServletRequest request,HttpSession session)
	{
		String routeid=request.getParameter("routeid");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String travelduration=request.getParameter("travelduration");
		String fare=request.getParameter("fare");
		
		
		session.setAttribute("routeid",routeid);
		session.setAttribute("source",source);
		session.setAttribute("destination",destination);
		session.setAttribute("travelduration",travelduration);
		session.setAttribute("fare",fare);
		
		return "Routemodify";
			
	}
	
	
	
	//modify
	
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

	@RequestMapping(value="/routemodify",method=RequestMethod.POST)
	public String domodifyship(HttpSession session,HttpServletRequest request,Model model, int fare)
	{

		String routeid=(String)session.getAttribute("routeid");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String travelduration=request.getParameter("travelduration");
		//String fare=request.getParameter("fare");


		Route routebean=new Route(routeid, source, destination, travelduration,fare);
		System.out.println(routebean);
		if(routeservice.modifyRoute(routebean))
		{
			request.setAttribute("MESSAGE","Details Updated Sucessfully!");
		
			model.addAttribute("SHIP_LIST",routeservice.viewByAllRoute());

			return "routelist";

		}
		else
		{
			request.setAttribute("MESSAGE","Updated Failed");
			return "redirect:routedify";

		}





	}
	
}


