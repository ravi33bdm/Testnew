package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameEdt;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	//@FindBy(xpath = "//img[contains(@onclick,'specific_contact_account_address')]")
	//private WebElement clickOnPlusButton; // to fetch organization/account.
	
	@FindBy(xpath = "search_txt")
	private WebElement orgSearchEdt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement orgSearchButton;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioButton;
	
    public CreateContactPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	/*public WebElement getClickOnPlusButton() {
		return clickOnPlusButton;
	}*/

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearchButton() {
		return orgSearchButton;
	}
	
	/*public void CreateContact(String firstname,String lastname )
	{
		firstNameEdt.sendKeys(lastname);
		lastNameEdt.sendKeys(lastname);
		clickOnPlusButton.click();
		
	}*/
	
	//Business Library
	
		/**
		 * This method will create contact with Mandatory fields
		 * @param lastname
		 */
		public void createNewContact(String lastname)
		{
			lastNameEdt.sendKeys(lastname);
			SaveBtn.click();		
		}
		
		/**
		 * This method will create Contact using Organization
		 * @param fisrtname
		 * @param lastname
		 * @param ORG
		 * @param driver
		 */
	
	public void CreateContact(String fisrtname,String lastname,String ORG, WebDriver driver )
	{
		firstNameEdt.sendKeys(fisrtname);
		lastNameEdt.sendKeys(lastname);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(ORG);
		orgSearchButton.click();
		driver.findElement(By.xpath("//a[.='"+ORG+"']")).click(); //Dynamic Xpath
		////a[.='HPv1']" - regular xpath for reference
				//a[text()='"+ORGNAME+"'] -> Dynamic Xpath
				//driver.findElement(By.linkText(ORGNAME));
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
		
		
		
	
		
	}
    
}
