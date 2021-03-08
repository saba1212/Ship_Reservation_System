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

@Controller
public class RouteController {
	
	@Autowired
	Routeservice routeservice;


//form
	@RequestMapping(value="/Route",method=RequestMethod.GET)
	public String showrouteform(Model model)
	{
	model.addAttribute("command", new Route());
	
	return "route";

	}

	@RequestMapping(value="/route",method=RequestMethod.POST)
	public String doRoute(@RequestParam("routeid") String routeid,
					 @RequestParam("source")String source,
					 @RequestParam("destination")String destination,
					 @RequestParam("travelduration") String travelduration,
					 @RequestParam("fare") String fare)
		
{
	Route routeBean=new Route(routeid, source, destination, travelduration, fare);
	
	System.out.println(routeBean);
	
	if(routeservice.addRoute(routeBean)!=null)
	{
		
		
		return "success";
	}
	
	return "route";
}




//route details after adding (list)

	@RequestMapping(value="/Routelist",method=RequestMethod.GET)
	public String viewByAllRoute(Model model)
	{
		model.addAttribute ("ROUTE_LIST", routeservice.viewByAllRoute());
		
		return "routelist";
		
		
	}
		
		
//route Delete 
		@RequestMapping(value="/routedelete",method=RequestMethod.GET)
		public String showroutedeleteform( HttpServletRequest request,HttpSession session)
		{

			

			String routeid=request.getParameter("routeid");
			String source=request.getParameter("source");
			String destination=request.getParameter("destination");
			String travelduration=request.getParameter("travelduration");
			String fare=request.getParameter("fare");

			session.setAttribute("routeid",routeid);
			session.setAttribute("source", source);
			session.setAttribute("destination",destination);
			session.setAttribute("travelduration",travelduration);
			session.setAttribute("fare",fare);


			
			return "routedelete";
		}
		
		
		@RequestMapping(value="/routedeletedo",method=RequestMethod.GET)
		public String getrouteDeleteform( HttpServletRequest request,HttpSession session,Model model)
		{

			String routeid=(String)session.getAttribute("routeid");
			System.out.println(routeid);


			if(routeservice.removeRoute(routeid)!=0)
			{
				request.setAttribute("MESSAGE", "succuessfully deleted!");
				model.addAttribute("ROUTE_LIST",routeservice.viewByAllRoute());
				return "redirect:Routelist";
			}

			else
			{
				request.setAttribute("MESSAGE", "unsuccessfull");
				return "routedelete";
			}

			}


//route Modify
		
		@RequestMapping(value="/routemodify",method=RequestMethod.GET)
		public String getModifyform(HttpServletRequest request,HttpSession session)
		{

			String routeid=request.getParameter("routeid");
			String source=request.getParameter("source");
			String destination=request.getParameter("destination");
			String travelduration=request.getParameter("travelduration");
			String fare=request.getParameter("fare");

			session.setAttribute("routeid",routeid);
			session.setAttribute("source", source);
			session.setAttribute("destination",destination);
			session.setAttribute("travelduration",travelduration);
			session.setAttribute("fare",fare);



			return "routemodify";


		}

		@RequestMapping(value="/routemodify",method=RequestMethod.POST)
		public String domodifyroute(HttpSession session,HttpServletRequest request,Model model)
		{

			String routeid=(String)session.getAttribute("routeid");
			String source=request.getParameter("source");
			String destination=request.getParameter("destination");
			String travelduration=request.getParameter("travelduration");
			String fare=request.getParameter("fare");

			//String sessionfare=(String) session.getAttribute("fare");

			Route routebean=new Route(routeid, source, destination, travelduration, fare);
			System.out.println(routebean);
			
			if(routeservice.modifyRoute(routebean))
			{
				request.setAttribute("MESSAGE","Details Updated Sucessfully!");
			
				model.addAttribute("ROUTE_LIST",routeservice.viewByAllRoute());

				return "routelist";

			}
			else
			{
				request.setAttribute("MESSAGE","Updated Failed");
				return "redirect:routemodify";

			}





		}

		


}