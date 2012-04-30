package gms.data;

import gms.GMSTestCase;
import gms.GMSTestCaseSetup;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import properties.ApplicationStrings;
import util.ApplicationException;
import util.connection.HibernateConnection;

public class GMSTestCaseSetupDAOHibernate implements GMSDAO{

		public void insert(GMSTestCaseSetup t) throws ApplicationException {
			Session session = null;
			Transaction transaction;
			try {
				session = HibernateConnection.getSession();
				transaction = session.beginTransaction();
				session.save(t);
				transaction.commit();
			} catch (HibernateException e) {
				System.out.println(e.getMessage());
				throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_INSERT_TESTCASE);
			} finally {
				//session.close();
			}
		}

		public void update(GMSTestCaseSetup t) throws ApplicationException {
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

		public void delete(GMSTestCaseSetup t) throws ApplicationException {
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

		public List<GMSTestCaseSetup> listAll() throws ApplicationException {
			Session session = null;
			Transaction transaction;
			try {
				session = HibernateConnection.getSession();
				transaction = session.beginTransaction();
				List<GMSTestCaseSetup> result = session.createQuery("from GMSTestCaseSetup").list();
				transaction.commit();
				return result;
			} catch (HibernateException e) {
				throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_LIST_ALL_TESTCASE);
			} finally {
				session.close();
			}
		}

		public GMSTestCaseSetup listById(int id) throws ApplicationException {
			Session session = null;
			try {
				session = HibernateConnection.getSession();
				Query q = session.createQuery("from GMSTestCaseSetup where id = :id");
				q.setParameter("id", id);
				GMSTestCaseSetup result = (GMSTestCaseSetup) q.uniqueResult();
				session.close();
				return result;
			} catch (Exception ex) {
				throw new GMSDataAccessException(ApplicationStrings.GMSTESTCASE_ERROR_MESSAGE_LIST_TESTCASE);
			} finally {
				session.close();
			}
		}
}
