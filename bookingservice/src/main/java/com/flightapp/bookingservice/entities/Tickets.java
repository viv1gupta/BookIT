package com.flightapp.bookingservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tickets {

	@Id
	@Column
	String pnr;
	
	@Column
	String userName;
	
	@Column
	String flightID;
	
	@Column
	int seatNo;
	
	@Column 
	Long boardingTime;
	
	@Column 
	String status;

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public Long getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(Long boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	
}
