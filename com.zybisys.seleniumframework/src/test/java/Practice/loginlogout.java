package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class loginlogout {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://dev.zybisys.com/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("trade@gmail.com");
	driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");

	driver.findElement(By.xpath("//span[text()='Login']")).click();
	Thread.sleep(2000);
	
	driver.get("https://mail.google.com/mail/u/0/#inbox");
//	driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[2]")).click();
//	driver.findElement(By.xpath("//a[@href='/logout']")).click();
	
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ESCAPE);
	r.keyRelease(KeyEvent.VK_ESCAPE);
	Thread.sleep(3000);
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_W);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_W);


}
}