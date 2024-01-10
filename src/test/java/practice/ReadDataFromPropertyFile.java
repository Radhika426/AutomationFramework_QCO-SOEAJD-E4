package practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//Step 1:Open the document in Java Readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2:Create object of properties class from java.util
		Properties p=new Properties();
		
		//Step 3:Load the File Input Stream to properties class
		p.load(fis);
		
		//Step 4:Provide key and read the value
		String value = p.getProperty("username");//abc-->null==>output
		System.out.println(value);

	}

}
