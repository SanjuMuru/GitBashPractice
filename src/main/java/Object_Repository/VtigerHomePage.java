package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class VtigerHomePage {
	// initialization
	public VtigerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	@FindBy(linkText = "Products")
	private WebElement productLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	// getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getAdmLink() {
		return admLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	// Business Logics
	/**
	 * This method is used to click more Link
	 * 
	 * @author Sanju
	 */
	public void clickMoreLink() {
		moreLink.click();
	}

	/**
	 * This method is used to click campaigns Link
	 */
	public void clickCampaignsLink() {
		campaignLink.click();
	}

	/**
	 * This method is used to click organizationLink
	 * 
	 * @author Sanju
	 */
	public void clickOrganizationLink() {
		organizationLink.click();
	}

	/**
	 * This method is used to click productLink
	 * 
	 * @author Sanju
	 */
	public void clickProductLink() {
		productLink.click();
	}

	/**
	 * This method is used to click admLink
	 * 
	 * @author Sanju
	 */
	public void clickAdmImg() {
		admLink.click();
	}

	/**
	 * This method is used to click signOutLink
	 * 
	 * @author Sanju
	 */
	public void clickOnSignOut() {
		signOutLink.click();
	}

	/**
	 * This method is used to click signOutLink
	 * 
	 * @author Sanju
	 */
	public void logOut(WebDriver driver) {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.moveToElement(driver, admLink);
		signOutLink.click();
	}

}
