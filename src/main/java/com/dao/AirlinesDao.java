package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Airlines;
import com.util.HibernateUtil;

public class AirlinesDao {
	public String addAirline(Airlines a) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(a);
			transaction.commit();
			return "Airline added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding airline";
		}
	}

	public List<Airlines> getAirlines() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Airlines a", Airlines.class).getResultList();
		}
	}

	public String deleteAirline(long id) {
		Transaction transaction = null;
		Airlines airline = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			airline = session.get(Airlines.class, id);
			session.delete(airline);
			transaction.commit();
			return "Airline deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting airline";

		}
	}

	public Airlines getairlinebyID(long id) {
		Airlines a = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			a = session.get(Airlines.class, id);
			return a;
		}
	}

	public Airlines getairlinebyName(String airlineName) {
		Airlines a = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			a = (Airlines) session.createQuery("from Airlines airlines where airlines.airlineName =:airlineName")
					.setParameter("airlineName", airlineName).getSingleResult();
			return a;
		}
	}
}
