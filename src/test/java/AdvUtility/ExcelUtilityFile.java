package AdvUtility;

import GenericUtility.ExcelUtility;

public class ExcelUtilityFile {

	public static void main(String[] args) throws Throwable 
	{
		ExcelUtility excel	= new ExcelUtility();
		String data = excel.readDataFromExcel("Contact",1,2);
		System.out.println(data);
		

	}

}
