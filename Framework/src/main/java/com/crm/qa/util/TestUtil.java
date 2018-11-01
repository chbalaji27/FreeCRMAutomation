package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public void switchToFrame() {
	driver.switchTo().frame("mainpanel");
}

	public final static int RESPONSE_CODE_200=200;
	public final static int RESPONSE_CODE_201=201;
	public final static int RESPONSE_CODE_400=400;
	public final static int RESPONSE_CODE_401=401;
	
	public final static String WeatherSheetName="WeatherInfo";
	
	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Balaji\\eclipse-workspace\\Framework\\"
			+ "src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	
public static Object[][] getTestData(String sheetName){
		
		FileInputStream file = null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			try {
				book=WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
			}
		
		

	}
