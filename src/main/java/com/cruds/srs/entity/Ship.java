package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name= "SHIPID")
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


	public Ship(String shipId, String shipName, int seatingCapacity, int reservationCapacity) {
		super();
		this.shipid = shipId;
		this.shipname = shipName;
		this.seatingcapacity = seatingCapacity;
		this.reservationcapacity = reservationCapacity;
	}


	public String getShipId() {
		return shipid;
	}


	public void setShipId(String shipId) {
		this.shipid = shipId;
	}


	public String getShipName() {
		return shipname;
	}


	public void setShipName(String shipName) {
		this.shipname = shipName;
	}


	public int getSeatingCapacity() {
		return seatingcapacity;
	}


	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingcapacity = seatingCapacity;
	}


	public int getReservationCapacity() {
		return reservationcapacity;
	}


	public void setReservationCapacity(int reservationCapacity) {
		this.reservationcapacity = reservationCapacity;
	}


	@Override
	public String toString() {
		return "Ship [shipId=" + shipid + ", shipName=" + shipname + ", seatingCapacity=" + seatingcapacity
				+ ", reservationCapacity=" + reservationcapacity + "]";
	}
	
	


}
