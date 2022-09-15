package Zybisys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class rajendra extends ipv4 {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData/Vm dc2 -Testing.xlsx");
    	Workbook book = WorkbookFactory.create(fis);
    	Sheet sh = book.getSheet("Sheet1");
    	int lastrow = sh.getLastRowNum();
    	//System.out.println("Total Number of Rows is:" + lastrow);
    	short lastCell = sh.getRow(0).getLastCellNum();
    	//System.out.println("Total Number of Columns is:" + lastCell);
    	
    	ArrayList<String>all=new ArrayList<>(); 
		
		
		 for(int i=0;i<=lastrow;i++)
	    	{
			 try {
	    		String str = sh.getRow(i).getCell(0).getStringCellValue();
	    		//System.out.println(str);
	    		
	    	    String[] arrOfStr = str.split(",", 0);
	 	        
	 	        for (int j = 0; j < arrOfStr.length; j++)
	 	        {
	 	           
	 	            if (isValidInet4Address(arrOfStr[j].trim())) 
	 	            {
	 	                //System.out.print("The IP address " + arrOfStr[j] + " is valid v4ip\n");
	 	                all.add(arrOfStr[j]); 
	 	             
	 	            }
	 	            
	 	          
	 	            else
	 	            {
	 	               //System.out.print("The IP address " + arrOfStr[j] + " it is a v6 ip\n"); 
	 	            }
	 	          
	    	    }
	 	     
	 	       // System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	 	       
	            
	 	     } 
			 
			 catch(Exception e) {
		 
	 	     }
	    	
			
	    	}
		 
		 
	}
}
	



