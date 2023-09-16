package Orgnanization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrg {

	public static void main(String[] args) throws Throwable 
	
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		
		

	}

}
