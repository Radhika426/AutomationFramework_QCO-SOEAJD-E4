package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario3_UsingDDT {

	public static void main(String[] args) throws Throwable {

		//Create Object of Required Utility Classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		/*Read Data From Property File*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/*Read Data From Excel File*/
		String LASTNAME = eUtil.readDataFromExcelFile("Leads", 1, 2);
		String COMPANY = eUtil.readDataFromExcelFile("Leads", 1, 3);

		//Step 1:Launch the base browser
		WebDriver driver=new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		//Step 2:Load the Application
		driver.get(URL);

		//Step 3:Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		//Step 4:Click on Leads link
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();

		//Step 5:Click on Create Lead LookUp Image
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();

		//Step 6:Create new Lead
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.name("company")).sendKeys(COMPANY);

		//Step 7:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step 8:Validate
		String leadHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(leadHeader.contains(LASTNAME)) {
			System.out.println(leadHeader);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}

		//Step 9:Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		sUtil.mouseHoverAction(driver, ele);

		driver.findElement(By.linkText("Sign Out")).click();

		//Step 10:Close the browser
		driver.quit();

	}

}
