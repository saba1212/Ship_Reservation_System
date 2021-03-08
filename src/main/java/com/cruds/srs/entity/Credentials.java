package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SRS_TBL_CREDENTIALS", schema="SRS")
public class Credentials {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID", length=6, nullable = false, unique = false, updatable = true)
	private String userid;
	
	
	@Column(name="PASSWORD", length=20, nullable = false, unique = false, updatable = true)
	private String password;
	
	@Column(name="USER_TYPE", length=15, nullable = false, unique = false, updatable = true)
	private String usertype;
	
	@Column(name="LOGIN_STATUS")
	private int loginstatus;

	
	public Credentials() {
		
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
