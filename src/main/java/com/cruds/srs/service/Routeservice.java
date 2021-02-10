package com.cruds.srs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.srs.db.RouteDAO;
import com.cruds.srs.entity.Route;

@Service
public class Routeservice {

	@Autowired
	RouteDAO routedao;

	
	
	public String addRoute(Route Routebean)
	{
		return routedao.addRoute(Routebean);
	}
	
	
	public ArrayList<Route> viewByAllRoute()
	{
		return routedao.viewByAllRoute();
	}
	
	
	public int  removeRoute(String routeId)
	{
		return routedao.removeRoute(routeId);
	}
	
	
	public boolean modifyRoute(Route routeBean)
	{
		return routedao.modifyRoute(routeBean);
	}
	
	
	
	
	
	
	
}
