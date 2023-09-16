package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		
		//Open file in Java format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//Create workbook
		Workbook book = WorkbookFactory.create(fis);
		//Navigate to sheet
		Sheet sheet = book.getSheet("Orgnanization");
		//Navigate to row
		Row Row = sheet.getRow(1);
		//Navigate to Cell
		Cell Cell = Row.getCell(2);
		//Read data and print
		String Data = Cell.getStringCellValue();
		System.out.println(Data);
		//close book
		book.close();

	}

}
