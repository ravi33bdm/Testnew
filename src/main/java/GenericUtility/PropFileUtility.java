package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * To fetch data from PropFile
 * @author Admin
 *
 */

public class PropFileUtility
{
 
	/**
	 * Read data from PropFile and return value to caller
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
			
	public String readDataFromPropFile(String key) throws Throwable 
	{
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\BasicPropFile.properties");
		 Properties p = new Properties();
		 p.load(fis);
		 String value = p.getProperty(key);
		 return value;
		
	}

	}


