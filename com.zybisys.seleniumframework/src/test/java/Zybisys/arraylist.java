package Zybisys;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class arraylist {
	
		
		private static final String IPV4_REGEX =
				"^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
				"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
				"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
				"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

	   public static boolean isValidInet4Address(String ip)
	   {
		   if (ip == null)
		   {
			   return false;
		   }

		   Matcher matcher = IPv4_PATTERN.matcher(ip);

		return matcher.matches();
	   }
		
		@Test
		public void alldata() throws Throwable
		{
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://dev.zybisys.com/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
			driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("trade@gmail.com");
			driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
			driver.findElement(By.xpath("//span[text()='Login']")).click();

			//this is used to click the ->button(aramark) on the ui page 
			driver.findElement(By.xpath("//div[@class='jss11']")).click();
			
			//select the location west 1 or west2
			WebElement w = driver.findElement(By.xpath("//select[@id='location-select']"));
			Select s = new Select(w);
			s.selectByIndex(0);
			
			List<WebElement> allprivateips = driver.findElements(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[4]"));
			
			System.out.println("number of private ips captured"+allprivateips.size());
			
			for(WebElement wb:allprivateips)
			{
				System.out.println(wb.getText());
				
				if(wb.getText().equals(al))
				{
					System.out.println("the private ip is there");
				}
				else
				{
					System.out.println("the private ip is not there");
				}
				
			
			}	
			
			
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData\\exportlistexcel.xlsx");
			Workbook book = WorkbookFactory.create(fis);
			Sheet sh = book.getSheet("Sheet1");
			int lastrow = sh.getLastRowNum();
			System.out.println("Total Number of Rows is:" + lastrow);
			short lastCell = sh.getRow(0).getLastCellNum();
			System.out.println("Total Number of Columns is:" + lastCell);
			
			ArrayList<String> al=new ArrayList<>();
			
	        for(int i=0;i<=lastrow;i++)
			{
		    	try
		    	{
		    		String str = sh.getRow(i).getCell(18).getStringCellValue();
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
		    	catch(Exception e)
		    	{
		    		Thread.sleep(1000);
		    	}
		    	
			}
		   
		    System.out.println(al+"/n");
		   
			}

}

