package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Rule 2: Identification/Declaration
	@FindBy(name = "user_name")
	private WebElement userNameTxtField;
	
	@FindBy(name = "user_password")
	private WebElement pwdTxtField;
	
	@FindAll({@FindBy(id = "submitButton"), @FindBy(xpath = "//input[@type='submit']")})
	private WebElement loginBtn;
	
	//Rule 3: Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	//Rule 4: Utilization
	public WebElement getUserNameTxtField() {
		return userNameTxtField;
	}

	public WebElement getPwdTxtField() {
		return pwdTxtField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library - Generic method - operate on elements in current POM class only
	
	/**
	 * This method will perform Login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD) {
		userNameTxtField.sendKeys(USERNAME);
		pwdTxtField.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	

}
