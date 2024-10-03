package com.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Utilities {
	
	WebDriver driver;
	public static final int WaitTime = 10;
	public static final int pageloadTime=10;
	
	public static String newEmail() {
		Date date = new Date();
		String email= date.toString().replace(" ", "-").replace(":", "-");
		return "masud3386"+email+"@yahoo.com";
	}
	
	public static Object[][] gettestData(String sheetName) {
		File file=new File("./TestData/Worksheet.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		XSSFSheet sheet = book.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int col=sheet.getRow(0).getLastCellNum();
		Object data[][]=new Object[rows-1][col];
		for(int i=0;i<rows-1;i++) {
			
		for(int j=0;j<col;j++) {
			DataFormatter formatter=new DataFormatter();
			data[i][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
			
			}
			
		}
		
		
		try {
			book.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return data;
	}
	
	
	
			
		}
	

	
	

