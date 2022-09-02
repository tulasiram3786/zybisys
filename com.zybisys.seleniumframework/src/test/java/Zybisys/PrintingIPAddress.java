package Zybisys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class PrintingIPAddress {
	@Test
	public void excel() throws Exception
	{
	
	FileInputStream fis = new FileInputStream("./src/test/resources/CommonData/Vm dc2.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sh = book.getSheet("Sheet1");
	int lastrow = sh.getLastRowNum();
	System.out.println("Total Number of Rows is:" + lastrow);
	short lastCell = sh.getRow(0).getLastCellNum();
	System.out.println("Total Number of Columns is:" + lastCell);
	
	for(int i=0;i<=lastrow;i++)
	{
		String str = sh.getRow(i).getCell(22).getStringCellValue();
		System.out.println(str);
	}
	
	
	
	}
}
