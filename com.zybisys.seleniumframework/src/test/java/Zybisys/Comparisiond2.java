package Zybisys;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zybisys_GenericUtility.BaseClass;
import com.zybisys_GenericUtility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Comparisiond2 extends BaseClass {
	@Test
	public void compare() throws EncryptedDocumentException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("kk@bnrsecurities.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		
		driver.findElement(By.xpath("//div[@class='jss11']")).click();
		WebElement w=driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s=new Select(w);
		s.selectByIndex(1);
		
//		String str=driver.findElement(By.xpath("//p[text()='10.193.4.7']")).getText();
//		System.out.println(str);
		
	    String str1=driver.findElement(By.xpath("//p[text()='mnmv-r176-bnrathi-ka-app-dmz']")).getText();
		System.out.println(str1);
		
     	ExcelUtility eutil=new ExcelUtility();
//    	System.out.println(eutil.getDataFromExcel("Sheet1", 7, 0));
//    	
//    	if(str.contains(eutil.getDataFromExcel("Sheet1", 7, 0)))
//    	{
//    		Assert.assertTrue(true);
//    		System.out.println("equals");
//   		}
//    	else
//    	{
//    		System.out.println("not equlas");
//    	}
     	
     	if(str1.contains(eutil.getDataFromExcel("Sheet1", 10, 0)))
     	{
     		Assert.assertTrue(true);
     		System.out.println("equal");
     	}
     	else
     	{
     		System.out.println("not equal");
     	}
				
		int lastrow=eutil.getRowCount("Sheet1");	
		System.out.println(lastrow);

		
	}

}
