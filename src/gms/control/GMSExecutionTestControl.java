package gms.control;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import gms.GMSExecutionTest;
import gms.data.GMSExecutionTestDAOHibernate;

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
	
	public DataModel<GMSExecutionTest> getListExecutionTest() throws ApplicationException{
		System.out.println("List"+Calendar.getInstance().getTimeInMillis());
		dao = new GMSExecutionTestDAOHibernate();
		List<GMSExecutionTest> list = dao.listAll();
		listExecutionTest = new ListDataModel<GMSExecutionTest>(list);
		return listExecutionTest;
	}
	
	public String prepareUpdateExecutionTest(){
		this.executionTest = (GMSExecutionTest)(listExecutionTest.getRowData());
		return "updateTestExecution";
	}
	
	public String insert() throws ApplicationException {
		System.out.println("Insert"+Calendar.getInstance().getTimeInMillis());
		dao =  new GMSExecutionTestDAOHibernate();
		String result = "";
		if(listById(this.executionTest.getId()) == null){
			System.out.println(this.executionTest.getId());
			dao.insert(this.executionTest);
			result = "managerExecutionTest";
		}else{
			result = "insertExecutionTest";
		}
		return result;
	}

	public String update() throws ApplicationException {
		dao = new GMSExecutionTestDAOHibernate();
		dao.update(this.executionTest);
		return "managerExecutionTest";
	}

	public String delete() throws ApplicationException {
		GMSExecutionTest executionTestTemp = (GMSExecutionTest)(listExecutionTest.getRowData());
		dao =  new  GMSExecutionTestDAOHibernate();
		dao.delete(executionTestTemp);
		return "managerExecutionTest";
	}
	
	public GMSExecutionTest listById(int id) throws ApplicationException {
		//falta regras
		return dao.listById(id);
	}
	
	public GMSExecutionTest getExecutionTest() {
		return executionTest;
	}
	
	public void setExecutionTest(GMSExecutionTest executionTest) {
		this.executionTest = executionTest;
	}
	
}
