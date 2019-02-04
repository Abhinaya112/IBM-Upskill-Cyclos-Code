package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ContactPayBean;
import com.training.bean.LoginBean;
import com.training.bean.MemberPayBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	// new code for member payment
	

	@DataProvider(name = "db-inputs1")
	public Object [][] getDBData1() {

		List<MemberPayBean> list = new ELearningDAO().getLogins1(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(MemberPayBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getmemberUsername(); 
			obj[1] = temp.getamount(); 
			obj[2]=temp.gettransactionType();
		    obj[3]=temp.getdescription();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	// Code for Contact payment
	
	@DataProvider(name = "db-inputs2")
	public Object [][] getDBData2() {

		List<ContactPayBean> list = new ELearningDAO().getLogins2(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ContactPayBean temp : list){
			Object[]  obj = new Object[3]; 
			obj[0] = temp.getname(); 
			obj[1] = temp.getamount(); 
		    obj[2]=temp.getdescription();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/AbhinayaM/Desktop/Upskill/Project/ExcelSheets/Consolidated.xlsx";
		int SheetNum=0;
		return new ApachePOIExcelRead().getExcelContent(fileName, SheetNum); 
	}
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData1(){
		String fileName ="C:/Users/AbhinayaM/Desktop/Upskill/Project/ExcelSheets/Consolidated.xlsx";
		int SheetNum=1;
		return new ApachePOIExcelRead().getExcelContent(fileName, SheetNum); 
	}
	
	@DataProvider(name = "excel-inputs3")
	public Object[][] getExcelData3(){
		String fileName ="C:/Users/AbhinayaM/Desktop/Upskill/Project/ExcelSheets/Consolidated.xlsx";
		int SheetNum=2;
		return new ApachePOIExcelRead().getExcelContent(fileName, SheetNum); 
	}
	
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
