package com.flightapp.airlineservice.entities;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Airlines {

	@Id
	String airlineId;
	@Column
	String name;
	@Column
	Blob logo;
	public String getId() {
		return airlineId;
	}
	public void setId(String id) {
		this.airlineId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	
	
}
