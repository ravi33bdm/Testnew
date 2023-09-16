package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import GenericUtility.WebDriverUtility;

public class CreatProd {

	private static final String Dp = null;

	public static void main(String[] args) throws Throwable {
		
	WebDriver driver =new ChromeDriver();
	WebDriverUtility webUtil = new WebDriverUtility();
	
	//Read data from Prop File
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\BasicPropFile.properties");
	Properties p = new Properties();
	p.load(fis);
	String BROWSER = p.getProperty("browser");
	String URL = p.getProperty("url");
	String USERNAME = p.getProperty("username");
	String PASSWORD = p.getProperty("password");
	
	driver.manage().window().maximize();
	driver.get(URL);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();//input#submitButton shortcut for id locator.
		
	//Read data from excel
	
	FileInputStream fisExcel = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook book = WorkbookFactory.create(fisExcel);
	Sheet sheet = book.getSheet("Product");
	
	String PROD = sheet.getRow(1).getCell(1).getStringCellValue();
	String CATEGORY = sheet.getRow(1).getCell(2).getStringCellValue();
	
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(PROD);
	driver.findElement(By.xpath("//select[@name='productcategory']")).sendKeys(CATEGORY);
	
	//DiSelect check box
		driver.findElement(By.xpath("//input[@name='discontinued']")).click();
	
	// select value from dropdown -GL Account(302-Rental-Income,301-Sales-Hardware)
	
	WebElement GLAccount = driver.findElement(By.xpath("//select[@name='glacct']"));
	Select GLAccountdropdown = new Select(GLAccount);
	//GLAccountdropdown.selectByValue("308");
	GLAccountdropdown.selectByIndex(1);
	//GLAccountdropdown.selectByVisibleText("302-Rental-Income");
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
    //js.executeScript("window.scrollBy(0,500)", "");
    
    //ScrollByVisibleElement
    WebElement Description = driver.findElement(By.xpath("//textarea[@name='description']"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Description);
    
    
	
	//Select Group radio button
	driver.findElement(By.xpath("//input[@value='T']")).click();
	
	WebElement HandlerDp = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
	webUtil.handleDropdown("Team Selling", HandlerDp);
	/*Select Drp = new Select(HandlerDp);
	Drp.selectByIndex(1);*/
	
	WebElement date = driver.findElement(By.id("jscal_trigger_sales_end_date"));
	date.click();
	////img[@id='jscal_trigger_sales_end_date']
	WebElement day = driver.findElement(By.xpath("//td[text()='21' and @class='day selected']"));
	day.click();
	System.out.println(day);
	
	//upload file
	WebElement file = driver.findElement(By.id("my_file_element")); 
	file.click();
	driver.findElement(By.id("my_file_element")).sendKeys("C:\\Users\\Admin\\Desktop\\Sql\\3 WHERE CLAUSE.txt");//C:\Users\Admin\Desktop\Sql
	
		

		
	
	
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	/*//Selecting Items in a Multiple SELECT elements
		driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1); */
	
	
	
	//Switching to Popup window adding vendor
	
	/*driver.findElement(By.xpath("//img[@alt='Select']")).click();
	String ProdWinId = driver.getWindowHandle();
	System.out.println(ProdWinId);
	Set<String> winids = driver.getWindowHandles();
	System.out.println(winids);
	
	for(String id:winids)
	{
		if(!ProdWinId.equals(id))
		{
			driver.switchTo().window(id);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("TestVendor");
			driver.findElement(By.xpath("//input[@name='search']")).click();
		}
	}*/
	
	/* navigate to different window
	 driver.get("https://www.naukri.com");
		WebElement jobs = driver.findElement(By.xpath("//div[.='Jobs']"));
	     
		Actions act = new Actions(driver);
		act.moveToElement(jobs).perform();
		driver.findElement(By.xpath("//div[text()='Jobs by skill']")).click();
		driver.findElement(By.xpath("//div[.='Services']")).click();
		
		String mainId = driver.getWindowHandle();
		System.out.println(mainId);
		
		Set<String> allids = driver.getWindowHandles();
	System.out.println(allids);
	
	for(String id:allids)
	{
		if(!mainId.equals(id))
		{
			driver.switchTo().window(id);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[.='FIND JOBS']")).click();
		}
	}
	
	driver.switchTo().window(mainId);
	 */
	 
	
	
	
	
	 
	
	}

}
