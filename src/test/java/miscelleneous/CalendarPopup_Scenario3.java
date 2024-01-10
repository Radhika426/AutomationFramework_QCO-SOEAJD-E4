package miscelleneous;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopup_Scenario3 {

	public static void main(String[] args) throws Throwable {
		
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String currentDate=dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
		System.out.println(currentDate);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveByOffset(20, 10).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();

	}

}
