package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	
	//Declaration
	@FindBy(name = "campaignname")
	private WebElement campaignNameTxtField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//Utilization
	public WebElement getCampaignNameTxtField() {
		return campaignNameTxtField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	
	/**
	 * This method will create a new campaign and save it
	 * @param PRODUCTNAME
	 */
	public void createNewCampaign(String CAMPAIGNNAME) {
		campaignNameTxtField.sendKeys(CAMPAIGNNAME);
		saveBtn.click();
	}

}
