package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class OrganizationHomePage extends WebDriverUtility
{
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationTab;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactTab;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminLogOut;
	
	@FindBy (xpath = "//a[.='Sign Out']")
	private WebElement signOutlnk;

	public OrganizationHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationTab() {
		return OrganizationTab;
	}

	public WebElement getContactTab() {
		return contactTab;
	}

	public WebElement getAdminLogOut() {
		return adminLogOut;
	}

	public WebElement getSignOutlnk() {
		return signOutlnk;
	}
	/**
	 * Business library for Logout
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void LogOut(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, adminLogOut);
		Thread.sleep(2000);
		signOutlnk.click();
	}
	
	public void OrganizationTab()
	{
		OrganizationTab.click();
	}
	
	public void contactTab()
	{
		contactTab.click();
	}
}
