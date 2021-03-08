package com.cruds.srs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.srs.db.CredentialsDAO;
import com.cruds.srs.entity.Credentials;
import com.cruds.srs.entity.Profile;

@Service
public class Credentialsservice {
	
	@Autowired
	CredentialsDAO credentialsDAO;
	
	public String login(Credentials credentialsBean)
	{
		
		return credentialsDAO.login(credentialsBean);
	
	}
	
	
	public boolean Customeradd(Profile profilebean) 
	{
		
		return credentialsDAO.Customeradd(profilebean);
	
	}

}
