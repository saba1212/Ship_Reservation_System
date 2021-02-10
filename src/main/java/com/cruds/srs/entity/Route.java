package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {


	@Id
	private String routeid;
	
	@Column
	private String source;
	
	@Column
	private String destination;
	
	@Column
	private String travelduration;
	
	@Column
	private int fare;

	
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Route(String routeid, String source, String destination, String travelduration, int fare) {
		super();
		this.routeid = routeid;
		this.source = source;
		this.destination = destination;
		this.travelduration = travelduration;
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "Route [routeid=" + routeid + ", source=" + source + ", destination=" + destination + ", travelduration="
				+ travelduration + ", fare=" + fare + "]";
	}


	
	
	



}
