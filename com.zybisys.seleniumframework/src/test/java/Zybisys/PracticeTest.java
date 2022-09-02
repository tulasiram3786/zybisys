package Zybisys;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.zybisys_GenericUtility.BaseClass;
import com.zybisys_ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.zybisys_GenericUtility.ListenersImplementationClass.class)
//@Listeners(com.Dalvkot.vsshhms_GenericUtility.ListenerImp.class)
public class PracticeTest extends BaseClass{
	
	
	
	@Test
	public void login()
	{
	    WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("abdul@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@321");
		Assert.assertEquals(true, false);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	
		driver.findElement(By.xpath("//div[@class='jss11']")).click();
		
//		WebElement wb=driver.findElement(By.xpath("//div[text()='Instances']/ancestor::div[@class='sc-jgPyTC fuJtcf']"));
//		System.out.println(wb.getText());
		
		WebElement w=driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s=new Select(w);
		s.selectByIndex(1);
		
	}

}













