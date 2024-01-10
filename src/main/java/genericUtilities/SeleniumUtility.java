package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

/**
 * This class consists of reusable methods related to Selenium tool
 * @author Radhika S
 *
 */
public class SeleniumUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will launch the browser in full screen mode
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will wait for 10 seconds for all the web elements to load
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for a particular web element to become visible
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for 10 seconds for a particular web element to become clickable
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait for 10 seconds to check a particular web element's title contains specified value 
	 * @param driver
	 * @param value
	 */
	public void waitForTitleToBeChecked(WebDriver driver,String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(value));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param ele
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param ele
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param text
	 * @param ele
	 */
	public void handleDropdown(String text,WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hovering action on a web element
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform right click action on a web element
	 * @param driver
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click action on a web element
	 * @param driver
	 * @param ele
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param ele1
	 * @param ele2
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle,WebElement dstEle) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle,dstEle).perform();
	}
	
	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");//js.executeScript("window.scrollBy(0,500);","");
	}
	
	/**
	 * This method will scroll down till the specified web element
	 * @param driver
	 * @param element
	 */
	public void scrollDownAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);//JavaScript snippet
	}
	
	/**
	 * This method will scroll up for 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);");
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the text in alert popup and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle Frame by using frame index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle Frame by using frame name or id attribute value
	 * @param driver
	 * @param value
	 */
	public void handleFrame(WebDriver driver,String frameValue) {
		driver.switchTo().frame(frameValue);
	}
	
	/**
	 * This method will handle Frame by using frame web element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will switch the control back from a frame to parent frame
	 * @param driver
	 */
	public void switchToParenFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the control back from a frame to normal web page 
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
    /**
     * This method will capture the screen shot and return the path to caller
     * @param driver
     * @param screenshotName
     * @return
     * @throws IOException
     */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);//temporary location
		File dst = new File(".\\Screenshots\\"+screenShotName+".png");
		Files.copy(src, dst);
		//FileUtils.copyDirectory(src, dst);
		return dst.getAbsolutePath();//d://mavenproject/E4/Screenshots/CreateProduct.png
		//We will attach this screenshot to extent reports
	}
	
	/**
	 * This method will switch the control to required window based on Title
	 * @param driver
	 * @param expPartialTitle
	 */
	public void handleWindows(WebDriver driver,String expPartialTitle) {
		//Capture all window IDs
		Set<String> allWinIds = driver.getWindowHandles();
		
		//Navigate through each window ID
		for(String winId:allWinIds) {
			//Switch to each window ID and capture the title
			    String actTitle = driver.switchTo().window(winId).getTitle();
			
			//Compare the window titles
			    if(actTitle.contains(expPartialTitle)) {
			    	break;
			    }
		}
	}
	
}
