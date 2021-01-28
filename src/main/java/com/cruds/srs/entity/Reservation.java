package com.cruds.srs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	private String reservationid;
	@Column
	private String shceduleid;
	@Column
	private String userid;
	@Column
	private Date bookingdate;
	@Column
	private Date journeydate;
	@Column
	private int noofseats;
	@Column
	private int totalfare;
	@Column
	private String bookingstatus;
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reservation(String reservationid, String shceduleid, String userid, Date bookingdate, Date journeydate,
			int noofseats, int totalfare, String bookingstatus) {
		super();
		this.reservationid = reservationid;
		this.shceduleid = shceduleid;
		this.userid = userid;
		this.bookingdate = bookingdate;
		this.journeydate = journeydate;
		this.noofseats = noofseats;
		this.totalfare = totalfare;
		this.bookingstatus = bookingstatus;
	}


	public String getReservationid() {
		return reservationid;
	}


	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}


	public String getShceduleid() {
		return shceduleid;
	}


	public void setShceduleid(String shceduleid) {
		this.shceduleid = shceduleid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public Date getBookingdate() {
		return bookingdate;
	}


	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}


	public Date getJourneydate() {
		return journeydate;
	}


	public void setJourneydate(Date journeydate) {
		this.journeydate = journeydate;
	}


	public int getNoofseats() {
		return noofseats;
	}


	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}


	public int getTotalfare() {
		return totalfare;
	}


	public void setTotalfare(int totalfare) {
		this.totalfare = totalfare;
	}


	public String getBookingstatus() {
		return bookingstatus;
	}


	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}


	@Override
	public String toString() {
		return "Reservation [reservationid=" + reservationid + ", shceduleid=" + shceduleid + ", userid=" + userid
				+ ", bookingdate=" + bookingdate + ", journeydate=" + journeydate + ", noofseats=" + noofseats
				+ ", totalfare=" + totalfare + ", bookingstatus=" + bookingstatus + "]";
	}
	

}
