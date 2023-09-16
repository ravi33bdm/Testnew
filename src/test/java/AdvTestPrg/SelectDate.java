package AdvTestPrg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SelectDate {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//label[contains(.,'Departure') and contains(normalize-space(.),'Jul') and contains(.,'Sunday')]")).click();
		WebElement date = driver.findElement(By.xpath("(//DIV[contains(@role,'gridcell')])[23]"));
		date.click();

	}

}
