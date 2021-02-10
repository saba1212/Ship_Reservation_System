package com.cruds.srs.db;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.srs.entity.Route;

@Repository
public class RouteDAOImpl implements RouteDAO{
	
	@Autowired	
	SessionFactory sessionfactory;
	
	
	public void setSessionfactory(SessionFactory sessionfactory)
	{
		
		this.sessionfactory = sessionfactory;
	}

	

	public boolean modifyRoute(Route routebean) {
		// TODO Auto-generated method stub
		return false;
	}

	public int removeRoute(String routeid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Route> viewByAllRoute() {
		// TODO Auto-generated method stub
		return null;
	}

	public String addRoute(Route routeBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
