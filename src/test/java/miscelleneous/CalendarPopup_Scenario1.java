package miscelleneous;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopup_Scenario1 {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Wed Jan 03 2024']")).click();

	}

}
