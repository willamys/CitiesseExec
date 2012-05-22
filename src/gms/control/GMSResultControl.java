package gms.control;

import gms.GMSResult;
import gms.data.GMSResultDAOHibernate;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import util.ApplicationException;

@ManagedBean
@SessionScoped
public class GMSResultControl {
	
	private GMSResultDAOHibernate dao;
	private GMSResult result = new GMSResult();
	private DataModel<GMSResult> listResult;	
	
	public DataModel<GMSResult> getListResult() throws ApplicationException{
		dao = new GMSResultDAOHibernate();
		List<GMSResult> list = dao.listAll();
		
//		int tamanho = list.size();
//		for( int i = 0; i<tamanho; i++)
//			System.out.println("\nID: "+list.get(i).getId()+"\nResult: "+list.get(i).getResult());
//		
		listResult = new ListDataModel<GMSResult>(list);
		return listResult;
	}

	public GMSResult getResult() {
		return result;
	}

	public void setResult(GMSResult result) {
		this.result = result;
	}

	public String prepareUpdateResult(){
		this.result = (GMSResult)(listResult.getRowData());
		return "updateResult";
	}
	
	public String insert() throws ApplicationException {
		dao =  new GMSResultDAOHibernate();
		String result = "";
		if(listById(this.result.getId()) == null){
			System.out.println(this.result.getId());
			dao.insert(this.result);
			result = "managerResult";
		}else{
			result = "insertResult";
		}
		return result;
	}

	public String update() throws ApplicationException {
		dao = new GMSResultDAOHibernate();
		dao.update(this.result);
		return "managerResult";
	}

	public String delete() throws ApplicationException {
		GMSResult resultTemp = (GMSResult)(listResult.getRowData());
		dao =  new  GMSResultDAOHibernate();
		dao.delete(resultTemp);
		return "managerResult";
	}
	
	public GMSResult listById(int id) throws ApplicationException {
		//falta regras
		return dao.listById(id);
	}

}
