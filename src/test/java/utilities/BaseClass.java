package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public WebDriver driver;
	public	ExtentTest test;
	public ExtentReports reports;
	public ITestResult result;
	public static String projectPath = System.getProperty("user.dir");

	public String reportFilePath;
	public Date date;
	static Date dte = new Date();
	static String dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dte);
	static String reportFileName = "Testing_" + dateFormat;
	public static String screenShotFilePath=projectPath+"/ScreenShots/";
	public String driverPath=projectPath+"/Resources/";
	//public String webDriverPath = driverPath + File.separator + "chromedriver.exe";
	private String frameworkDir = System.getProperty("user.dir");           
	private String webDriverPath = frameworkDir + File.separator + "Resources" + File.separator + "chromedriver.exe";

	
	public void launchBrowser(String url){
		      // set the path for chromedriver
				System.setProperty("webdriver.chrome.driver", webDriverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				options.merge(capabilities);
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				// to open the chrome browser
				driver = new ChromeDriver(options);
				// to maximize the window
				driver.manage().window().maximize();
				// to maintain time
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				// get the url
				driver.get(url);
				//String website=driver.getCurrentUrl();
				
				//return website;

	}
	// Explicit wait method for element clickable
		/*public WebElement waitForExpectedElement(WebDriver driver, final By locator) {
		  WebDriverWait wait = new WebDriverWait(driver, 100);
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}*/
		public WebElement waitForExpectedElement(WebDriver driver, final By locator) {  
			WebDriverWait wait = new WebDriverWait(driver, 150);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
		public static String captureScreenshot(WebDriver driver, String screenshotname) {

			try {

				// Set the Current Date and Time
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
				Date dt = new Date();
				System.out.println(dateFormat.format(dt));

				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source,
						new File("D:/screenshots/" + dateFormat.format(dt) + "_" + screenshotname + ".png"));
				System.out.println("screenshot taken");
			} catch (Exception e) {
				System.out.println("exception while taking screenshot" + e.getMessage());
			}
			return screenshotname;

		}
}
