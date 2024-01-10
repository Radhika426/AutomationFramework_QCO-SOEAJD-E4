package practice;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilitiesPractice {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcelFile("Products", 1, 2);
		System.out.println(data);
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());

	}

}
