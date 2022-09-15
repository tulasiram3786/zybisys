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

public class CaputuringCocData {
	
	 @Test
	    public void excelAnduiComparision() throws Throwable
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
	
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	        try {
		List<WebElement> ist=driver.findElements(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[4]"));
		
		    for(WebElement w2:ist)
		    {
		    	
		       String privateip = w2.getText();
		       System.out.println(privateip);
		    }
		        List<WebElement> instancename = driver.findElements(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[3]"));
		        for(WebElement ins:instancename)
		        {
		        	ins.click();
		        	
		        	List<WebElement> text = driver.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr[*]/td[*]"));
		        	for(WebElement table:text)
		        	{
		        		System.out.println(table.getText());
		        	}
		        }
		        
		    
		    }
		    
	        
	        catch(Exception e)
	        {
		    	Thread.sleep(500);
	        }
}
}
