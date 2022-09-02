package Zybisys;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalIps {
	
	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("kk@bnrsecurities.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		driver.findElement(By.xpath("//div[@class='jss11']")).click();
		WebElement w = driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s = new Select(w);
		s.selectByIndex(1);

	    List<WebElement> wb=driver.findElements(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::div[@class='coc-dashboard-row']/div[4]"));
		// List
		ArrayList<String> als = new ArrayList<>();

		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData/Vm dc2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		Sheet sh = book.getSheet("Sheet1");
		int lastrow = sh.getLastRowNum();
		System.out.println("Total Number of Rows is:" + lastrow);
		short lastCell = sh.getRow(0).getLastCellNum();
		System.out.println("Total Number of Columns is:" + lastCell);
		int rowNumber = 0;
		for (int i = 1; i <= lastrow; i++)
		{
			for (int j = 0; j < lastCell; j++)
			{
				String data = format.formatCellValue(sh.getRow(i).getCell(j));
				
//				if (data.contains(wb))
//				{
//                    rowNumber = i;
//				}
				
				if (rowNumber != 0) {
					als.add(format.formatCellValue(book.getSheet("Sheet1").getRow(rowNumber).getCell(j)));
				}

			if (rowNumber == i) 
			{
				break;
			}
			}
		} 

		for (String str : als) 
		{

			System.out.print(str + " ");
//			driver.findElement(By.xpath("//p[text()='mnmv-r176-bnrathi-ka-app-dmz']")).click();
//			
//			String wb1=driver.findElement(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr/td/p[text() = '"+str+"']")).getText();
//		    System.out.println(wb1);

		}

	}

}
