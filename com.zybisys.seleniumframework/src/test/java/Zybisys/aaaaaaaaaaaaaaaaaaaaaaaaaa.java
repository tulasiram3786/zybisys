package Zybisys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class aaaaaaaaaaaaaaaaaaaaaaaaaa {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData/Vm dc2 -Testing.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet("Sheet1");
		//int lastrow = sh.getLastRowNum();
		//System.out.println("Total Number of Rows is:" + lastrow);
		//short lastCell = sh.getRow(0).getLastCellNum();
		//System.out.println("Total Number of Columns is:" + lastCell);
		String value = sh.getRow(2).getCell(0).getStringCellValue();
	    String []a=value.split(",");
	    
		System.out.println(value);
		System.out.println(a[0]);
		System.out.println(a[1]);
		String s1="10.193.7.131";
		if(s1.contains(a[0]))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("flase");
		}
	}
}
