package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SRS_TBL_ROUTE", schema="SRS")
public class Route {
	
	@Id
	@Column(name="ROUTE_ID", length=250)
	private String routeid;
	
	@Column(name="SOURCE", length=20, nullable = false, unique = false, updatable = true)
	private String source;
	
	@Column(name="DESTINATION", length=20, nullable = false, unique = false, updatable = true)
	private String destination;
	
	@Column(name="TRAVEL_DURATION",length=10, nullable = false, unique = false, updatable = true)
	private String travelduration;
	
	@Column(name="FARE", length=5,nullable = false, unique = false, updatable = true)
	private String fare;

	
	
	public Route() {
		
		// TODO Auto-generated constructor stub
	}



	public Route(String routeid, String source, String destination, String travelduration, String fare) {
		super();
		this.routeid = routeid;
		this.source = source;
		this.destination = destination;
		this.travelduration = travelduration;
		this.fare = fare;
	}



	public Route(String routeid) {
		super();
		this.routeid=routeid;
	}



	public String getRouteid() {
		return routeid;
	}



	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public String getTravelduration() {
		return travelduration;
	}



	public void setTravelduration(String travelduration) {
		this.travelduration = travelduration;
	}



	public String getFare() {
		return fare;
	}



	public void setFare(String fare) {
		this.fare = fare;
	}



	@Override
	public String toString() {
		return "Route [routeid=" + routeid + ", source=" + source + ", destination=" + destination + ", travelduration="
				+ travelduration + ", fare=" + fare + "]";
	}
	
	
	
	
	

}
