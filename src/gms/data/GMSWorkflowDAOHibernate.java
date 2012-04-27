package gms.data;

import gms.GMSWorkFlow;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import properties.ApplicationStrings;
import util.ApplicationException;
import util.connection.HibernateConnection;

public class GMSWorkflowDAOHibernate implements GMSDAO {

	public void insert(GMSWorkFlow t) throws ApplicationException {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();

		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSWORKFLOW_ERROR_MESSAGE_INSERT_TESTCASE);
		} finally {
			session.close();
		}
	}

	public void update(GMSWorkFlow t) throws ApplicationException {
		Session session = null;
		Transaction transaction;

		try {

			session = HibernateConnection.getSession();
			transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();

		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_UPDATE_TESTCASE);
		} finally {
			session.close();
		}
	}

	public void delete(GMSWorkFlow t) throws ApplicationException {
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

	public List<GMSWorkFlow> listAll() throws ApplicationException {
		Session session = null;
		
		try {

			session = HibernateConnection.getSession();
			Query q = session.createQuery("from gms.model.GMSWorkFlow");
			@SuppressWarnings("unchecked")
			List<GMSWorkFlow> result = q.list();
			session.close();

			return result;
			
		} catch (HibernateException e) {
			throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_LIST_ALL_TESTCASE);
		} finally {
			session.close();
		}
	}

	public GMSWorkFlow listById(int id) throws ApplicationException {
		Session session = null;
		
		try {
			session = HibernateConnection.getSession();
			Query q = session.createQuery("from gms.model.GMSWorkFlow where id = :id");
			q.setParameter("id", id);
			GMSWorkFlow result = (GMSWorkFlow) q.uniqueResult();
			session.close();
			
			return result;
			
		} catch (Exception ex) {
			throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_LIST_TESTCASE);
		} finally {
			session.close();
		}
	}

}
