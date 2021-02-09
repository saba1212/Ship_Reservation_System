package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Ship {
	
	@Id
	private String shipid;
	
	@Column
	private String shipname;
	
	@Column
	private int seatingcapacity ;
	
	@Column
	private int reservationcapacity;

	
	public Ship() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ship(String shipId, String shipName, int seatingcapacity, int reservationcapacity) {
		super();
		this.shipid = shipId;
		this.shipname = shipName;
		this.seatingcapacity = seatingcapacity;
		this.reservationcapacity = reservationcapacity;
	}


	

	

	public String getShipid() {
		return shipid;
	}


	public void setShipid(String shipid) {
		this.shipid = shipid;
	}


	


	public String getShipname() {
		return shipname;
	}


	public void setShipname(String shipname) {
		this.shipname = shipname;
	}


	public int getSeatingcapacity() {
		return seatingcapacity;
	}


	public void setSeatingcapacity(int seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}


	public int getReservationcapacity() {
		return reservationcapacity;
	}


	public void setReservationcapacity(int reservationcapacity) {
		this.reservationcapacity = reservationcapacity;
	}


	@Override
	public String toString() {
		return "Ship [shipid=" + shipid + "]";
	}


	
	
	


}
