package miscelleneous;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopup_Scenario2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveByOffset(20, 10).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='Fri May 03 2024']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				Thread.sleep(1000);
			}
		}
		

	}

}
