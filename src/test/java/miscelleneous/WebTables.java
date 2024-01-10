package miscelleneous;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td/input")).click();
		List<WebElement> all_Checkbox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
		for (WebElement checkbox : all_Checkbox) {
			checkbox.click();
			Thread.sleep(1000);
		}

	}

}
