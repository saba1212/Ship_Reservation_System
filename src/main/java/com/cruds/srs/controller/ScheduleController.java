package com.cruds.srs.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cruds.srs.entity.Route;
import com.cruds.srs.entity.Schedule;
import com.cruds.srs.entity.Ship;
import com.cruds.srs.service.Scheduleservice;

@Controller
public class ScheduleController {
	
	@Autowired
	Scheduleservice scheduleservice;
	
	
	
	@RequestMapping(value="/Schedule",method=RequestMethod.GET)
	public String showScheduleform(Model model)
	{
		model.addAttribute("command", new Schedule());
		return "schedule";
		
	}
	
	
	@RequestMapping(value="/schedule",method=RequestMethod.POST)
	public String getscheduleform(@RequestParam("scheduleid") String scheduleid,
									@RequestParam("shipid") String shipid,
									@RequestParam("routeid") String routeid,
									@RequestParam("startingdate") String startingdate,
									@RequestParam("departuretime") String departuretime,HttpServletRequest request)
	{
		
		Ship shipbean=new Ship(shipid);
		Route routebean=new Route(routeid);
		Schedule schedulebean=new Schedule(scheduleid, shipbean, routebean, startingdate, departuretime);
		
		System.out.println(schedulebean);
		
		if(scheduleservice.addSchedule(schedulebean)!=null)
		{
			
			
			return "success";
		}
		
		return "schedule";
				
	}
	
	@RequestMapping(value="/Schedulelist",method=RequestMethod.GET)
	public String getScheduleviewtable(Model model)
	{
		model.addAttribute("SCHEDULE_LIST",scheduleservice.viewByAllSchedule());
		
		return "schedulelist";
		
	}
	
	
	
	
	@RequestMapping(value="/scheduledelete",method=RequestMethod.GET)
	public String showscheduledeleteform( HttpServletRequest request,HttpSession session)
	{

		

		String scheduleid=request.getParameter("scheduleid");
		String shipid=request.getParameter("shipid");
		String routeid=request.getParameter("routeid");
		String startingdate=request.getParameter("startingdate");
		String departuretime=request.getParameter("departuretime");

		session.setAttribute("scheduleid",scheduleid);
		session.setAttribute("shipid", shipid);
		session.setAttribute("routeid",routeid);
		session.setAttribute("startingdate",startingdate);
		session.setAttribute("departuretime",departuretime);


		
		return "scheduledelete";
	}
	
	
	@RequestMapping(value="/scheduledeletedo",method=RequestMethod.GET)
	public String getrouteDeleteform( HttpServletRequest request,HttpSession session,Model model)
	{

		String scheduleid=(String)session.getAttribute("scheduleid");
		System.out.println(scheduleid);


		if(scheduleservice.removeSchedule(scheduleid)!=0)
		{
			request.setAttribute("MESSAGE", "succuessfully deleted!");
			model.addAttribute("ROUTE_LIST",scheduleservice.viewByAllSchedule());
			return "redirect:Schedulelist";
		}

		else
		{
			request.setAttribute("MESSAGE", "unsuccessfull");
			return "scheduledelete";
		}

		}
	
	
	
	
	@RequestMapping(value="/schedulemodify",method=RequestMethod.GET)
	public String getscheduleModifyform(HttpServletRequest request,HttpSession session)
	{

		String scheduleid=request.getParameter("scheduleid");
		String shipid=request.getParameter("shipid");
		String routeid=request.getParameter("routeid");
		String startingdate=request.getParameter("startingdate");
		String departuretime=request.getParameter("departuretime");

		session.setAttribute("scheduleid",scheduleid);
		session.setAttribute("shipid", shipid);
		session.setAttribute("routeid",routeid);
		session.setAttribute("startingdate",startingdate);
		session.setAttribute("departuretime",departuretime);



		return "schedulemodify";


	}

	@RequestMapping(value="/schedulemodify",method=RequestMethod.POST)
	public String domodifyroute(HttpSession session,HttpServletRequest request,Model model)
	{

		String scheduleid=request.getParameter("scheduleid");
		String shipid=request.getParameter("shipid");
		String routeid=request.getParameter("routeid");
		String startingdate=request.getParameter("startingdate");
		String departuretime=request.getParameter("departuretime");

		
		String Scheduleid=(String) session.getAttribute("scheduleid");
		
		Ship shipbean=new Ship(shipid);		
		Route routebean=new Route(routeid);
		
		Schedule schedulebean=new Schedule(Scheduleid, shipbean, routebean, startingdate, departuretime);
		System.out.println(schedulebean);
		
		if(scheduleservice.modifySchedule(schedulebean))
		{
			request.setAttribute("MESSAGE","Details Updated Sucessfully!");
		
			model.addAttribute("ROUTE_LIST",scheduleservice.viewByAllSchedule());

			return "schedulelist";

		}
		else
		{
			request.setAttribute("MESSAGE","Updated Failed");
			return "redirect:schedulemodify";

		}





	}

	

}
