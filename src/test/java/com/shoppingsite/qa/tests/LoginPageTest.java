package com.shoppingsite.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.shoppingsite.qa.ExtentReport.ExtentTestManager;
import com.shoppingsite.qa.base.TestBase;
import com.shoppingsite.qa.pageObjects.LoginPage;
import com.shoppingsite.qa.pageObjects.SearchPage;

import jdk.internal.org.objectweb.asm.commons.Method;

public class LoginPageTest extends TestBase {
 
	LoginPage loginPage;
	SearchPage searchPage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		//TestBase construct call ..
		super();
	}
	@BeforeMethod
	public void setUp() {
	  loginPage = new LoginPage();
	  searchPage = new SearchPage();
	}

    @Test (dependsOnMethods = { "loginTest" })
	public void loginPageTitleTest() {
      String title =loginPage.validateTitle();
      Assert.assertEquals(title, "MySite");
	}
	
	@Test(priority=2)
	public void loginTest(Method method) {
	ExtentTestManager.startTest(method.getName(),"Valid Login Scenario with right username and password.");

	 searchPage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	 log.info("Logged in to MySite");
	}
	
	@Test
	public void loginTestInvalid(Method method) {
		ExtentTestManager.startTest(method.getName(),"Invalid Login Scenario with empty username and password.");	
		searchPage =loginPage.login("", "");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
