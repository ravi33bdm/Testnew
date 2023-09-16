package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//Step1 open the document in Java format
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\BasicPropFile.properties");
		
		//Step2 Create Property object from java UtilPackage
		Properties p = new Properties();
		
		//Step3 load a doc into properties class
		p.load(fis);
		
		//Step4 Provide key and read value
		
		 String BROWSER = p.getProperty("browser");
		 String URL = p.getProperty("url");
		 String USERNAME = p.getProperty("username");
		 String PWD = p.getProperty("password");
		 
		 System.out.println(URL);
		 
		 
	}

}
