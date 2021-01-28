package com.cruds.srs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.cruds.srs.db.ShipDAO;
import com.cruds.srs.entity.Ship;

public class Shipservice {
	
	@Autowired
	ShipDAO shipDAO;
	
	public String addship(Ship shipBean)
	{
		return shipDAO.addship(shipBean);
	}
	
	

	public ArrayList<Ship>  viewByAllships()
	{
		return shipDAO.viewByAllShips();
	}
	
	
	public int removeShip(String shipid)
	{
		return shipDAO.removeShip(shipid);
	}
	
	public boolean modifyShip(Ship shipbean)
	{
		return shipDAO.modifyShip(shipbean);
	}

}
