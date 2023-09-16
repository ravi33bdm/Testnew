package TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShot {
	@Test
	public void m1() throws Throwable {
	
	WebDriverManager.edgedriver().setup();
	WebDriver driver = new EdgeDriver();
	driver.get("https://www.facebook.com");
	TakesScreenshot screen = (TakesScreenshot) driver;
	File src = screen.getScreenshotAs(OutputType.FILE);
	File dest = new File("ScreenShotNew.png");	
	FileUtils.copyFile(src, dest);
	
	driver.quit();
	


}
}
