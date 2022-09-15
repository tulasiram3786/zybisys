package _15_08_2022Thursday;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxes {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		//select specific checkbox
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//select all checkboxes
		
		List<WebElement> check7 = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		//System.out.println(check7.size());
		//select all 
//		for(WebElement wb1:check7)
//		{
//			wb1.click();
//		}
		
		//select specific checkboxes
//		for(WebElement wb:check7)
//		{
//			String checkboxname = wb.getAttribute("id");
//			if(checkboxname.equals("monday") || checkboxname.equals("sunday"))
//			{
//				wb.click();
//			}
//		}
		
		//last 2 checkboxes select
		
		int totalcheckboes = check7.size();
		
//		for(int i=totalcheckboes-2;i<totalcheckboes;i++)
//		{
//			check7.get(i).click();
//		}
		
		
		//first 2 checkboxes
		
		for(int i=0;i<totalcheckboes;i++)
		{
			if(i<3)
			{
				check7.get(i).click();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
