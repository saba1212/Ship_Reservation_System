package com.cruds.srs.db;

import java.util.ArrayList;

import com.cruds.srs.entity.Route;

public interface RouteDAO {

	public String addRoute(Route routeBean);
	
	public boolean modifyRoute(Route routebean);
	
	public int removeRoute(String routeid);
	
	public ArrayList<Route> viewByAllRoute();


}
