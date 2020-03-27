package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	public static ExtentTest test;
	public static ExtentReports reports;
	// store current working directory path with "user.dir"
	public static String projectPath = System.getProperty("user.dir");
	public static String reportFilePath;
	
	public static  ExtentTest reportsFile(String testCaseName) {
		reportFilePath = projectPath + "/Reports/Jquery.html";
		// "false" parameter is for generate newly .html file
		reports = new ExtentReports(reportFilePath, false);	// "true" parameter is for overide on same .html file
		test = reports.startTest(testCaseName);
		return test;
	}
	
	public static void endReport() {
		reports.endTest(test);
		reports.flush();
	}
	
	/*public static String captureScreenshot(WebDriver driver, String screenshotname) {

		try {

			// Set the Current Date and Time
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date();
			System.out.println(dateFormat.format(dt));

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,
					new File("D:/ScreenShots/" + dateFormat.format(dt) + "_" + screenshotname + ".png"));
			System.out.println("screenshot taken");
		} catch (Exception e) {
			System.out.println("exception while taking screenshot" + e.getMessage());
		}
		return screenshotname;

	}*/
}