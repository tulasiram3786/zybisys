package Zybisys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.zybisys_GenericUtility.ExcelUtility;
import com.zybisys_GenericUtility.IPathConstants;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;
@Listeners(com.zybisys_GenericUtility.ListenersImplementationClass.class)
public class ExcelAndUiComparisionTest {

	
	    @Test
	    public void excelAnduiComparision() throws Throwable
	    {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("kk@bnrsecurities.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Zybisys@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();

		//this is used to click the instance name on the ui page 
		driver.findElement(By.xpath("//div[@class='jss11']")).click();
		
		//select the location west 1 or west2
		WebElement w = driver.findElement(By.xpath("//select[@id='location-select']"));
		Select s = new Select(w);
		s.selectByIndex(1);

		String wb = driver.findElement(By.xpath("//p[text()='10.193.4.9']")).getText();
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
				if (data.contains(wb))
				{
                    rowNumber = i;
				}
				if (rowNumber != 0)
				{
					als.add(format.formatCellValue(book.getSheet("Sheet1").getRow(rowNumber).getCell(j)));
				}

			}
			if (rowNumber == i) 
			{
				break;
			}

		} 

		for (String str : als) 
		{

			  System.out.print(str + "   |    ");
        }
		driver.findElement(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::p[text()='mnmv-bnr-ekyc']")).click();
        List<WebElement> text = driver.findElements(By.xpath("//table[@class='dashboard-drop-table']/tbody/tr[*]/td[*]"));
	
		for(WebElement wb2:text)
		{
			System.out.println(wb2.getText());
			
			//Here the comparision between the excel sheet and ui data.
			if(wb2.getText().contains(wb))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
		}
		driver.findElement(By.xpath("//*[contains(@class,'coc-dashboard-row')]/following::p[text()='mnmv-bnr-ekyc']")).click();
	    
	
		
		
	
	}
}

