package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {
public static void main(String[] args) throws Throwable {
		
	    //Step 1:Open the document in Java Readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2:Create a Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3:Given data to be written
		String name="Radhika";
		
		//Step 4:Get/ Navigate to Sheet name where data needs to be written
		Sheet sheet = wb.getSheet("Products");
		
		//Step 5:Create the row number
		Row row = sheet.createRow(6);
		
		//Step 6:Create the cell number
		Cell cell = row.createCell(0);
		
		//Step 7:Set the data to be written in the cell
		cell.setCellValue(name);
		
		//Step 8:Write the data in the excel
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		

	}

}
