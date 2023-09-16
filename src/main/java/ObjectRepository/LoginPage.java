package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
  { // Rule1 : create class a page for login
	
	//Rule2  : find element and declare
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPwdEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	// Rule3 create constructor to initialize elements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	

	}

	// Rule4 : Use getter method to access the private elements.
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPwdEdt() {
		return userPwdEdt;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Rule5 : Provide business library
	/**
	 * Login to app using business library
	 * @param USERNAME
	 * @param PWD
	 */
	public void loginToApp(String USERNAME, String PWD)
	
	{
		userNameEdt.sendKeys(USERNAME);
		userPwdEdt.sendKeys(PWD);
		submitButton.click();
	}
	
	
	

}
