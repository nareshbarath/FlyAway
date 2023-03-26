package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.to.Admin;
import com.util.HibernateUtil;

public class AdminDao {
	public String addAdmin(Admin a) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(a);
			transaction.commit();
			return "Admin added successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error adding admin";
		}
	}

	public List<Admin> getAdmins() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("SELECT a from Admin a", Admin.class).getResultList();
		}
	}

	public String deleteAdmin(long id) {
		Transaction transaction = null;
		Admin admin = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			admin = session.get(Admin.class, id);
			session.delete(admin);
			transaction.commit();
			return "Admin deleted successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting admin";

		}
	}

	public Admin getadminbyID(long id) {
		Admin a = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			a = session.get(Admin.class, id);
			return a;
		}
	}

	public Admin getadminbyEmail(String email) {
		Admin a = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			a = (Admin) session.createQuery("from Admin admin where admin.email =:email").setParameter("email", email)
					.getSingleResult();
			return a;
		}
	}

	public String changePassword(String email, String password) {
		Transaction transaction = null;
		Admin a = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			a = (Admin) session.createQuery("from Admin admin where admin.email =:email").setParameter("email", email)
					.getSingleResult();
			a.setPassword(password);
			session.update(a);
			transaction.commit();
			return "Password updated successfully";
		} catch (Exception e) {
			transaction.rollback();
			return "Error deleting admin";

		}
	}
}
