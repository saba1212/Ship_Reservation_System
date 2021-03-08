package com.cruds.srs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="SRS_TBL_SCHEDULE", schema="SRS")
public class Schedule {
	
	@Id
	@Column(name="SCHEDULE_ID", length=6)
	private String scheduleid;
	
	@ManyToOne
	@JoinColumn(name="SHIP_ID")
	private Ship shipid;
	
	@ManyToOne
	@JoinColumn(name="ROUTE_ID")
	private Route routeid;
	
	
	@Column(name="STARTING_DATE")
	private String startingdate;


	@Column(name="DEPARTURE_TIME")
	private String departuretime;

	
	

	


	public Schedule(String scheduleid, Ship shipid, Route routeid, String startingdate, String departuretime) {
		super();
		this.scheduleid = scheduleid;
		this.shipid = shipid;
		this.routeid = routeid;
		this.startingdate = startingdate;
		this.departuretime = departuretime;
	}


	public Schedule() {
		
		// TODO Auto-generated constructor stub
	}


	public String getScheduleid() {
		return scheduleid;
	}


	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}


	public Ship getShipid() {
		return shipid;
	}


	public void setShipid(Ship shipid) {
		this.shipid = shipid;
	}


	public Route getRouteid() {
		return routeid;
	}


	public void setRouteid(Route routeid) {
		this.routeid = routeid;
	}


	public String getStartingdate() {
		return startingdate;
	}


	public void setStartingdate(String startingdate) {
		this.startingdate = startingdate;
	}


	public String getDeparturetime() {
		return departuretime;
	}


	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}


	@Override
	public String toString() {
		return "Schedule [scheduleid=" + scheduleid + ", shipid=" + shipid + ", routeid=" + routeid + ", startingdate="
				+ startingdate + ", departuretime=" + departuretime + "]";
	}
	
	
	
	
}
