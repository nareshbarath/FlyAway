package com.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Flights;
import com.to.Places;
import com.util.HibernateUtil;

public class FlightsDao {
	public String addFlight(Flights f) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(f);
			transaction.commit();
			return "Flight added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding flight";
		}
	}

	public List<Flights> getFlights() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Flights a", Flights.class).getResultList();
		}
	}

	public String deleteFlight(long id) {
		Transaction transaction = null;
		Flights flight = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			System.out.println("Deleting flight");

			transaction = session.beginTransaction();
			flight = session.get(Flights.class, id);
			session.delete(flight);
			transaction.commit();
			return "Flight deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting flight";

		}
	}

	public Flights getflightbyID(long id) {
		Flights f = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			f = session.get(Flights.class, id);
			return f;
		}
	}

	public List<Flights> searchFlights(Date date, Places source, Places destination) {
		List<Flights> flights = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			flights = (List<Flights>) session.createQuery(
					"from Flights flights where flights.date =:date and flights.source =:source and flights.destination= :destination")
					.setParameter("date", date).setParameter("source", source).setParameter("destination", destination)
					.getResultList();
			return flights;
		} catch (Exception e) {
			System.out.println(e);
			return flights;
		}
	}
}
