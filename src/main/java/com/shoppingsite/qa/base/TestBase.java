package com.shoppingsite.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.shoppingsite.qa.util.TestUtil;
import com.shoppingsite.qa.util.TestListener;

public class TestBase {
 
	 public static WebDriver driver;
	 public static Properties prop;
	 public  static EventFiringWebDriver e_driver;
	 public static TestListener eventListener;
	 
	 public TestBase() {
		 try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("/Users/Spurious/eclipse-workspace/ShoppingSiteTest/src/main/java/"+"/com/shoppingsite/qa/config/config.properties");
				prop.load(ip);
			} catch(FileNotFoundException e)	{
				e.printStackTrace();
			}catch(IOException e) {
				
			}
	 }
	 @Parameters("myBrowser")
	 public static void initialization(String myBrowser) {
		  // String browsername =	prop.getProperty("browser");
		   if(myBrowser.equals("chrome")) {
			   ChromeOptions opt = new ChromeOptions();
			   opt.addArguments("start-maximized");
			   opt.addArguments("--disable-notifications--");
			   opt.addArguments("--disable-infobars");
			   System.setProperty("webdriver.chrome.driver", "/Users/Spurious/eclipse-workspace/ShoppingSiteTest/chromedriver.exe");
		       driver = new ChromeDriver(opt);
		   }
		   else if(myBrowser.equals("firefox")){
			   System.setProperty("webdriver.gecko.driver","/Users/Spurious/eclipse-workspace/ShoppingSiteTest/geckodriver.exe");
		   }
		   
		   driver.manage().window().maximize();
		   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		   driver.get(prop.getProperty("url"));
		   
		 
	 }
	   
}
