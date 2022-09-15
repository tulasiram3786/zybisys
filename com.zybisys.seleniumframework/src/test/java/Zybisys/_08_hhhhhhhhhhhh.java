package Zybisys;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class will print the all excel data in line by line
 * @author Tulasiram
 *
 */

public class _08_hhhhhhhhhhhh {
	
	private static final String IPV4_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

	public static boolean isValidInet4Address(String ip) {
		if (ip == null) 
		{
			return false;
		}

		Matcher matcher = IPv4_PATTERN.matcher(ip);

		return matcher.matches();
	}
	@Test(priority=1)
	public void ui()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("trade@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		//this is used to click the instance name on the ui page 
		driver.findElement(By.xpath("//div[@class='jss11']")).click();
		
		//select the location west 1 or west2
		WebElement w = driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s = new Select(w);
		s.selectByIndex(0);
//		JavascriptExecutor j = (JavascriptExecutor)driver;
//	       j.executeScript("window.scrollBy(0,500)");
		
		
		
		try {
		List<WebElement> ist=driver.findElements(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[4]"));
		
	    for(WebElement w2:ist)
	    {
	    	
//	       String privateip = w2.getText();
//	       System.out.println(privateip);
	       System.out.println(w2.getText());
	       
	       List<WebElement> instancename = driver.findElements(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[3]"));
	        for(WebElement ins:instancename)
	        {
	        	ins.click();
	        	ArrayList<String> coctabledata = new ArrayList<>();
	        	List<WebElement> text = driver.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr[*]/td[*]"));
	        	for(WebElement table:text)
	        	{
	        		//System.out.println(table.getText());
	        		coctabledata.add(table.getText());
	        		
	        		
	        	}
	        	WebElement Element = driver.findElement(By.xpath("(//div[text()='Instance'])[2]"));
	        	JavascriptExecutor js = (JavascriptExecutor) driver;
	        	 js.executeScript("arguments[0].scrollIntoView();", Element);
	        	System.out.println(coctabledata);
	        	
	        	
	        	
	        //	Robot robot = new Robot();

	            // Scroll Down using Robot class
//	            robot.keyPress(KeyEvent.VK_PAGE_CONTROL);
//	            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

	            // Scroll Up using Robot class
//	            robot.keyPress(KeyEvent.VK_PAGE_UP);
//	            robot.keyRelease(KeyEvent.VK_PAGE_UP);
//	        	
	        }
	    }
		}catch(Exception e) {
			
		}
	}
	
	@Test(priority=2)
	public void excel() throws IOException
	{
		String excelFilePath="./src/test/resources/CommonData/Vm dc2 -Testing.xlsx";
		
		FileInputStream fis=new FileInputStream(excelFilePath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();
		
		
		for(int r=0;r<=rows;r++)
		{
			try {
		    
			XSSFRow row = sheet.getRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell = row.getCell(c);
				
				
				//System.out.println(cell.getStringCellValue());
				switch(cell.getCellType())
				{
				case STRING:System.out.println(cell.getStringCellValue());
				break;
				case NUMERIC:System.out.println(cell.getNumericCellValue());
				break;
				case BOOLEAN:System.out.println(cell.getBooleanCellValue());
				break;
				default:
					break;
				}
				System.out.print(" - ");
			}
			System.out.println();
			System.out.println();
		}catch(Exception e) {
		}
			
		}
		
	}
	
	
	   
		
	    
		}

 
