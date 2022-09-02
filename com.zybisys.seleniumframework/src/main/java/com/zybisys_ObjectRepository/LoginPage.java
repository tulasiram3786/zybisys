package com.zybisys_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login-email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="login-password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//span[text()='Login']")
	@CacheLookup
    WebElement submitButton;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement logoutButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public void loginToApplication(String username, String password) {
		txtEmail.sendKeys(username);
		txtPassword.sendKeys(password);
		submitButton.click();

	}

	
	
}
