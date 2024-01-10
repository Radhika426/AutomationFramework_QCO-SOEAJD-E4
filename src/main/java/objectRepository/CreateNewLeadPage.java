package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {

	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastNameTxtField;
	
	@FindBy(name = "company")
	private WebElement companyTxtField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getCompanyTxtField() {
		return companyTxtField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	
		/**
		 * This method will create a new lead and save it
		 * @param PRODUCTNAME
		 */
		public void createNewLead(String LASTNAME, String COMPANY) {
			lastNameTxtField.sendKeys(LASTNAME);
			companyTxtField.sendKeys(COMPANY);
			saveBtn.click();
		}
	
	

}
