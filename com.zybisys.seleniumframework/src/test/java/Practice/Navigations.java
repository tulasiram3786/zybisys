package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://snapdeal.com");
		driver.navigate().to("http://amazon.com");
		
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.navigate().refresh();
	}

}
