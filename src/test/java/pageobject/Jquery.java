package pageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BaseClass;

public class Jquery extends BaseClass {
	WebDriver driver;
	public static final By SCROLLING = By.xpath("//a[@href='https://jquery.org/license/']");
	public static final By CHAPTERLISTLINKS =By.xpath("//aside[@id='chapter-list']/ul/li");
	public static final By RECENTUPDATELINKS =By.xpath("//aside[@id='recent-updates']/li");
	 //Intializing constructor
		public Jquery(WebDriver driver) {
			this.driver = driver;
		}
		//Entering source location
		public void scrollingPage(WebDriver driver) 
		{
			
		
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				waitForExpectedElement(driver, SCROLLING);
				//Find element by link text and store in variable "Element"        		
		        WebElement Element = driver.findElement(SCROLLING);

		        //This will scroll the page till the element is found		
		        js.executeScript("arguments[0].scrollIntoView();", Element);

	
		}
		
		public void  jqueryChapterListLinks(WebDriver driver) throws InterruptedException{
			List<WebElement> Links=driver.findElements(CHAPTERLISTLINKS);
		    List<String> all_elements_text=new ArrayList<String>();

		    for(WebElement e : Links){
		    	all_elements_text.add(e.getText());
		    	System.out.println(all_elements_text);
		    }
			  
	        // Appending the new element at the end of the list 
	      /*  for (int i=0; i<=Links.size(); i++) {
	        	all_elements_text.add(Links.get(i).getText()); 
	      //  System.out.println(Links.get(i).getText());
	       // System.out.println(all_elements_text);
	       // System.out.println(Links.get(i).getAttribute("href"));
	        
		}*/
	       for(int i=0;i<Links.size();i++) {
	        	WebElement variable=driver.findElement(By.linkText(all_elements_text.get(i)));
	        	variable.click();
	        	Thread.sleep(2000);
			    System.out.println( driver.getTitle());
			    System.out.println(driver.getCurrentUrl());
		        driver.navigate().back();
	        }
			
	          
	        }
		
		public void  jqueryRecentUpdateListLinks(WebDriver driver) throws InterruptedException{
			List<WebElement> Links=driver.findElements(RECENTUPDATELINKS);
		    List<String> all_elements_text=new ArrayList<String>();

		    for(WebElement e : Links){
		    	all_elements_text.add(e.getText());
		    	System.out.println(all_elements_text);
		    }
			  
	        // Appending the new element at the end of the list 
	      /*  for (int i=0; i<=Links.size(); i++) {
	        	all_elements_text.add(Links.get(i).getText()); 
	      //  System.out.println(Links.get(i).getText());
	       // System.out.println(all_elements_text);
	       // System.out.println(Links.get(i).getAttribute("href"));
	        
		}*/
	       for(int i=0;i<Links.size();i++) {
	        	WebElement variable=driver.findElement(By.linkText(all_elements_text.get(i)));
	        	variable.click();
	        	Thread.sleep(2000);
			    System.out.println( driver.getTitle());
			    System.out.println(driver.getCurrentUrl());
		        driver.navigate().back();
	        }
			
	          
	        }
				
				/*System.out.println(li.getText());
				li.click();*/
			
}

