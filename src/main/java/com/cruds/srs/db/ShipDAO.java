package com.cruds.srs.db;

import java.util.ArrayList;

import com.cruds.srs.entity.Ship;

public interface ShipDAO {
	
	public String addship(Ship shipBean);
	
	public boolean modifyShip(Ship shipbean);
	
	public int removeShip(String shipid);
	
	public ArrayList<Ship> viewByAllShips();

}
