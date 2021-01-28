package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credentials {
    
	@Id
	private String userid;
	
	@Column
	private String password;
	
	@Column
	private String usertype;
	
	@Column
	private int loginstatus;
	
	

	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Credentials(String userid, String password, String usertype, int loginstatus) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUsertype() {
		return usertype;
	}



	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}



	public int getLoginstatus() {
		return loginstatus;
	}



	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}



	@Override
	public String toString() {
		return "Credentials [userid=" + userid + ", password=" + password + ", usertype=" + usertype + ", loginstatus="
				+ loginstatus + "]";
	}
	
	
}
