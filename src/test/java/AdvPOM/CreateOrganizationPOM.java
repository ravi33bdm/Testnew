package AdvPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.PropFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CreateOrgLookUpPage;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationHomePage;
import ObjectRepository.OrganizationInfoPage;

public class CreateOrganizationPOM {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8888");
		
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();*/
      
        ExcelUtility eUtil = new ExcelUtility();
		PropFileUtility pUtil = new  PropFileUtility();
		WebDriverUtility webUtil = new WebDriverUtility();
		
		//Read Data from PropFile
		String BROWSER = pUtil.readDataFromPropFile("browser");
		String URL = pUtil.readDataFromPropFile("url");
		String USERNAME = pUtil.readDataFromPropFile("username");
		String PWD = pUtil.readDataFromPropFile("password");
		
		//Read data from Excel
		String ORG = eUtil.readDataFromExcel("Orgnanization",1,2);
		
		//String FSTNAME =eUtil.readDataFromExcel("Contact", 1, 2);
		//String LSTNAME =eUtil.readDataFromExcel("Contact", 1, 3);
		
		driver.get(URL);
		webUtil.maximiseWindow(driver);
		//For login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PWD);
		
		//Click on Organization
		 
		OrganizationHomePage org = new OrganizationHomePage(driver);
		org.OrganizationTab();
		
		//Click on CreateOrg +
		
		CreateOrgLookUpPage orgPlusbutton = new CreateOrgLookUpPage(driver);
		orgPlusbutton.CreateOrganizationLookUp();
		
		//Create organization
		
		CreateOrganizationPage  createOrg = new CreateOrganizationPage(driver);
		createOrg.CreateOrganization(ORG);
		
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String Header = orgInfo.orgHeaderText(); 
		
		
		//by Getter method
		//String hd = orgInfo.getOrgHeaderText().findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		//String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Header.contains(ORG))
		{
			System.out.println("pass");
			System.out.println(Header);
		}
		//ContactTab
		/*org.contactTab();
		
		ClickOnCreateContact con = new ClickOnCreateContact(driver);
		con.createContactPlusButton();
		
		CreateContactPage createContact= new CreateContactPage(driver);
		createContact.CreateContact(FSTNAME, LSTNAME); */
		
	}

	}

