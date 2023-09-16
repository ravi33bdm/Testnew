package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnCreateContact {

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactPlusButton; // Click on + button to create Contact
	
	public ClickOnCreateContact(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateContactPlusButton() {
		return createContactPlusButton;
	}
	
	public void createContactPlusButton()
	{
		createContactPlusButton.click();
	}
}
