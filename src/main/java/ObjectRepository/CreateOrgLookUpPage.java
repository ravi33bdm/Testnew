package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgLookUpPage {

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createContactImge;
 
	public CreateOrgLookUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateContactImge() {
		return createContactImge;
	}
	
	public void CreateOrganizationLookUp()
	{
		createContactImge.click(); 	
	}
	
	
	
}
