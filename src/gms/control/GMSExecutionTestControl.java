package gms.control;

import java.util.List;

import gms.GMSExecutionTest;
import gms.GMSTestCase;
import gms.data.GMSExecutionTestDAOHibernate;
import gms.data.GMSTestCaseDAOHibernate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import util.ApplicationException;

@ManagedBean
@SessionScoped
public class GMSExecutionTestControl {

	private GMSExecutionTestDAOHibernate dao;
	private GMSExecutionTest executionTest = new GMSExecutionTest();
	private DataModel<GMSExecutionTest> listExecutionTest;
	
	public DataModel<GMSExecutionTest> getListTestCase() throws ApplicationException{
		dao = new GMSExecutionTestDAOHibernate();
		List<GMSExecutionTest> list = dao.listAll();
		listExecutionTest = new ListDataModel<GMSExecutionTest>(list);
		return listExecutionTest;
	}
	
	/*
	 * Falta os métodos
	 */
	
	public GMSExecutionTest getExecutionTest() {
		return executionTest;
	}
	
	public void setExecutionTest(GMSExecutionTest executionTest) {
		this.executionTest = executionTest;
	}
	
}
