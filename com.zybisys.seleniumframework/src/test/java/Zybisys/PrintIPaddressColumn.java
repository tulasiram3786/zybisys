package Zybisys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintIPaddressColumn {
	
	@Test
    public void excelAnduiComparision() throws IOException 
    {

		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData/Vm dc2.xlsx");
	
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(0);
		int column_count=row.getLastCellNum();
		System.out.println("column count is"+column_count);
		
		XSSFCell cell=null;
		
		for(int i=0;i<column_count;i++)
		{
			cell=row.getCell(i);
			String Column_Name=cell.getStringCellValue();
			System.out.println("column name is "+Column_Name);
		}
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			row=sheet.getRow(i);
		
		    for(int j=0;i<row.getLastCellNum();j++)
		    {
			cell=row.getCell(i);
			String mycellvalue=cell.getStringCellValue();
			System.out.println("my cell value:"+mycellvalue);
		    }
		}
}       

}
    

