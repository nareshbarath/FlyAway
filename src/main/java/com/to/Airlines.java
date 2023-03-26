package com.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Airlines")
public class Airlines {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@Column(name = "airlineName")
	private String airlineName;

	public Airlines(String airlineName) {
		super();
		this.airlineName = airlineName;
	}

	public Airlines() {
		super();
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Airlines [ID=" + ID + ", airlineName=" + airlineName + "]";
	}

}
