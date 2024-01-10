package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {

	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement leadHeaderText;
	
	//Initialization
	public LeadInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getLeadHeaderText() {
		return leadHeaderText;
	}

	//Business Library
	
	/**
	 * This method will capture the lead header text and return it to caller
	 * @return
	 */
	public String captureLeadHeaderText() {
		return leadHeaderText.getText();
	}
	
	

}
