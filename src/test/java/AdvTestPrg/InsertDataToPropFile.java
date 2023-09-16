package AdvTestPrg;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataToPropFile {

	public static void main(String[] args) throws Throwable {
		
		Properties pro = new Properties();
		pro.setProperty("username", "admin");
		pro.setProperty("password", "manager");
		pro.setProperty("url", "https://demo.actitime.com/login.do");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/WriteDataToPropFile.properties");
		pro.store(fos, "Common Data");
		System.out.println("DataPrinted");
		
	}

}
