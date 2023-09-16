package AdvUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.WebDriverUtility;

public class WebDriverUtilImplimentation {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		WebDriverUtility WebDrMethods = new WebDriverUtility();
		WebDrMethods.maximiseWindow(driver);
		Thread.sleep(2000);
		WebDrMethods.minimiseWindow(driver);
		

	}

}
