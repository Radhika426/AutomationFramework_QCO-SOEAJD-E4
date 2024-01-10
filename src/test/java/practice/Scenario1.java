package practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {
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
		
		//Step 4:Click on Products link
		driver.findElement(By.linkText("Products")).click();
		
		//Step 5:Click on Create Product LookUp Image
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Step 6:Create new Product
		driver.findElement(By.name("productname")).sendKeys("Laptop");
		
		//Step 7:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8:Validate
		String productHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(productHeader.contains("Laptop")) {
			System.out.println(productHeader);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//Step 9:Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step 10:Close the browser
		driver.quit();
	}

}
