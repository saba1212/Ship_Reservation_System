package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ship {
	
	@Id
	private String shipId;
	
	@Column
	private String shipName;
	
	@Column
	private int seatingCapacity ;
	
	@Column
	private int reservationCapacity;

	
	public Ship() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ship(String shipId, String shipName, int seatingCapacity, int reservationCapacity) {
		super();
		this.shipId = shipId;
		this.shipName = shipName;
		this.seatingCapacity = seatingCapacity;
		this.reservationCapacity = reservationCapacity;
	}


	public String getShipId() {
		return shipId;
	}


	public void setShipId(String shipId) {
		this.shipId = shipId;
	}


	public String getShipName() {
		return shipName;
	}


	public void setShipName(String shipName) {
		this.shipName = shipName;
	}


	public int getSeatingCapacity() {
		return seatingCapacity;
	}


	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}


	public int getReservationCapacity() {
		return reservationCapacity;
	}


	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}


	@Override
	public String toString() {
		return "Ship [shipId=" + shipId + ", shipName=" + shipName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity + "]";
	}
	
	


}
