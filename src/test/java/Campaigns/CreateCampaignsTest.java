package Campaigns;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Object_Repository.CreateCampaignPage;
import Object_Repository.VtigerHomePage;

public class CreateCampaignsTest extends BaseClass {
	
	@Test
	public void createCampaignsTest() throws Throwable {
       
		/*File_Utility flib = new File_Utility();
         WebDriver_Utility wlib = new WebDriver_Utility();
         Excel_Utility elib = new Excel_Utility();
         Java_Utility jlib = new Java_Utility();
        
         WebDriver driver;
       String BROWSER = flib.getKeyAndValuePair("browser");
         if(BROWSER.equalsIgnoreCase("chrome"))
         {
        	 driver=new ChromeDriver();
         }
         else
         {
         if(BROWSER.equalsIgnoreCase("edge"))
        	 {
        		 driver=new EdgeDriver();
        	 }
       	 else
        	 {
        if(BROWSER.equalsIgnoreCase("firefox"))
        		{
        			driver=new FirefoxDriver();
        		}
        else
        		{
        			driver=new ChromeDriver();
        		}
        	 }
         }
         
         wlib.maximizingWindow(driver);
         wlib.implicity_Wait(driver);
        String URL = flib.getKeyAndValuePair("url");
		String USERNAME =flib.getKeyAndValuePair("username");
    	String PASSWORD = flib.getKeyAndValuePair("password");
		
		driver.get(URL);
        VtigerLoginPage login = new VtigerLoginPage(driver);
    	login.loginToVitigerApp(USERNAME, PASSWORD); */
        
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampaignsLink();

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
        campPage.clickOnPlusSign();
		
      //Assert.assertEquals(true, false); // intentionally failed to check listener concept

      		int ranNum = jlib.getRandomNum();

      		Thread.sleep(2000);

      		String campData = elib.getExcelData("Campaigns", 0, 0) + ranNum;
      		campPage.enterCampaignName(campData);
      		campPage.clickOnSaveButton();

      		Thread.sleep(2000);
      		// home.clickAdmImg();
      		// home.clickOnSignOut();

      		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
      		System.out.println(actData);
      		Thread.sleep(2000);
      		// Hard Assert
      		// Assert.assertEquals(actData, campData);

      		// Soft Assert

      		/*
      		 * SoftAssert soft=new SoftAssert(); soft.assertEquals(actData, campData);
      		 * soft.assertAll();
      		 */
      		// mandatory method 
		
        
        

	}


}
