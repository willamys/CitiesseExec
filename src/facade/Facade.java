package facade;

import gms.GMSTestCase;
import gms.GMSWorkFlow;
import gms.control.GMSTestCaseControl;
import gms.control.GMSWorkFlowControl;
import gms.data.GMSTestCaseDAOHibernate;
import gms.data.GMSWorkflowDAOHibernate;
import java.util.List;

import javax.faces.model.DataModel;

import util.ApplicationException;

public class Facade {
/*
	private static Facade instance;

	private GMSTestCaseControl gmsTestCaseControl;
	private GMSTestCaseDAO gmsTestCaseDAO;
	
	private GMSWorkFlowControl gmsWorkflowControl;
	private GMSWorkflowDAO gmsWorkflowDAO;
		
	private Facade() {
		gmsTestCaseDAO = new GMSTestCaseDAOHibernate();
	//	gmsTestCaseControl = new GMSTestCaseControl(gmsTestCaseDAO);
		
		gmsWorkflowDAO = new GMSWorkflowDAOHibernate();
		gmsWorkflowControl = new GMSWorkFlowControl(gmsWorkflowDAO);
	}

	public static Facade getInstance() {
		if (instance == null) {
			instance = new Facade();
		}
		return instance;
	}

	public String insertGMSTestCase() throws ApplicationException {
		return gmsTestCaseControl.insert();
	}
	public String updateGMSTestCase() throws ApplicationException {
		return gmsTestCaseControl.update();
	}
	public String deleteGMSTestCase() throws ApplicationException {
		return gmsTestCaseControl.delete();
	}
	public DataModel<GMSTestCase> listAllGMSTestCase() throws ApplicationException {
		return gmsTestCaseControl.getListTestCase();
	}
	public GMSTestCase listByidGMSTestCase(int id) throws ApplicationException {
		return gmsTestCaseControl.listById(id);
	}
	
	public void insertGMSWorkFlow(GMSWorkFlow t) throws ApplicationException {
		gmsWorkflowControl.insert(t);
	}
	public void updateGMSWorkFlow(GMSWorkFlow t) throws ApplicationException {
		gmsWorkflowControl.update(t);
	}
	public void deleteWorkFlowtCase(GMSWorkFlow t) throws ApplicationException {
		gmsWorkflowControl.delete(t);
	}
	public List<GMSWorkFlow> listAllGMSWorkFlow() throws ApplicationException {
		return gmsWorkflowControl.listAll();
	}
	public GMSWorkFlow listByidGMSWorkflow(int id) throws ApplicationException {
		return gmsWorkflowControl.listById(id);
	}
*/
}
