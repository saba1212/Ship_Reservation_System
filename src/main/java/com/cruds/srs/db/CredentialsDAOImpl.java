package com.cruds.srs.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cruds.srs.entity.Credentials;
import com.cruds.srs.entity.Profile;

public class CredentialsDAOImpl implements CredentialsDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	public boolean Customeradd(Profile profilebean) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		try
		{
			
		 Profile profilebean1=(Profile) session.save(profilebean);
		 
		 String userid=profilebean1.getUserid();
		
		 Profile profileid=new Profile(userid);
		
		session.getTransaction().commit();
		session.close();
		
		return true;
		
		
		}
		catch (org.hibernate.exception.ConstraintViolationException e) {
			// TODO: handle exception
			System.out.println("Duplicate entry Invalid!");
			return false;

		}
	
	}

	public String login(Credentials credentialsBean) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		try
		{
		Credentials  u = (Credentials) session.createQuery("FROM Credentials C WHERE C.userid = :userid and C.password=:password").setParameter("userid", credentialsBean.getUserid()).setParameter("password",credentialsBean.getPassword()).setParameter("usertype",credentialsBean.getUsertype()).uniqueResult();
		
		System.out.println(credentialsBean.getPassword());

		System.out.println("password"+u.getPassword());
		
		session.getTransaction().commit();
		session.close();


		return "success";
		}
		
		
		catch (NullPointerException e)
		{
			// TODO: handle exception
			return null;
		}

	}

}
