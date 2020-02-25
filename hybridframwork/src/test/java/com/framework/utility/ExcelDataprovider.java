/**
 * 
 */
package com.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author karthik
 *
 */
public class ExcelDataprovider {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ExcelDataprovider() {
		File source=new File("./testdata/data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(source);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("cannot able to read exceldataprovider");
		}
	}
	
	
	public String getStringdata(String sheetname,int rowno,int cellno) {
		return wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
	}
	
	public String getStringdata(int sheetindex,int rowno,int cellno) {
		return wb.getSheetAt(sheetindex).getRow(rowno).getCell(cellno).getStringCellValue();
	}
	
	public double getNumericdata(int sheetindex,int rowno,int cellno) {
		return wb.getSheetAt(sheetindex).getRow(rowno).getCell(cellno).getNumericCellValue();
	}
}
