package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Bookings;
import com.util.HibernateUtil;

public class BookingsDao {
	public String addBooking(Bookings b) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(b);
			transaction.commit();
			return "Booking added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding booking";
		}
	}

	public List<Bookings> getBookings() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Bookings a", Bookings.class).getResultList();
		}
	}

	public String deleteBooking(long id) {
		Transaction transaction = null;
		Bookings booking = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			booking = session.get(Bookings.class, id);
			session.delete(booking);
			transaction.commit();
			return "Booking deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting booking";

		}
	}

	public Bookings getbookingbyID(long id) {
		Bookings b = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			b = session.get(Bookings.class, id);
			return b;
		}
	}
}
