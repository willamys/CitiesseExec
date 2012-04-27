package gms.control;

import gms.GMSWorkFlow;
import gms.data.GMSWorkflowDAOHibernate;

import java.util.List;
import util.ApplicationException;

public class GMSWorkFlowControl {
	
	private GMSWorkflowDAOHibernate dao;
//
//	public GMSWorkFlowControl(GMSWorkflowDAOHibernate dao) {
//		this.dao = dao;
//	}

	public void insert(GMSWorkFlow t) throws ApplicationException {
		// falta regras
		dao.insert(t);
	}

	public void update(GMSWorkFlow t) throws ApplicationException {
		// falta regras
		dao.update(t);
	}

	public void delete(GMSWorkFlow t) throws ApplicationException {
		// falta regras
		dao.delete(t);
	}

	public List<GMSWorkFlow> listAll() throws ApplicationException {
		// falta regras
		return dao.listAll();
	}

	public GMSWorkFlow listById(int id) throws ApplicationException {
		// falta regras
		return dao.listById(id);
	}
}
