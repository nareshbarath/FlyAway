package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Places;
import com.util.HibernateUtil;

public class PlacesDao {
	public String addPlace(Places p) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(p);
			transaction.commit();
			return "Place added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding place";
		}
	}

	public List<Places> getPlaces() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Places a", Places.class).getResultList();
		}
	}

	public String deletePlace(long id) {
		Transaction transaction = null;
		Places place = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			place = session.get(Places.class, id);
			session.delete(place);
			transaction.commit();
			return "Place deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting place";

		}
	}

	public Places getplacebyID(long id) {
		Places p = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			p = session.get(Places.class, id);
			return p;
		}
	}

	public Places getplacebyName(String place) {
		Places p = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			p = (Places) session.createQuery("from Places places where places.place =:place")
					.setParameter("place", place).getSingleResult();
			return p;
		}
	}
}
