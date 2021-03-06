package gms.data;

import gms.GMSTestCase;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import properties.ApplicationStrings;
import util.ApplicationException;
import util.connection.HibernateConnection;

public class GMSTestCaseDAOHibernate implements GMSDAO {

	public void insert(GMSTestCase t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_INSERT_TESTCASE);
		} finally {
			session.close();
		}
	}

	public void update(GMSTestCase t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_UPDATE_TESTCASE);
		} finally {
			session.close();
		}
	}

	public void delete(GMSTestCase t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.delete(t);
			transaction.commit();

		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_DELETE_TESTCASE);
		} finally {
			session.close();
		}
	}

	public List<GMSTestCase> listAll() throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			List<GMSTestCase> result = session.createQuery("from GMSTestCase").list();
			transaction.commit();
			return result;
		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_LIST_ALL_TESTCASE);
		} finally {
			session.close();
		}
	}

	public GMSTestCase listById(int id) throws ApplicationException {
		Session session = null;
		try {
			session = HibernateConnection.getSession();
			Query q = session.createQuery("from GMSTestCase where id = :id");
			q.setParameter("id", id);
			GMSTestCase result = (GMSTestCase) q.uniqueResult();
			return result;
		} catch (Exception ex) {
			throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_LIST_TESTCASE);
		} finally {
			session.close();
		}
	}

}
