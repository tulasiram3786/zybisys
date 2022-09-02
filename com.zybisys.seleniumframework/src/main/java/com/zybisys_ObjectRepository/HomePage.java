package com.zybisys_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    //instance
	@FindBy(xpath="//div[text()='Instances']/ancestor::div[@class='sc-gGLxEB dGJRan']/descendant::div[@class='sc-FRrlG cIjgB']")
    private WebElement InstancesTotalCount;   //Total
	
	
	@FindBy(xpath="//div[text()='Instances']/ancestor::div[@class='sc-jUfyBS eSyZIh']/descendant::div[@class='sc-GvhzO kSqeJg']")
	private WebElement InstancesUpCount;      //Up
	
	@FindBy(xpath="//div[text()='Instances']/ancestor::div[@class='sc-jUfyBS eSyZIh']/descendant::div[@class='sc-gsWcmt grZHMV']")
	private WebElement InstancesDownCount;    //Down
	
	/**
	 * SERVICES
	 */
	@FindBy(xpath="//div[text()='Services']/ancestor::div[@class='sc-jUfyBS eSyZIh']/descendant::div[@class='sc-fcmMJX bRzrLL']")
	private WebElement ServicesTotalCount;    //Total
	
	@FindBy(xpath="//div[text()='Services']/ancestor::div[@class='sc-jUfyBS eSyZIh']/descendant::div[@class='sc-GvhzO kSqeJg']")
	private WebElement ServicesOkCount;       //ok
	
	@FindBy(xpath="//div[text()='Services']/ancestor::div[@class='sc-jUfyBS eSyZIh']/descendant::div[@class='sc-bXexck kmvQjn']")
	private WebElement ServicesWarnCount;     //warn
	
	@FindBy(xpath="//div[text()='Services']/ancestor::div[@class='sc-jUfyBS eSyZIh']/descendant::div[@class='sc-gsWcmt grZHMV']")
	private WebElement ServicesCritCount;     //critical
	
	/**
	 * TICKETS
	 */
	@FindBy(xpath="//div[text()='Tickets']/ancestor::div[@class='sc-jUfyBS eSyZIh ticket-wigdet']/descendant::span[text()='Pending Tickets']")
	private WebElement PendingTickets;        //pending tickets
	
	@FindBy(xpath="//div[text()='Tickets']/ancestor::div[@class='sc-jUfyBS eSyZIh ticket-wigdet']/descendant::span[text()='Closed Tickets']")
	private WebElement ClosedTickets;         // closed tickets
	
	/**
	 * BILLING
	 */
	
	@FindBy(xpath="//div[text()='Billing']/ancestor::div[@class='sc-jUfyBS eSyZIh ticket-wigdet']/descendant::span[text()='Total']")
	private WebElement total;                 //total

	@FindBy(xpath="//div[text()='Billing']/ancestor::div[@class='sc-jUfyBS eSyZIh ticket-wigdet']/descendant::span[text()='Pay Now']")
	private WebElement paynow;                //paynow
	
	
	/**
	 * Scroll down sub modules for Instance, Backup , Monitoring, Billing, API, Report, Storage.
	 */
	
	
	@FindBy(xpath="//div[@class='h2']/ancestor::div[@class='service_cards']/descendant::p[text()='Manage your Instances, TAG’s, IP address and Notifications.']")
	private WebElement Instance;
	
	@FindBy(xpath="//div[@class='h2']/ancestor::div[@class='service_cards']/descendant::p[text()='Point of recovery service for all your important data.']")
	private WebElement Backup;
	
	@FindBy(xpath="//div[@class='h2']/ancestor::div[@class='service_cards']/descendant::p[text()='High level visibility on Compute, Internet, performance and Automation.']")
	private WebElement Monitoring;
	
	@FindBy(xpath="//div[@class='h2']/ancestor::div[@class='service_cards']/descendant::p[text()='Easy payment options, billing history and download invoices.']")
	private WebElement Billing;
	
	@FindBy(xpath="//div[@class='h2']/ancestor::div[@class='service_cards']/descendant::p[text()='Realtime and historical report of your live instances.']")
	private WebElement Report;
	
	@FindBy(xpath="Automate your daily activity using our RESTFull API. Coming Soon…!")
	private WebElement API;
	
	@FindBy(xpath="//div[@class='h2']/ancestor::div[@class='service_cards']/descendant::p[text()='Object storage service for storing your files, images, videos. Coming Soon…!']")
    private WebElement Storage;

	public WebElement getInstancesTotalCount() {
		return InstancesTotalCount;
	}

	public WebElement getInstancesUpCount() {
		return InstancesUpCount;
	}

	public WebElement getInstancesDownCount() {
		return InstancesDownCount;
	}

	public WebElement getServicesTotalCount() {
		return ServicesTotalCount;
	}

	public WebElement getServicesOkCount() {
		return ServicesOkCount;
	}

	public WebElement getServicesWarnCount() {
		return ServicesWarnCount;
	}

	public WebElement getServicesCritCount() {
		return ServicesCritCount;
	}

	public WebElement getPendingTickets() {
		return PendingTickets;
	}

	public WebElement getClosedTickets() {
		return ClosedTickets;
	}

	public WebElement getTotal() {
		return total;
	}

	public WebElement getPaynow() {
		return paynow;
	}

	public WebElement getInstance() {
		return Instance;
	}

	public WebElement getBackup() {
		return Backup;
	}

	public WebElement getMonitoring() {
		return Monitoring;
	}

	public WebElement getBilling() {
		return Billing;
	}

	public WebElement getReport() {
		return Report;
	}

	public WebElement getAPI() {
		return API;
	}

	public WebElement getStorage() {
		return Storage;
	}
	
	public void instanceCount()
	{
		InstancesTotalCount.getText();
	}

	
}
