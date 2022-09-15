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

public class abcabcabc {
	
	@Test
	public void alldata() throws Throwable {

		ArrayList<CoCDashboard> csvIPList = new ArrayList<>();
		csvIPList = getIPListFromCoC();
		
		for (int i = 0; i < csvIPList.size(); i++) {
			System.out.println(csvIPList.get(i).IP + " - CPU "+ csvIPList.get(i).Capacity_CPU + " - RAM"+ csvIPList.get(i).Capacity_RAM + " - HDD " + csvIPList.get(i).Capacity_HDD );
		}
		
		
//	    System.out.println("----------------------------------------------");
//		ArrayList<CoCDashboard> csvIPList = new ArrayList<>();
//		csvIPList = all.getIPListFromCSV("./src/test/resources/CommonData/Vm dc2 -Testing.xlsx");
//		for (int i = 0; i < csvIPList.size(); i++) {
//			System.out.println(csvIPList.get(i).IP + " - CPU "+ csvIPList.get(i).Capacity_CPU + " - RAM"+ csvIPList.get(i).Capacity_RAM + " - HDD " + csvIPList.get(i).Capacity_HDD );
//		}
//		
		
	}
	
	public static ArrayList<CoCDashboard> getIPListFromCoC() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("trade@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		// this is used to click the ->button(aramark) on the ui page
		driver.findElement(By.xpath("//div[@class='jss11']")).click();

		// select the location west 1 or west2
		WebElement w = driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s = new Select(w);
		s.selectByIndex(0);

		List<WebElement> allprivateips = driver.findElements(By
				.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[4]"));

		

		ArrayList<String> cocIPList = new ArrayList<>();
		ArrayList<CoCDashboard> myArraylist = new ArrayList<>();
		for (WebElement wb : allprivateips) {
			cocIPList.add(wb.getText());
			CoCDashboard cocObj = new CoCDashboard();
			
			cocObj.setIP(wb.getText());
			cocObj.setCapacity_RAM("2 GB");
			cocObj.setCapacity_CPU(4);
			cocObj.setCapacity_HDD("1 TB");
			myArraylist.add(cocObj);
			//System.out.println(wb.getText());
		}
		return myArraylist;
	}

}
