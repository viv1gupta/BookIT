package com.flightapp.airlineservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Flights {

	@Id
	@Column
	String flightNumber;
	@Column
	int seats;
	
	@Column
	String instrumentsUsed;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id")
	Airlines airline;
	
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Airlines getAirline() {
		return airline;
	}
	public void setAirline(Airlines airline) {
		this.airline = airline;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getInstrumentsUsed() {
		return instrumentsUsed;
	}
	public void setInstrumentsUsed(String instrumentsUsed) {
		this.instrumentsUsed = instrumentsUsed;
	}
	
	
}
