package DataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithDDT {

	
		public static void main(String[] args) throws IOException, InterruptedException
		
		{
			
			WebDriver driver = null;
			
			//Read data from property file
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\BasicPropFile.properties");
			Properties p = new Properties();
			p.load(fis);
			//driver.get("http://localhost:8888/");
					
			/*Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
		    System.out.println("From browser " + browserName);
			*/
			String BROWSER = p.getProperty("browser");
			String URL = p.getProperty("url");
			String USERNAME = p.getProperty("username");
			String PWD = p.getProperty("password");
			
			//Read data from Excel sheet.
			
			FileInputStream fisExcel = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook book = WorkbookFactory.create(fisExcel);
			Sheet sheet = book.getSheet("Orgnanization");
			/*Row Row = sheet.getRow(1);
			Cell Cell = Row.getCell(2);
			String Data = Cell.getStringCellValue();
			System.out.println(Data);*/
			String ORGNAME = sheet.getRow(1).getCell(2).getStringCellValue();
			
		    String INDUSTRY = sheet.getRow(4).getCell(3).getStringCellValue();
			
		    //Launch the browser - //Run Time Polymorphism - driver
		    
			if (BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
		    	driver = new ChromeDriver();
			}
			
			else if (BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
		    	driver = new FirefoxDriver();
			}
			
			else if (BROWSER.equalsIgnoreCase("msedge"))
			{
				WebDriverManager.edgedriver().setup();
		    	driver = new EdgeDriver();
			}
			
			else
			{
				System.out.println("Invalid Browser");
			}
			
			
			driver.manage().window().maximize();
			driver.get(URL);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
			driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
			
			WebElement dropDown = driver.findElement(By.name("industry"));
			Thread.sleep(2000);
			Select sel = new Select(dropDown);
			sel.selectByValue(INDUSTRY);
			
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Step 9: Logout of App
			
			Thread.sleep(2000);
			WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(mouseHover).perform();
			Thread.sleep(10);
			driver.findElement(By.linkText("Sign Out")).click();
			
			
			
			
			
			/* Data from excel
			FileInputStream fisEx = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook book = WorkbookFactory.create(fisEx);
			Sheet sheet = book.getSheet("Orgnanization");
			Row Row = sheet.getRow(1);
			Cell Cell = Row.getCell(2);
			String Data = Cell.getStringCellValue();*/
		}	

	}


