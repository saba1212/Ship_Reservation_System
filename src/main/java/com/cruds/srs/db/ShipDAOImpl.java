package com.cruds.srs.db;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.srs.entity.Ship;
import com.cruds.srs.exception.SRSException;

@Repository
public class ShipDAOImpl implements ShipDAO {

@Autowired	
SessionFactory sessionfactory;


public void setSessionfactory(SessionFactory sessionfactory) {
	
	this.sessionfactory = sessionfactory;
}

public String addship(Ship shipBean)
{

	Session session=sessionfactory.openSession();
	session.beginTransaction();
	
	
	try
	{


		session.save(shipBean);
		session.getTransaction().commit();
		session.close();
		return "success";

	}
	
	
	
	catch (SRSException e) 
	{
	
	e.printStackTrace();
	if(e.getMessage().contains("Same Entry"))
	{
		throw new SRSException(shipBean.getShipid() +" This ShipId already exists!");
	}
	else
	{   
		throw new SRSException(e.getMessage() +"contact the Ship Administration Authorities!\n Have a Good Day!!");
	}
	}
	
	catch (org.hibernate.exception.ConstraintViolationException e) 
	{
		// TODO: handle exception
		System.out.println("Same Entry is not possible");

	}
	return null;
}

	
	




//ship details after adding (list)
public ArrayList<Ship> viewByAllShips() {
	Session session=sessionfactory.openSession();
	session.beginTransaction();
	ArrayList<Ship> shiplist= (ArrayList<Ship>) session.createQuery("from Ship").list();
	session.getTransaction().commit();
	session.close();
	return shiplist;
}


//Ship modify
public boolean modifyShip(Ship shipbean) {
	Session session=sessionfactory.openSession();
	session.beginTransaction();
	try
	{
		session.update(shipbean);
		session.getTransaction().commit();
		session.close();
		return true ;
	}
	catch ( java.lang.NumberFormatException e) {

		System.out.println("exception");
		return false;
	}
	catch (org.hibernate.TransientObjectException e) {
		// TODO: handle exception
		return false;
	}



	}



//delete ship
public int removeShip(String shipId) {
	
	Session session=sessionfactory.openSession();
	session.beginTransaction();

	try
	{
		Ship s= (Ship) session.load(Ship.class, shipId);
		//System.out.println(getShipid());
		session.delete(s);
		session.flush();

		session.getTransaction().commit();
		session.close();


		return 1;
	}
	
	catch ( java.lang.IllegalArgumentException e) {

		System.out.println(" exception"+e.getMessage());
		
		return 0;
	}
	
	catch (org.hibernate.exception.ConstraintViolationException e) 
	{
		
		return 0;
	}

}
}



