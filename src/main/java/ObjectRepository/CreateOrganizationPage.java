package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryName;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveOrg;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getSaveOrg() {
		return saveOrg;
	}
    
	// create organization
	public void CreateOrganization(String Org)
	{
		orgName.sendKeys(Org);
		handleDropdown(industryName,6);	
		saveOrg.click();
	}
	
	/*public void CreateOrganization(String Org,String Industry)
	{   orgName.sendKeys(Org);
		handleDropdown(industryName, 2);
		saveOrg.click();
	}*/
	
}
