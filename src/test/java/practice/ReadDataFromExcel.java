package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
public static void main(String[] args) throws Throwable {
		
	    //Step 1:Open the document in Java Readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2:Create a Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3:Get the Sheet name/ Navigate to required Sheet
		Sheet sheet = wb.getSheet("Products");
		
		//Step 4:Get the row number/ Navigate to required Row
		Row row = sheet.getRow(1);
		
		//Step 5:Get the Cell number/ Navigate to required Cell
		Cell cell = row.getCell(2);
		
		//Step 6:Get the data from the Cell/ Capture the data inside the cell
		String data = cell.getStringCellValue();
		System.out.println(data);
		
		//Step 7:Close the Workbook
		wb.close();
		

	}

}
