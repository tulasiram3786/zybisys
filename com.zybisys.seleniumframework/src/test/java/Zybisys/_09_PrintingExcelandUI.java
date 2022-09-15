package Zybisys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class will print the all excel data in line by line
 * 
 * @author Tulasiram
 *
 */

public class _09_PrintingExcelandUI {

	private static final String IPV4_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

	public static boolean isValidInet4Address(String ip) {
		if (ip == null) {
			return false;
		}

		Matcher matcher = IPv4_PATTERN.matcher(ip);

		return matcher.matches();
	}

	 @Test(priority=1)
	public void ui() throws InterruptedException, IOException {
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

	

	
		String excelFilePath = "./src/test/resources/CommonData/Vm dc2 -Testing.xlsx";

		FileInputStream fis = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();

		ArrayList<ArrayList<String>> ExcelFinalArr = new ArrayList<>();

		for (int r = 0; r <= rows; r++) {
			try {

				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < cols; c++) {
					XSSFCell cell = row.getCell(c);

					ArrayList<String> exceldata = new ArrayList<>();

					// System.out.println(cell.getStringCellValue());
					switch (cell.getCellType()) {
					case STRING:
						exceldata.add(cell.getStringCellValue());
						break;
					case NUMERIC:
						exceldata.add(cell.getStringCellValue());
						break;
					case BOOLEAN:
						exceldata.add(cell.getStringCellValue());
						break;
					default:
						break;
					}
					
					ExcelFinalArr.add(exceldata);
				}
				System.out.println();

			} catch (Exception e) {

			}

		}
		System.out.println(ExcelFinalArr);
		
		
	}

}


