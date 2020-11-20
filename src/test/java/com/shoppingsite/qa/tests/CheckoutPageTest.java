package com.shoppingsite.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.shoppingsite.qa.base.TestBase;
import com.shoppingsite.qa.pageObjects.CheckoutPage;
import com.shoppingsite.qa.pageObjects.LoginPage;
import com.shoppingsite.qa.pageObjects.SearchPage;

public class CheckoutPageTest extends TestBase{
 
	LoginPage loginPage;
	SearchPage searchPage;
    CheckoutPage checkoutPage;
    
	public CheckoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		   searchPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		   checkoutPage = new CheckoutPage();
	}
	
	// Can have number of test cases 
	// validate actual price and expected 
	// validate title
	// verify you goto Payment page.
	
	
	@AfterMethod
	public void tearDown() {
	 driver.quit();
	}
}
