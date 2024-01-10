package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderText;
	
	//Initialization
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//Utilization
	
	public WebElement getProductHeaderText() {
		return productHeaderText;
	}
	
	//Business Library
	
	/**
	 * This method will capture the product header text and return it to caller
	 * @return
	 */
	public String captureProductHeaderText() {
		return productHeaderText.getText();
	}
	

}
