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
@Table(name = "Bookings")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Long age;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private Long phone;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "flight", referencedColumnName = "ID")
	private Flights flight;

	@Column(name = "ticketscount")
	private Long ticketscount;

	@Column(name = "totalamount")
	private Double totalamount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bookingtime")
	private Date bookingtime;

	public Bookings(String name, Long age, String email, Long phone, Flights flight, Long ticketscount,
			Double totalamount, Date bookingtime) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.flight = flight;
		this.ticketscount = ticketscount;
		this.totalamount = totalamount;
		this.bookingtime = bookingtime;
	}

	public Bookings() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	public Long getTicketscount() {
		return ticketscount;
	}

	public void setTicketscount(Long ticketscount) {
		this.ticketscount = ticketscount;
	}

	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}

	public Date getBookingtime() {
		return bookingtime;
	}

	public void setBookingtime(Date bookingtime) {
		this.bookingtime = bookingtime;
	}

	public long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Bookings [ID=" + ID + ", name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", flight=" + flight + ", ticketscount=" + ticketscount + ", totalamount=" + totalamount
				+ ", bookingtime=" + bookingtime + "]";
	}

}
