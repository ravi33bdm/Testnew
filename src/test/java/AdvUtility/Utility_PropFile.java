package AdvUtility;

import DataDrivenTest.ReadDataFromExcel;
import GenericUtility.PropFileUtility;

public class Utility_PropFile {

	public static void main(String[] args) throws Throwable {
		
		PropFileUtility ReadData = new PropFileUtility();
		String browserName = ReadData.readDataFromPropFile("ReadData");
		System.out.println(browserName);
		
	

	}

}
