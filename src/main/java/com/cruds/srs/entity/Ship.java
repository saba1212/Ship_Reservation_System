package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SRS_TBL_SHIP", schema="SRS")
public class Ship {
	
	@Id
	@Column(name = "SHIP_ID",length=250)
	private String shipid;
	
	
	@Column(name = "SHIP_NAME",length= 50, nullable = false, unique = false, updatable = true)	
	private String shipname;
	
	@Column(name="SEATING_CAPACITY",length=4, nullable = false, unique = false, updatable = true)
	private int seatingcapacity ;
	
	@Column(name="RESERVATION_CAPACITY", length=4, nullable = false, unique = false, updatable = true)
	private int reservationcapacity;

	
	
	public Ship() {
		
		// TODO Auto-generated constructor stub
	}



	public Ship(String shipid, String shipname, int seatingcapacity, int reservationcapacity) {
		super();
		this.shipid = shipid;
		this.shipname = shipname;
		this.seatingcapacity = seatingcapacity;
		this.reservationcapacity = reservationcapacity;
	}



	public Ship(String shipid) {
		super();
		this.shipid=shipid;
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
		return "Ship [shipid=" + shipid + ", shipname=" + shipname + ", seatingcapacity=" + seatingcapacity
				+ ", reservationcapacity=" + reservationcapacity + "]";
	}



	
}
