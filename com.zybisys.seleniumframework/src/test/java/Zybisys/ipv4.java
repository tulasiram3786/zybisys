package Zybisys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ipv4 {

	
	    private static final String IPV4_REGEX =
						"^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
						"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
						"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
						"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

		private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);
		
		public static boolean isValidInet4Address(String ip)
		{
			if (ip == null) {
				return false;
			}

			Matcher matcher = IPv4_PATTERN.matcher(ip);

			return matcher.matches();
		}
		
	    public static void main(String[] args) throws EncryptedDocumentException, IOException {
	    	
	    	
	    	FileInputStream fis = new FileInputStream("./src/test/resources/CommonData/Vm dc2.xlsx");
	    	Workbook book = WorkbookFactory.create(fis);
	    	Sheet sh = book.getSheet("Sheet1");
	    	int lastrow = sh.getLastRowNum();
	    	System.out.println("Total Number of Rows is:" + lastrow);
	    	short lastCell = sh.getRow(0).getLastCellNum();
	    	System.out.println("Total Number of Columns is:" + lastCell);
	    	
	    	ArrayList<String>al=new ArrayList<>();
	    	
	        for(int i=0;i<=lastrow;i++)
	    	{
	    		String str = sh.getRow(i).getCell(22).getStringCellValue();
	    		System.out.println(str);
	    		
	    	    String[] arrOfStr = str.split(",", 0);
	 	        
	 	        for (int j = 0; j < arrOfStr.length; j++)
	 	        {
	 	           
	 	            if (isValidInet4Address(arrOfStr[j].trim())) 
	 	            {
	 	                System.out.print("The IP address " + arrOfStr[j] + " is valid v4ip\n");
	 	                al.add(arrOfStr[j]); 
	 	             
	 	            }
	 	            
	 	          
	 	            else
	 	            {
	 	               System.out.print("The IP address " + arrOfStr[j] + " it is a v6 ip\n"); 
	 	            }
	 	           
	 	            
	    	    }
	 	        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	 	        
	 	      
	 	        
	 	    }
	    	 for(String a:al)
	 	     {
	 	    		System.out.println(a.trim()+"  it is a valid v4 ip");
	 	     }
	    	
	     }
	}



