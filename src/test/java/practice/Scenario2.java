package practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {
   public static void main(String[] args) throws Throwable {
		
		//Step 1:Launch the base browser
	    WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2:Load the Application
		driver.get("http://localhost:8888/");
		
		//Step 3:Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4:Mouse hover on More link
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act=new Actions(driver);
		act.moveToElement(more).perform();
		
		//Step 5:Click on Campaigns link
		driver.findElement(By.linkText("Campaigns")).click();
		
		//Step 6:Click on Create Campaign LookUp Image
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		//Step 7:Create new Campaign
		driver.findElement(By.name("campaignname")).sendKeys("Banner Ads");
		
		//Step 8:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 9:Validate
		String campaignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(campaignHeader.contains("Banner Ads")) {
			System.out.println(campaignHeader);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//Step 10:Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step 11:Close the browser
		driver.quit();

	}

}
