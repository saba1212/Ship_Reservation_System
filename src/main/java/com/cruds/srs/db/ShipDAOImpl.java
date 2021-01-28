package com.cruds.srs.db;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.srs.entity.Ship;
import com.cruds.srs.exception.SMSException;

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
	
	
	
	catch (SMSException e) 
	{
	
	e.printStackTrace();
	if(e.getMessage().contains("Duplicate Entry"))
	{
		throw new SMSException(shipBean.getShipId() +" This ShipId already exists!");
	}
	else
	{   
		throw new SMSException(e.getMessage() +"contact the Ship Administration Authorities!\t Have a Good Day!!");
	}
}
	catch (org.hibernate.exception.ConstraintViolationException e) {
		
		System.out.println("Duplicate entry not possible");

	}
	return null;


}

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

		System.out.println("nullformat exception");
		return false;
	}
	catch (org.hibernate.TransientObjectException e) {
		// TODO: handle exception
		return false;
	}


}

public int removeShip(String shipid) {

	Session session=sessionfactory.openSession();
	session.beginTransaction();

	try
	{
		Ship s=(Ship) session.load(Ship.class, shipid);
		session.delete(s);

		session.getTransaction().commit();
		session.close();


		return 1;
	}
	
	
	catch ( java.lang.IllegalArgumentException e) {

		System.out.println("null pointer exception"+e.getMessage());
		// TODO: handle exception
		return 0;
	}
}
	
@SuppressWarnings("unchecked")
public ArrayList<Ship> viewByAllShips() {

	Session session=sessionfactory.openSession();
	session.beginTransaction();
	ArrayList<Ship> slist= (ArrayList<Ship>) session.createQuery("from Ship").list();
	session.getTransaction().commit();
	session.close();
	return slist;

}

}
