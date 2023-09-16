package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readDataFromExcel(String sheetName,int rowno,int cellno) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook book = WorkbookFactory.create(fis);
	    Sheet sheet = book.getSheet(sheetName);
	    Row row = sheet.getRow(rowno);
	    Cell cell = row.getCell(cellno);
	    String Data = cell.getStringCellValue();
	    return Data;
		//System.out.println(Data);
		
	}

}
