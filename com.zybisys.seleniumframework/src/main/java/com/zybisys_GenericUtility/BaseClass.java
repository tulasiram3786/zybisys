package com.zybisys_GenericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.zybisys_ObjectRepository.HomePage;
import com.zybisys_ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver=null;
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public static WebDriver sDriver;
	   
	@BeforeSuite
	public void beforeSiute() {
		System.out.println("Data base connection");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("executescript in parallel execution");
	}
	//@Parameters("browser")//String browserName
	
	@BeforeClass
	public void launchBrowser() throws IOException {
 		String browser=fLib.getPropertiesData("browser");
		String url=fLib.getPropertiesData("url"); 
		//polyMorphism
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Launched Browser is : "+ browser);
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("Launched Browser is : "+ browser);
		}else {
			System.err.println("Browser launched failed");
		}
		//launching browesr
		driver.get(url);
		
		//wait statement for pageTo beLoaded GUI
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sDriver=driver;
	}
	@BeforeMethod
	public void loginIntoApplication() throws Throwable {
		           
		String username=fLib.getPropertiesData("username");          
		String password=fLib.getPropertiesData("password");  
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.loginToApplication(username, password);
	}
	@AfterMethod
	public void logoutFromApplication() {
		//logout from the application
		HomePage homePage=new HomePage(driver);
	   
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println(" close executescript in parallel execution");
	}
	
	@AfterSuite
	public void AfterSiute() {
		System.out.println("close Data base connection");
	}
}
