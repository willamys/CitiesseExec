package gms.data;

import gms.GMSResult;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import properties.ApplicationStrings;
import util.ApplicationException;
import util.connection.HibernateConnection;

public class GMSResultDAOHibernate implements GMSDAO {

	public void insert(GMSResult t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSRESULT_ERROR_MESSAGE_INSERT_RESULT);
		} finally {
			session.close();
		}
	}

	public void update(GMSResult t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			throw new GMSDataAccessException(ApplicationStrings.GMSRESULT_ERROR_MESSAGE_UPDATE_RESULT);
		} finally {
			session.close();
		}
	}

	public void delete(GMSResult t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.delete(t);
			transaction.commit();

		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSRESULT_ERROR_MESSAGE_DELETE_RESULT);
		} finally {
			session.close();
		}
	}

	public List<GMSResult> listAll() throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			List<GMSResult> result = session.createQuery("from GMSResult").list();
			transaction.commit();
			return result;
		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSRESULT_ERROR_MESSAGE_LIST_ALL_RESULT);
		} finally {
			session.close();
		}
	}

	public GMSResult listById(int id) throws ApplicationException {
		Session session = null;
		try {
			session = HibernateConnection.getSession();
			Query q = session.createQuery("from GMSResult where id = :id");
			q.setParameter("id", id);
			GMSResult result = (GMSResult) q.uniqueResult();
			return result;
		} catch (Exception ex) {
			throw new GMSDataAccessException(ApplicationStrings.GMSRESULT_ERROR_MESSAGE_LIST_RESULT);
		} finally {
			session.close();
		}
	}

}
