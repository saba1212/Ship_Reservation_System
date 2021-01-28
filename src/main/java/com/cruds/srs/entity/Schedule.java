package com.cruds.srs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {
	
	@Id
	private String scheduleid;
	
	@Column
	private Date startdate;
	
	

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Schedule(String scheduleid, Date startdate) {
		super();
		this.scheduleid = scheduleid;
		this.startdate = startdate;
	}



	public String getScheduleid() {
		return scheduleid;
	}



	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}



	public Date getStartdate() {
		return startdate;
	}



	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}



	@Override
	public String toString() {
		return "Schedule [scheduleid=" + scheduleid + ", startdate=" + startdate + "]";
	}
	
	

}
