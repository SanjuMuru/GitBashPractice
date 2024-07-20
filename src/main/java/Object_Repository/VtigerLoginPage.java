package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {
	// initialization
	public VtigerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Element Declaration
	@FindBy(name = "user_name")
	private WebElement UserTextField;

	@FindBy(name = "user_password")
	private WebElement PasswWordTextField;

	@FindBy(id = "submitButton")
	private WebElement LoginButton;

	// getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswWordTextField() {
		return PasswWordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	/**
	 * this method is used for login to Application
	 */

	public void loginToVitigerApp(String username, String password) {
		UserTextField.sendKeys(username);
		PasswWordTextField.sendKeys(password);
		LoginButton.click();
	}
}
