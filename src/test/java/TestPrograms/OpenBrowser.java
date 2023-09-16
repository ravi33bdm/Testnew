package TestPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowser {
	public static void main(String[] args) 
	{
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8888");
	}


}
