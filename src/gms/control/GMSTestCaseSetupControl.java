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
		
//		public GMSTestCaseControl(GMSTestCaseDAO dao) {
//			this.dao = dao;
//		}
//		public GMSTestCaseControl(){}
		
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

		public String prepareInsertTestCaseSetup(){
			this.testCaseSetup = new GMSTestCaseSetup();
			return "insertTestCaseSetup";
		}

		public String prepareUpdateTestCaseSetup(){
			this.testCaseSetup = (GMSTestCaseSetup)(listTestCaseSetup.getRowData());
			return "updateTestCaseSetup";
		}
		
		public String insert() throws ApplicationException {
			dao =  new GMSTestCaseSetupDAOHibernate();
			dao.insert(this.testCaseSetup);
			return "index";
		}

		public String update() throws ApplicationException {
			dao = new GMSTestCaseSetupDAOHibernate();
			dao.update(this.testCaseSetup);
			return "index";
		}

		public String delete() throws ApplicationException {
			GMSTestCaseSetup testCaseSetupTemp = (GMSTestCaseSetup)(listTestCaseSetup.getRowData());
			dao =  new  GMSTestCaseSetupDAOHibernate();
			dao.delete(testCaseSetupTemp);
			return "index";
		}
		
		public GMSTestCaseSetup listById(int id) throws ApplicationException {
			//falta regras
			return dao.listById(id);
		}
}