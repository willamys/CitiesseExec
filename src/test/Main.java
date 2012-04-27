package test;

import java.util.Iterator;

import javax.faces.model.DataModel;

import util.ApplicationException;
import gms.GMSTestCase;
import gms.control.GMSTestCaseControl;
import gms.data.GMSTestCaseDAOHibernate;

public class Main {

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
}
