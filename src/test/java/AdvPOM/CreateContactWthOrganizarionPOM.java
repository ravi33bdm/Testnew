package AdvPOM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.PropFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.ClickOnCreateContact;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateOrgLookUpPage;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationHomePage;

public class CreateContactWthOrganizarionPOM {

	public static void main(String[] args) throws Throwable {

		//WebDriver driver= new ChromeDriver();
		EdgeDriver driver = new EdgeDriver();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.maximiseWindow(driver);
		
		
		ExcelUtility eUtil = new ExcelUtility();
		PropFileUtility pUtil = new  PropFileUtility();
		WebDriverUtility webUtil = new WebDriverUtility();
		
		String BROWSER = pUtil.readDataFromPropFile("browser");
		String URL = pUtil.readDataFromPropFile("url");
		String USERNAME = pUtil.readDataFromPropFile("username");
		String PWD = pUtil.readDataFromPropFile("password");
		
		//Read data from Excel
		String ORG = eUtil.readDataFromExcel("Orgnanization",1,2);
		
		String firstName = eUtil.readDataFromExcel("Contact", 1, 2);
		String lastName = eUtil.readDataFromExcel("Contact", 1, 3);
		
		driver.get(URL);
		
		//Calling POM class constructor by using business library
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PWD);
		
		OrganizationHomePage org = new OrganizationHomePage(driver);
		org.OrganizationTab();
		
		//Click on CreateOrg +
		
		CreateOrgLookUpPage orgPlusbutton = new CreateOrgLookUpPage(driver);
		orgPlusbutton.CreateOrganizationLookUp();
		
		//Create organization
		
		CreateOrganizationPage  createOrg = new CreateOrganizationPage(driver);
		createOrg.CreateOrganization(ORG);
		
		
		// Calling by Getter method
		/*lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getUserPwdEdt().sendKeys(PWD);
		lp.getSubmitButton().click();*/
		
		//by getter methods
				/*con.getContactTab().click();
			    con.getCreateContact().click();
			    con.getFirstNameEdt().sendKeys("Priya");
			    con.getLastNameEdt().sendKeys("Baratakke");
			    con.getGroupRadioButton().click();
			    con.getClickOnPlusButton().click();*/
		
		// ContactTab is created in Organization home page
		org.contactTab();
				
		ClickOnCreateContact conClick = new ClickOnCreateContact(driver);
		conClick.createContactPlusButton();
		
		CreateContactPage con = new CreateContactPage(driver);
		con.CreateContact(firstName, lastName, ORG, driver);
		
		
	    
		//driver.findElement(By.linkText("Contacts")).click();
		/*driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Nuren");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Baratakke");
		driver.findElement(By.xpath("//img[contains(@onclick,'specific_contact_account_address')]")).click();*/
		
		/*String ConWinId = driver.getWindowHandle();
		Set<String> allWinIDs = driver.getWindowHandles();
		for(String id:allWinIDs)
			
		{
			if(!ConWinId.equals(id))
			{ 
			  driver.switchTo().window(id);
			  //driver.findElement(By.id("search_txt")).sendKeys("Sony");
			  //driver.findElement(By.xpath("//input[@name='search']")).click();
			  driver.findElement(By.xpath("//a[.='HPv1']")).click();
			
		     }
		
		
	    }*/
		
		
		
		
	}

}
