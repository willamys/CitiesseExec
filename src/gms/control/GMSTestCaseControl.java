package gms.control;

import gms.GMSTestCase;
import gms.data.GMSTestCaseDAOHibernate;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import util.ApplicationException;

@ManagedBean
@SessionScoped
public class GMSTestCaseControl{
	
	private GMSTestCaseDAOHibernate dao;
	private GMSTestCase testCase =  new GMSTestCase();
	private DataModel<GMSTestCase> listTestCase;	
	
//	public GMSTestCaseControl(GMSTestCaseDAO dao) {
//		this.dao = dao;
//	}
//	public GMSTestCaseControl(){}
	
	public DataModel<GMSTestCase> getListTestCase() throws ApplicationException{
		dao = new GMSTestCaseDAOHibernate();
		List<GMSTestCase> list = dao.listAll();
		listTestCase = new ListDataModel<GMSTestCase>(list);
		return listTestCase;
	}

	public GMSTestCase getTestCase() {
		return testCase;
	}

	public void setTestCase(GMSTestCase testCase) {
		this.testCase = testCase;
	}

	public String prepareInsertTestCase(){
		this.testCase = new GMSTestCase();
		return "insertTestCase";
	}

	public String prepareUpdateTestCase(){
		this.testCase = (GMSTestCase)(listTestCase.getRowData());
		return "updateTestCase";
	}
	
	public String insert() throws ApplicationException {
		dao =  new GMSTestCaseDAOHibernate();
		dao.insert(this.testCase);
		return "index";
	}

	public String update() throws ApplicationException {
		dao = new GMSTestCaseDAOHibernate();
		dao.update(this.testCase);
		return "index";
	}

	public String delete() throws ApplicationException {
		GMSTestCase testCaseTemp = (GMSTestCase)(listTestCase.getRowData());
		dao =  new  GMSTestCaseDAOHibernate();
		dao.delete(testCaseTemp);
		return "index";
	}
	
	public GMSTestCase listById(int id) throws ApplicationException {
		//falta regras
		return dao.listById(id);
	}

}
