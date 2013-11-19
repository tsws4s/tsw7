package wsdm.rest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import wsdm.dao.HibernateSessionFactory;

public abstract class AbstractRest {

	Object executeUniqueResultQuery(String sql) {
		Object result = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			result = query.uniqueResult();
			tx.commit(); // Flush happens automatically
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.close();
		}
		return result;
	}
	
	Object executeResultListQuery(String sql) {
		Object result = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			result = query.list();
			tx.commit(); // Flush happens automatically
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.close();
		}
		return result;
	}

	Object executeUpdateQuery(String sql) {
		Object result = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);
			result = query.executeUpdate();
			tx.commit(); // Flush happens automatically
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.close();
		}
		return result;
	}
}
