package test;

import gms.GMSResult;
import gms.control.GMSResultControl;
import gms.data.GMSResultDAOHibernate;
import java.text.ParseException;
import javax.faces.model.DataModel;
import util.ApplicationException;

public class MainResultTest {

	public static void main(String[] args) throws ParseException {

		GMSResultControl control = new GMSResultControl();
		GMSResultDAOHibernate dao = new  GMSResultDAOHibernate();

		try {

			int quantTest = 10;

			for( int i=0; i<quantTest; i++ ){

				GMSResult result =  new GMSResult();

				result.setId( i + (int) (Math.random()*1000) );
				result.setIdTestCase( 100 + (int) (Math.random()*1000) );
				if(i%2==0){
					result.setResult("yes");
					result.setComment("Teste realizado com sucesso.");
				}
				else{
					result.setResult("fail");
					result.setComment("Rede não identificada.");
				}
				dao.insert(result); 
			}

			DataModel<GMSResult> list = control.getListResult();
			GMSResult lr = (GMSResult)list.getRowData();

			System.out.println(list.getRowCount());

		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}