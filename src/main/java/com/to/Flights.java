package com.to;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Flights")
public class Flights {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "airline", referencedColumnName = "ID")
	private Airlines airline;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "source", referencedColumnName = "ID")
	private Places source;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "destination", referencedColumnName = "ID")
	private Places destination;

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "departure")
	private Date departure;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "arival")
	private Date arival;

	@Column(name = "ticketprice")
	private Double ticketprice;

	public Flights(Airlines airline, Places source, Places destination, Date date, Date departure, Date arival,
			Double ticketprice) {
		super();
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.departure = departure;
		this.arival = arival;
		this.ticketprice = ticketprice;
	}

	public Flights() {
		super();
	}

	public Airlines getAirline() {
		return airline;
	}

	public void setAirline(Airlines airline) {
		this.airline = airline;
	}

	public Places getSource() {
		return source;
	}

	public void setSource(Places source) {
		this.source = source;
	}

	public Places getDestination() {
		return destination;
	}

	public void setDestination(Places destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getArival() {
		return arival;
	}

	public void setArival(Date arival) {
		this.arival = arival;
	}

	public Double getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(Double ticketprice) {
		this.ticketprice = ticketprice;
	}

	public long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Flights [ID=" + ID + ", airline=" + airline + ", source=" + source + ", destination=" + destination
				+ ", date=" + date + ", departure=" + departure + ", arival=" + arival + ", ticketprice=" + ticketprice
				+ "]";
	}

}
