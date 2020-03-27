package testscripts;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageobject.Jquery;
import utilities.BaseClass;
import utilities.ConfigFile;
import utilities.Utilities;

public class JqueryTest extends BaseClass{
	ConfigFile config = new ConfigFile();
	//Utilities utilities = new Utilities();
	Jquery jquery=new Jquery(driver);
	 // create variable for extent test
 	ExtentTest test;	
 	// creating object for logger class
 	Logger logger = Logger.getLogger(JqueryTest.class);
 	public JqueryTest() throws Exception {
 		config.loadPropertyFile();
 		PropertyConfigurator.configure("./Config/log4j.properties");
 	}
 	@BeforeClass
 	//launching the browser
 	public void open() {
 		
 		launchBrowser(config.getProperty("url"));
 		logger.info("Browser launched & url opened");
 		captureScreenshot(driver, "website");
 		
 	}
 @Test (priority=1)
 		//searching flights between hyderabad to tirupati
 		public void JqueryClicking() throws InterruptedException {
 		  test = Utilities.reportsFile("Jquery");
 		 
 		  jquery.scrollingPage(driver);
 		 test.log(LogStatus.INFO, "Getting all the URL Elements ");
 		  jquery.jqueryChapterListLinks(driver);
 		  test.log(LogStatus.INFO, "ChapterLIst Links");
 		  jquery.jqueryRecentUpdateListLinks(driver);
 		  test.log(LogStatus.INFO, "Recent List");
 		
 		
}
 @AfterClass
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshot_path = captureScreenshot(driver, result.getName());
			String image = test.addScreenCapture(screenshot_path);
			test.log(LogStatus.FAIL, "Test Failed", image);

		}
		 Utilities.endReport();
	}
}
