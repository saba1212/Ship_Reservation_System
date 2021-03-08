package com.cruds.srs.db;

import com.cruds.srs.entity.Credentials;
import com.cruds.srs.entity.Profile;

public interface CredentialsDAO {
	
	
	public boolean Customeradd(Profile profilebean);
	
	 public String login(Credentials credentialsBean);

}
