package Products;

import org.openqa.selenium.By;
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
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;

public class CreateProductTest extends BaseClass {
	@Test

	public void createProductTest() throws Throwable {

		/*
		 * File_Utility flib = new File_Utility(); WebDriver_Utility wlib = new
		 * WebDriver_Utility(); Excel_Utility elib = new Excel_Utility(); Java_Utility
		 * jlib = new Java_Utility();
		 * 
		 * WebDriver driver; String BROWSER = flib.getKeyAndValueData("browser");
		 * if(BROWSER.equalsIgnoreCase("chrome")) { driver=new ChromeDriver(); } else {
		 * if(BROWSER.equalsIgnoreCase("edge")) { driver=new EdgeDriver(); } else {
		 * if(BROWSER.equalsIgnoreCase("firefox")) { driver=new FirefoxDriver(); } else
		 * { driver=new ChromeDriver(); } } } wlib.maximizingWindow(driver);
		 * wlib.implicity_Wait(driver);
		 * 
		 * 
		 * String URL = flib.getKeyAndValueData("url"); String USERNAME
		 * =flib.getKeyAndValueData("username"); String PASSWORD =
		 * flib.getKeyAndValueData("password");
		 * 
		 * driver.get(URL); driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProductLink();

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();

		int ranNum = jlib.getRandomNum();

		String prdData = elib.getExcelData("Product", 0, 0) + ranNum;
		prdPage.enterProductName(prdData);
		prdPage.clickOnSaveButton();

		// VtigerHomePage home = new VtigerHomePage(driver);
		// home.logOut(driver);

	}

}
