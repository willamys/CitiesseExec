package gms.control;

import java.util.List;
import gms.GMSTestCaseSetup;
import gms.data.GMSTestCaseSetupDAOHibernate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import util.ApplicationException;

@ManagedBean
@SessionScoped
public class GMSTestCaseSetupControl{

	private GMSTestCaseSetupDAOHibernate dao;
	private GMSTestCaseSetup testCaseSetup =  new GMSTestCaseSetup();
	private DataModel<GMSTestCaseSetup> listTestCaseSetup;	

	public DataModel<GMSTestCaseSetup> getListTestCaseSetup() throws ApplicationException{
		dao = new GMSTestCaseSetupDAOHibernate();
		List<GMSTestCaseSetup> list = dao.listAll();
		listTestCaseSetup = new ListDataModel<GMSTestCaseSetup>(list);
		return listTestCaseSetup;
	}

	public GMSTestCaseSetup getTestCaseSetup() {
		return testCaseSetup;
	}

	public void setTestCaseSetup(GMSTestCaseSetup testCaseSetup) {
		this.testCaseSetup = testCaseSetup;
	}

	public String prepareUpdateTestCaseSetup(){
		this.testCaseSetup = (GMSTestCaseSetup)(listTestCaseSetup.getRowData());
		return "updateTestCaseSetup";
	}

	public String insert() throws ApplicationException {
		dao =  new GMSTestCaseSetupDAOHibernate();
		String result = "";
		if(listById(this.testCaseSetup.getId()) != null){
			System.out.println(this.testCaseSetup.getId());
			dao.insert(this.testCaseSetup);
			result = "managerTestCaseSetup";
		}else{
			result = "insertTestCase";
		}
		return result;
	}

	public String update() throws ApplicationException {
		dao = new GMSTestCaseSetupDAOHibernate();
		System.out.println(this.testCaseSetup.getId());
		dao.update(this.testCaseSetup);

		return "managerTestCaseSetup";
	}

	public String delete() throws ApplicationException {
		GMSTestCaseSetup testCaseSetupTemp = (GMSTestCaseSetup)(listTestCaseSetup.getRowData());
		dao =  new  GMSTestCaseSetupDAOHibernate();
		dao.delete(testCaseSetupTemp);
		return "managerTestCaseSetup";
	}

	public GMSTestCaseSetup listById(int id) throws ApplicationException {
		//falta regras
		return dao.listById(id);
	}
}