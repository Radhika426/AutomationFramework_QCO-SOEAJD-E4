package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario2_UsingDDT {

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
		String CAMPAIGNNAME = eUtil.readDataFromExcelFile("Campaigns", 1, 2);

		//Step 1:Launch the base browser
		WebDriver driver=new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		//Step 2:Load the Application
		driver.get(URL);

		//Step 3:Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		//Step 4:Mouse hover on More link
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		sUtil.mouseHoverAction(driver, more);

		//Step 5:Click on Campaigns link
		driver.findElement(By.linkText("Campaigns")).click();

		//Step 6:Click on Create Campaign LookUp Image
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		//Step 7:Create new Campaign
		driver.findElement(By.name("campaignname")).sendKeys(CAMPAIGNNAME);

		//Step 8:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step 9:Validate
		String campaignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(campaignHeader.contains(CAMPAIGNNAME)) {
			System.out.println(campaignHeader);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}

		//Step 10:Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		sUtil.mouseHoverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();

		//Step 11:Close the browser
		driver.quit();

	}

}
