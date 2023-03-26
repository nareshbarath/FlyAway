package com.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Places")
public class Places {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@Column(name = "place")
	private String place;

	public Places(String place) {
		super();
		this.place = place;
	}

	public Places() {
		super();
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Places [ID=" + ID + ", place=" + place + "]";
	}

}
