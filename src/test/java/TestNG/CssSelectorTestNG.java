package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorTestNG{
@Test
public void CssSelectorTestNG () throws Throwable

{
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.actitime.com/login.do");
	driver.findElement(By.cssSelector("[id='username']")).sendKeys("admin");
	driver.findElement(By.cssSelector("[name='pwd']")).sendKeys("manager");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[id='loginButton']")).click();
	//driver.findElement(By.partialLinkText("View Time-Track")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.linkText("View Time-Track")).click();
	

}
}
