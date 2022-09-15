package Zybisys;

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

public class _08_uiandExcel extends ipv4 {
	
	
	@Test(priority=1)
	public void ui() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("zebu@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		//this is used to click the instance name on the ui page 
		driver.findElement(By.xpath("//div[@class='jss11']")).click();
		
		//select the location west 1 or west2
		WebElement w = driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s = new Select(w);
		s.selectByIndex(0);
	
		List<WebElement> ist=driver.findElements(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[4]"));
		  ArrayList<String>ip=new ArrayList<>();
	      for(WebElement w2:ist)
	      {
	    	  ip.add(w2.getText());
	 
	      }
	      System.out.print(ip);
//	     ipv4 rajendra=new ipv4();
//	     System.out.println(rajendra.all[0]);
	     
	    	 
	     
	      
	      
	}
}
		      
	
		

