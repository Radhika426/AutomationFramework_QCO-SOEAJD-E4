package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {

	//Declaration
	@FindBy(name = "productname")
	private WebElement productNameTxtField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//Initialization
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//Utilization
	public WebElement getProductNameTxtField() {
		return productNameTxtField;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Library
	
	/**
	 * This method will create a new product and save it
	 * @param PRODUCTNAME
	 */
	public void createNewProduct(String PRODUCTNAME) {
		productNameTxtField.sendKeys(PRODUCTNAME);
		saveBtn.click();
	}
	
}
