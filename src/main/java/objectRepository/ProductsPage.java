package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductLookupImg;
	
	//Initialization
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//Utilization
	public WebElement getCreateProductLookupImg() {
		return createProductLookupImg;
	}
	
	//Business Library
	
	/**
	 * This method will click on create product look up image
	 */
	public void clickOnCreateProductLookupImg() {
		createProductLookupImg.click();
	}
	
	

}
