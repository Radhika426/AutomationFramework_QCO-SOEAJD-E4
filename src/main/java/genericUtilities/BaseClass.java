package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all Basic configuration annotations of TestNG
 * @author Radhika S
 *
 */

	public class BaseClass {

	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();

	public WebDriver driver;
	public static WebDriver sdriver;//For listeners

	@BeforeSuite(groups = {"SmokeSuite", "RegressionSuite"})
	public void bsConfig() {
		System.out.println("========== DB Connection Successful =============");
	}

	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	//public void bcConfig(String Browser) throws Throwable {
	public void bcConfig() throws Throwable {
		String URL = pUtil.readDataFromPropertyFile("url");
		
		sdriver=driver;//For listeners
		driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		driver.get(URL);
        
		System.out.println("========== Browser Launched =============");
		
		/*if(Browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();
		*/
		
		
		
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("========== Login Successful =============");
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);

		System.out.println("========== Logout Successful =============");
	}

	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();

		System.out.println("========== Browser Closed =============");
	}

	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("========== DB Connection Closed =============");
	}



}
