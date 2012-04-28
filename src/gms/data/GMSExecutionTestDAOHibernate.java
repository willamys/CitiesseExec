package gms.data;

import gms.GMSExecutionTest;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import properties.ApplicationStrings;
import util.ApplicationException;
import util.connection.HibernateConnection;

public class GMSExecutionTestDAOHibernate implements GMSDAO {
	
	public void insert(GMSExecutionTest t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSEXECUTIONTEST_ERROR_MESSAGE_INSERT_EXECUTIONTEST);
		} finally {
			session.close();
		}
	}

	public void update(GMSExecutionTest t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSEXECUTIONTEST_ERROR_MESSAGE_UPDATE_EXECUTIONTEST);
		} finally {
			session.close();
		}
	}

	public void delete(GMSExecutionTest t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.delete(t);
			transaction.commit();

		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSEXECUTIONTEST_ERROR_MESSAGE_DELETE_EXECUTIONTEST);
		} finally {
			session.close();
		}
	}

	public List<GMSExecutionTest> listAll() throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			List<GMSExecutionTest> result = session.createQuery("from GMSExecutionTest").list();
			transaction.commit();
			return result;
		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSEXECUTIONTEST_ERROR_MESSAGE_LIST_ALL_EXECUTIONTEST);
		} finally {
		}
	}

	public GMSExecutionTest listById(int id) throws ApplicationException {
		Session session = null;
		try {
			session = HibernateConnection.getSession();
			Query q = session.createQuery("from testcase where id = :id");
			q.setParameter("id", id);
			GMSExecutionTest result = (GMSExecutionTest) q.uniqueResult();
			session.close();
			return result;
		} catch (Exception ex) {
			throw new GMSDataAccessException(ApplicationStrings.GMSEXECUTIONTEST_ERROR_MESSAGE_LIST_EXECUTIONTEST);
		} finally {
			session.close();
		}
	}
}
