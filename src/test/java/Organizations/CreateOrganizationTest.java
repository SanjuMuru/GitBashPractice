package Organizations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateOrganizationTest extends BaseClass {

	@Test

	public void createOrganizationTest() throws Throwable {

		/*
		 * File_Utility flib = new File_Utility(); WebDriver_Utility wlib = new
		 * WebDriver_Utility(); Excel_Utility elib = new Excel_Utility(); Java_Utility
		 * jlib = new Java_Utility(); WebDriver driver; String BROWSER =
		 * flib.getKeyAndValueData("browser"); if(BROWSER.equalsIgnoreCase("chrome")) {
		 * driver=new ChromeDriver(); } else { if(BROWSER.equalsIgnoreCase("edge")) {
		 * driver=new EdgeDriver(); } else { if(BROWSER.equalsIgnoreCase("firefox")) {
		 * driver=new FirefoxDriver(); } else { driver=new ChromeDriver(); } } }
		 * wlib.maximizingWindow(driver); wlib.implicity_Wait(driver);
		 * 
		 * String URL = flib.getKeyAndValueData("url"); String USERNAME
		 * =flib.getKeyAndValueData("username"); String PASSWORD =
		 * flib.getKeyAndValueData("password");
		 * 
		 * driver.get(URL); VtigerLoginPage login = new VtigerLoginPage(driver);
		 * login.loginToVitigerApp(USERNAME, PASSWORD);
		 */

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickOrganizationLink();

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.clickPlusImg();
		Thread.sleep(2000);

		int ranNum = jlib.getRandomNum();

		String orgData = elib.getExcelDataUsingDataFormatter("Organization", 0, 0) + ranNum;
		String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		Thread.sleep(2000);
		String emailId = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
		orgPage.enterOrganizationData(orgData, phoneNum, emailId);
		orgPage.clickOnSaveButton();

		ValidationAndVerificationPage orgValid = new ValidationAndVerificationPage(driver);
		orgValid.orgValidation(driver, orgData);

		// home.logOut(driver);

	}

}
