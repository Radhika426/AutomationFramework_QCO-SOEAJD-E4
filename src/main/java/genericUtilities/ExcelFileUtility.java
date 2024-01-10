package genericUtilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of reusable methods related to Excel File
 * @author Radhika S
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from Excel File and return the data to the caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return data
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}

}
