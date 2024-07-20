package Campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CampWithPrdWindowSwitching;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

//@Listeners(Generic_Utility.ListenerImplementation.class)
public class CreateCampaignWithProductTest extends BaseClass {

	@Test
	public void createCampaignWithProductTest() throws Throwable {

		/*
		 * File_Utility flib = new File_Utility(); Java_Utility jlib = new
		 * Java_Utility(); Excel_Utility elib = new Excel_Utility(); WebDriver_Utility
		 * wlib = new WebDriver_Utility(); WebDriver driver; String BROWSER =
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
		home.clickProductLink();

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();

		//Assert.assertEquals(true, false);

		int ranNum = jlib.getRandomNum();

		String prdData = elib.getExcelData("Product", 0, 0) + ranNum;

		prdPage.enterProductName(prdData);
		prdPage.clickOnSaveButton();

		home.clickMoreLink();
		home.clickCampaignsLink();

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.clickOnPlusSign();

		String campData = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		campPage.enterCampaignName(prdData);

		CampWithPrdWindowSwitching Switching = new CampWithPrdWindowSwitching(driver);
		Switching.clickOnPrdPlusSign();

		// wlib.windowHandling(driver, "Products&action");
		wlib.swithToWindow(driver, "Products&action");

		Switching.enterPrdName(prdData);
		Switching.searchPrdName();

		// driver.findElement(By.xpath("//a[text()='Bluetooth202']")).click();

		// driver.findElement(By.xpath("//a[text()='"+prdData+"']")).click();

		Switching.prdDynamicElement(driver, prdData);

		// wlib.windowHandling(driver, "Campaigns&action");

		wlib.swithToWindow(driver, "Campaigns&action");

		campPage.clickOnSaveButton();

		Thread.sleep(2000);
		// home.logOut(driver);
	}

}
