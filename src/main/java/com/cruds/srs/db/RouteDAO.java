package com.cruds.srs.db;


import java.util.ArrayList;

import com.cruds.srs.entity.Route;


public interface RouteDAO {
	
	public String addRoute(Route Routebean);
	
	 public ArrayList<Route> viewByAllRoute();
	 
	 public int removeRoute(String routeId);
	 
	 public boolean modifyRoute(Route routebean);

}
