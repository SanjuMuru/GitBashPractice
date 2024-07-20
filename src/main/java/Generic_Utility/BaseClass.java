package Generic_Utility;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.github.dockerjava.api.model.Driver;

import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;

	public File_Utility flib = new File_Utility();
	public WebDriver_Utility wlib = new WebDriver_Utility();
	public Excel_Utility elib = new Excel_Utility();
	public Java_Utility jlib = new Java_Utility();

	@BeforeSuite

	public void BS() throws Throwable {
		// Step1:- Register/ load the mysql database

		System.out.println("DataBase Connection Open");
	}

	@BeforeTest

	public void BT() {
		System.out.println("parallel execution start");
	}

	@BeforeClass

	public void BC() throws Throwable {

		String BROWSER = flib.getKeyAndValueData("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			if (BROWSER.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else {
				if (BROWSER.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else {
					driver = new ChromeDriver();
				}
			}
		}

		sDriver = driver;
		System.out.println("Browser Launched");
	}

	@BeforeMethod

	public void BM() throws Throwable {
		wlib.maximizingWindow(driver);
		wlib.implicity_Wait(driver);

		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");

		driver.get(URL);

		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitigerApp(USERNAME, PASSWORD);
		System.out.println("login to application");
	}

	@AfterMethod

	public void AM() {
		VtigerHomePage home = new VtigerHomePage(driver);
		home.logOut(driver);
		System.out.println("logout from application");
	}

	@AfterClass

	public void AC() {
		driver.close();
		System.out.println("close the browser");
	}

	@AfterTest

	public void AT() {
		System.out.println("parallel execution done");
	}

	@AfterSuite

	public void AS() throws Throwable {

		System.out.println("Data base closed");
	}

}
