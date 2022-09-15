package Zybisys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData/Vm dc2 -Testing.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum();
		
		HashMap<String,String>data=new HashMap<String,String>();
		
		for(int r=0;r<=rows;r++)
		{
			String State = sheet.getRow(r).getCell(0).getStringCellValue();
			String Capacity_HDD = sheet.getRow(r).getCell(1).getStringCellValue();
			String OS = sheet.getRow(r).getCell(2).getStringCellValue();
			String Capacity_RAM = sheet.getRow(r).getCell(3).getStringCellValue();
			String Capacity_CPU = sheet.getRow(r).getCell(4).getStringCellValue();
			String NICs = sheet.getRow(r).getCell(5).getStringCellValue();
			String Uptime = sheet.getRow(r).getCell(6).getStringCellValue();
			String IPAddress = sheet.getRow(r).getCell(7).getStringCellValue();
			String VMwareToolsRunningStatus = sheet.getRow(r).getCell(8).getStringCellValue();
			String Hostname = sheet.getRow(r).getCell(9).getStringCellValue();
			data.put(State, Capacity_HDD);
		}
	}

}
