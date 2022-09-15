package Zybisys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _08_aaaaa {
	
	@Test(priority=1)
	public void ui()
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
		
		
		List<WebElement> allprivateips = driver.findElements(By.xpath("//div[contains(@class,'coc-dashboard-row')]/following::p[@class='MuiTypography-root MuiTypography-body2'][2]"));
		
		for(WebElement wb:allprivateips)
		{
			System.out.println(wb.getText());
		}
		List<WebElement>first=driver.findElements(By.xpath("//div[contains(@class,'coc-dashboard-row')]/following::p[@class='MuiTypography-root MuiTypography-body2'][1]"));
		for(WebElement d:first)
		{
			
			for(int i=0; i<=2;i++){
				  try{
					  d.click();
				     break;
				  }
				  catch(Exception e){
				     System.out.print(e.getMessage());
				  }
				}
			
			JavascriptExecutor executor = (JavascriptExecutor)driver; 
			executor. executeScript("arguments[0]. click();", d);
			List<WebElement>test=driver.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr/td"));
			for(WebElement f:test)
			{
				
				System.out.println(f.getText());
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
//		driver.findElement(By.xpath("//p[text()='zebu-mfeeder-srv01']")).click();
//
//		List<WebElement> text = driver.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr[*]/td[*]"));
//    	for(WebElement table:text)
//    	{
//    		System.out.println(table.getText());
//    	}
//		List<WebElement> instancename = driver.findElements(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[3]"));
//        for(WebElement ins:instancename)
//        {
//        	ins.click();
//        	List<WebElement> text = driver.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr[*]/td[*]"));
//        	for(WebElement table:text)
//        	{
//        		System.out.println(table.getText());
//        	}
//        }
		
//		WebElement wb=driver.findElement(By.xpath("//p[text()='10.192.2.9']"));
//		
//		System.out.println("========");
//		driver.findElement(By.xpath("//p[text()='zebu-mfeeder-srv01']")).click();
//		List<WebElement> text = driver.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr[*]/td[*]"));
//    	for(WebElement table:text)
//    	{
//    		System.out.println(table.getText());
//    	}
		
}
}
