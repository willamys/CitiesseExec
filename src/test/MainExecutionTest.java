package test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.faces.model.DataModel;

import util.ApplicationException;
import gms.GMSExecutionTest;
import gms.GMSTestCase;
import gms.GMSTestCaseSetup;
import gms.GMSUser;
import gms.control.GMSExecutionTestControl;
import gms.control.GMSTestCaseControl;
import gms.control.GMSTestCaseSetupControl;
import gms.data.GMSExecutionTestDAOHibernate;
import gms.data.GMSTestCaseDAOHibernate;
import gms.data.GMSTestCaseSetupDAOHibernate;

public class MainExecutionTest {
	/*
	public static void main(String[] args) {
			GMSTestCaseControl gms = new GMSTestCaseControl();
			GMSTestCaseDAOHibernate dao = new  GMSTestCaseDAOHibernate();
		try {
			GMSTestCase t =  new GMSTestCase();
			t.setId(69);
			t.setDescriptionSteps("dasdsadasdsa");
			t.setTestCaseName("testcase 69");
			dao.insert(t); 

			//t.setDescriotionSteps("mudei");
			//dao.delete(t);

			///gms.insert();
			DataModel<GMSTestCase> list = gms.getListTestCase();
			GMSTestCase g = (GMSTestCase)list.getRowData();

			System.out.println(list.getRowCount());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 */
	public static void main(String[] args) throws ParseException {
		GMSExecutionTestControl gms = new GMSExecutionTestControl();
		GMSExecutionTestDAOHibernate dao = new  GMSExecutionTestDAOHibernate();
		try {
			//GMSUser usuario = new GMSUser(77,"Fulano","senha","user");
			GMSExecutionTest t =  new GMSExecutionTest();
			t.setId(77);
			t.setUser("usuario");
			t.setStartDate("19/12/2006");
			t.setFinishDate("19/15/2006");
			System.out.println(t.getId());
			//System.out.println(t.getUser().getLogin() + "\n" + t.getUser().getPassword());
			System.out.println(t.getStartDate());
			System.out.println(t.getFinishDate());
			System.out.println("################");
			dao.insert(t); 

			//t.setDescriotionSteps("mudei");
			//dao.delete(t);

			///gms.insert();
			DataModel<GMSExecutionTest> list = gms.getListExecutionTest();
			GMSExecutionTest g = (GMSExecutionTest)list.getRowData();

			System.out.println(list.getRowCount());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
