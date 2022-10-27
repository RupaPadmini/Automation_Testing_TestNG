package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	public static Workbook book;
	public static Sheet sheet1;
	public static Object[][] readdata(String Sheetname) {
		FileInputStream file = null;
		
		try {
			file = new FileInputStream("C:\\Users\\ravik\\Desktop\\Testing\\AutomationTesting\\src\\test\\java\\testdata\\Details.xlsx");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//There are two types of workbooks:
			//HSSF -- untill 2003 -- older version
			//XSSF -- from 2007 to till date
		book = WorkbookFactory.create(file);
	}
		catch(IOException a) {
			a.printStackTrace();
		}
		sheet1 = book.getSheet(Sheetname);
		Object[][] data = new Object[sheet1.getLastRowNum()][sheet1.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet1.getLastRowNum(); i++) {
			
			for(int k=0; k<sheet1.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet1.getRow(i+1).getCell(k).toString();
			
			}
		}
		return data;
	
	}
}
