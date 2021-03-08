package com.cruds.srs.db;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.srs.entity.Route;
import com.cruds.srs.entity.Schedule;
import com.cruds.srs.exception.SRSException;

//@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	
	@Autowired
	SessionFactory sessionfactory;



	public void setSessionfactory(SessionFactory sessionfactory) {
	this.sessionfactory = sessionfactory;
}

	
	//add schedule
	public String addSchedule(Schedule scheduleBean) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		try
		{


			session.save(scheduleBean);
			session.getTransaction().commit();
			session.close();
			return "success";

		}
		
		
		
		catch (SRSException e) 
		{
		
		e.printStackTrace();
		if(e.getMessage().contains("Same Entry"))
		{
			throw new SRSException(scheduleBean.getScheduleid() +" This ScheduleID already exists!");
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

	
	//display schedule list
	public ArrayList<Schedule> viewByAllSchedule() {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		ArrayList<Schedule> schedulelist= (ArrayList<Schedule>) session.createQuery("from Schedule").list();
		session.getTransaction().commit();
		session.close();
		return schedulelist;
	}

	
	//remove schedule
	public int removeSchedule(String scheduleId) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();

		try
		{
			Schedule s= (Schedule) session.load(Schedule.class, scheduleId);			
			session.delete(s);
			session.flush();
			session.getTransaction().commit();
			session.close();

			return 1;
		}
		
		catch ( java.lang.IllegalArgumentException e) {

			System.out.println(" Exception"+e.getMessage());
			
			return 0;
		}
		
		catch (org.hibernate.exception.ConstraintViolationException e) 
		{
			
			return 0;
		}

	}

	
	//modify schedule
	public boolean modifySchedule(Schedule scheduleBean) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
			session.update(scheduleBean);
			session.getTransaction().commit();
			session.close();
			return true ;
		}
		catch ( java.lang.NumberFormatException e) {

			System.out.println("Exception");
			return false;
		}
		catch (org.hibernate.TransientObjectException e) {
			
			return false;
		}
	}

	}


