package com.zybisys_GenericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	
	public WebDriver driver=null;
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public static WebDriver sDriver;
	
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

}
