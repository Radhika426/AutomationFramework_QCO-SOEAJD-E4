package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {
	
	//Rule 2: Identification/Declaration
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	//Rule 3: Initialization
    public HomePage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    //Rule 4: Utilization
    
	public WebElement getProductsLink() {
		return productsLink;
	}
    
	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
    
	//Rule 5: Business Library
	
	/**
	 * This method will click on Products link
	 */
	public void clickOnProductsLink() {
		productsLink.click();
	}
	
	/**
	 * This method will click on Campaigns link
	 * @param driver
	 */
	public void clickOnCampaignsLink(WebDriver driver) {
		mouseHoverAction(driver, moreLink);
		campaignsLink.click();
	}
	
	/**
	 * This method will click on Leads link
	 */
	public void clickOnLeadsLink() {
		leadsLink.click();
	}
	
	/**
	 * This method will perform sign-out operation
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signOutLink.click();
	}
    
}
