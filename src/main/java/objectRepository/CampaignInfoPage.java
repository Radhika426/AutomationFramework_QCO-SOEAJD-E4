package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement campaignHeaderText;
	
	//Initialization
	public CampaignInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getCampaignHeaderText() {
		return campaignHeaderText;
	}
	
	//Business Library
	
	/**
	 * This method will capture the campaign header text and return it to caller
	 * @return
	 */
	public String captureCampaignHeaderText() {
		return campaignHeaderText.getText();
	}
	
	

}
