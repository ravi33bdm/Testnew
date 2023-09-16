package AdvTestPrg;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromEcxelUsingMap {

	public static void main(String[] args) throws Throwable, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/Book2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet3");
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("10", "Badami");
		map.put("20", "Bagalkot");
		map.put("30","Bengaluru");
		
		int rowNum=0;
		for(Entry<String, String> m:map.entrySet())
		{
		Row row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue((String) m.getKey());
		//row.createCell(0).setCellValue((String)m.getKey());
		row.createCell(1).setCellValue((String)m.getKey());
		}
		
		 FileOutputStream fos = new FileOutputStream("./src/test/resources/Book2.xlsx");
		 book.write(fos);
		 book.close();
		
		

	}

}
