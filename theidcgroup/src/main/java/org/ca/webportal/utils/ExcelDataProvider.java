package org.ca.webportal.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ExcelDataProvider {

	@Test
	public String[][] readExceldata(String filename) throws IOException {
		
		XSSFWorkbook book=new XSSFWorkbook("data/"+filename+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum(); 	// Step 3: Go to the first row
		//System.out.println("Row Count " + rowCount);
		XSSFRow firstRow = sheet.getRow(0);
		int colCount = firstRow.getLastCellNum();
		//System.out.println("Col Count " + colCount);
		// Create data array to send all data (except header) - row count, col count
		String[][] data = new String[rowCount][colCount];
		for (int j = 1; j <= rowCount; j++) {
			XSSFRow row = sheet.getRow(j);
			for (int i = 0; i < colCount; i++) {
				XSSFCell cell = row.getCell(i); 
				String value = cell.getStringCellValue();
				data[j-1][i]= value;
				//System.out.println(value);
			}	}
		book.close(); 		
		return data;
		
	}

}