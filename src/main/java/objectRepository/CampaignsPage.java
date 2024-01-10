package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	//Declaration
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignLookupImg;

	//Initialization
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//Utilization
	public WebElement getCreateCampaignLookupImg() {
		return createCampaignLookupImg;
	}
	
	//Business Library
	
		/**
		 * This method will click on create campaign look up image
		 */
		public void clickOnCreateCampaignLookupImg() {
			createCampaignLookupImg.click();
		}


}
