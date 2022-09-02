package Zybisys;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDTestUsingJson {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test(dataProvider="dp")
	void login(String data) throws InterruptedException
	{
		String users[]=data.split(",");
		driver.get("https://dev.zybisys.com/login");
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys(users[0]);
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(users[1]);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[2]")).click();
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
	}
	
	@DataProvider(name="dp")
	public String[] readJson() throws IOException, ParseException
	{
		JSONParser jsonParser=new JSONParser();
		FileReader reader=new FileReader(".\\jsonFiles\\testdata.json");
		Object obj = jsonParser.parse(reader);
		JSONObject userloginsJsonobj=(JSONObject)obj;
		JSONArray userloginsArray=(JSONArray) userloginsJsonobj.get("userlogins");
		
		
		String arr[]=new String[userloginsArray.size()];
		
		for(int i=0;i<userloginsArray.size();i++)
		{
			JSONObject users = (JSONObject)userloginsArray.get(i);
			String user = (String)users.get("username");
			String pwd = (String)users.get("password");
			
			arr[i]=user+","+pwd;
		}
		return arr;
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	

}
