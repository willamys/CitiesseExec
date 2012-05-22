
import junit.framework.TestCase;

import java.io.IOException;

import spreadsheets.OfflineSpreadsheet;
import spreadsheets.exceptions.SpreadsheetExceptions;

import junit.framework.TestCase;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class TestOfflineSpreadsheet extends TestCase {

	OfflineSpreadsheet spread = new OfflineSpreadsheet();
	String nomeEnd = "C:\\Users\\Artur Jr\\workspace\\Plugins Planilha\\";
	String nomePlan = "planilha.xlsx";

	Workbook wb;
	WritableWorkbook writeWb;
	public TestOfflineSpreadsheet(){


	}
	public void testWriteSpread() throws SpreadsheetExceptions{
		try {
			try {
				System.out.println(nomeEnd+nomePlan);
				wb = spread.getWorkbook(nomeEnd+nomePlan);

			} catch (SpreadsheetExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writeWb = spread.getWritableWorkbook(wb,nomeEnd+nomePlan);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			spread.writeDataCell(writeWb, 0, 1, 5, "Nathyyyyyyy");
                        //spread.addSheet(writeWb, "Etaa");
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void testCreatePlanilha(){
//		String nomeEnd = "C:\\Users\\bhfw64\\Documents\\Development\\PlanilhaTeste\\";
//		String nomePlan = "teste02.xls";
//		try {
//			assertEquals(true, spread.createSpreadsheet(nomeEnd, nomePlan, "gms"));
//		} catch (WriteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public void testCreatSheet(){
//		String sheetName = "gms2";
//		try {
//			assertTrue(spread.addSheet(sheetName));
//		} catch (WriteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public void testSetSpreadSheet(){
//		String nomeEnd = "C:\\Users\\bhfw64\\Documents\\Development\\PlanilhaTeste\\";
//		String nomePlan = "Google_Software_Submission_Checklist_5.5.1-112_SLU-43M_Vivo_BR.xls";
//		String newName = "Google_Software_Submission_Checklist_5.5.1-112_SLU-43M_Vivo_BR22.xls";
//		try {
//			try {
//				try {
//					assertTrue(spread.setSpreadsheet(nomeEnd, nomePlan,newName));
//				} catch (BiffException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (WriteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void testReadCell(){
//		String nomeEnd = "C:\\Users\\bhfw64\\Documents\\Development\\PlanilhaTeste\\";
//		String nomePlan = "Google_Software_Submission_Checklist_5.5.1-112_SLU-43M_Vivo_BR.xls";
//
//		try {
//			assertEquals("Instructions:", spread.readCell(nomeEnd+nomePlan, 0, 0, 0));
//		} catch (BiffException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


}
