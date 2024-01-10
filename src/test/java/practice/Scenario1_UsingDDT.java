package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Scenario1_UsingDDT {

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
		String LASTNAME = eUtil.readDataFromExcelFile("Products", 1, 2);

		//Step 1:Launch the base browser
		WebDriver driver=new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		//Step 2:Load the Application
		driver.get(URL);

		//Step 3:Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		//Step 4:Click on Products link
		HomePage hp = new HomePage(driver);
		hp.clickOnProductsLink();
//		driver.findElement(By.linkText("Products")).click();

		//Step 5:Click on Create Product LookUp Image
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		//Step 6:Create new Product
		driver.findElement(By.name("productname")).sendKeys(LASTNAME);

		//Step 7:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step 8:Validate
		String productHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(productHeader.contains(LASTNAME)) {
			System.out.println(productHeader);
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
