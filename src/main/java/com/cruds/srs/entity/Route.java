package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {

@Id
private String routeId;

@Column
private String source;

@Column
private String destination;

@Column
private String travelDuration;

@Column
private int fare;


public Route() {
	super();
	
}


public Route(String routeId, String source, String destination, String travelDuration, int fare) {
	super();
	this.routeId = routeId;
	this.source = source;
	this.destination = destination;
	this.travelDuration = travelDuration;
	this.fare = fare;
}


public String getRouteId() {
	return routeId;
}


public void setRouteId(String routeId) {
	this.routeId = routeId;
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


public String getTravelDuration() {
	return travelDuration;
}


public void setTravelDuration(String travelDuration) {
	this.travelDuration = travelDuration;
}


public int getFare() {
	return fare;
}


public void setFare(int fare) {
	this.fare = fare;
}


@Override
public String toString() {
	return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", travelDuration="
			+ travelDuration + ", fare=" + fare + "]";
}





}
