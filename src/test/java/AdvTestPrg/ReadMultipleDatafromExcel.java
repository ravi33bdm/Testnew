package AdvTestPrg;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.record.cf.DataBarFormatting;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDatafromExcel {

	public static void main(String[] args) throws Throwable {


		FileInputStream fis = new FileInputStream("./src/test/resources/Book2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet3");
		
		for(int i=0;i<sheet.getLastRowNum();i++)
			
		{
			Row  r= sheet.getRow(i);
			for(int j=0;j<r.getLastCellNum();j++)
			{
				Cell c= r.getCell(j);
				DataFormatter data = new DataFormatter();
				String ActualData = data.formatCellValue(c);
				System.out.println(ActualData);
				
			}
		}
		
		
	}

}
