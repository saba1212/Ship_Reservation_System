package com.cruds.srs.controller;

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
	
	/*@Autowired
	private Shipservice  shipservice;*/
	

	@RequestMapping(value="/Ship",method=RequestMethod.GET)
	public String showshipform(Model model)
	{
		model.addAttribute("command", new Ship());
		
		return "ship";

	}

	@RequestMapping(value="/ship",method=RequestMethod.POST)
	public String doShip(@RequestParam("shipid") String shipid,
						 @RequestParam("shipname")String shipname,
						 @RequestParam("seatingcapacity") String seatingcapacity,
						 @RequestParam("reservationcapacity") String reservationcapacity)
			
{
		
		System.out.println(shipid + shipname + seatingcapacity + reservationcapacity);
		return "success";
  }
	
		
}
