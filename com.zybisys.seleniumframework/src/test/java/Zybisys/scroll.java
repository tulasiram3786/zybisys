package Zybisys;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scroll {

	@Test(priority = 1)
	public void ui() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("trade@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		// this is used to click the instance name on the ui page
		driver.findElement(By.xpath("//div[@class='jss11']")).click();

		// select the location west 1 or west2
		WebElement w = driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s = new Select(w);
		s.selectByIndex(0);

		List<WebElement> allprivateips = driver.findElements(By
				.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[4]"));
		for (WebElement wb : allprivateips) {
			System.out.println(wb.getText());

		}

		ArrayList<ArrayList<String>> cocFinalArr = new ArrayList<>();
		List<WebElement> allinstancenames = driver.findElements(By
				.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[3]"));
		for (WebElement wb1 : allinstancenames) {
			wb1.click();
			Thread.sleep(500);
			List<WebElement> tabledata = driver.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr[*]/td[*]"));
			Thread.sleep(500);
			ArrayList<String> seven = new ArrayList<>();
			try {
				for (WebElement wb3 : tabledata) {
					Thread.sleep(500);
					System.out.println(wb3.getText());
					seven.add(wb3.getText());
				}

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			cocFinalArr.add(seven);
			tabledata = null;
		}
		System.out.println(cocFinalArr);

	}

}
