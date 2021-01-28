package com.cruds.srs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passenger {
	
	@Id
	private String reservationid;
	@Column
	private String scheduleid;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String gender;
	
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Passenger(String reservationid, String scheduleid, String name, int age, String gender) {
		super();
		this.reservationid = reservationid;
		this.scheduleid = scheduleid;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	public String getReservationid() {
		return reservationid;
	}


	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}


	public String getScheduleid() {
		return scheduleid;
	}


	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Passenger [reservationid=" + reservationid + ", scheduleid=" + scheduleid + ", name=" + name + ", age="
				+ age + ", gender=" + gender + "]";
	}
	
	
	
}
