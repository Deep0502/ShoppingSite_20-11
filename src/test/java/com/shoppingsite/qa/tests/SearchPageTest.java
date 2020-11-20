package com.shoppingsite.qa.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.shoppingsite.qa.ExtentReport.ExtentTestManager;
import com.shoppingsite.qa.base.TestBase;
import com.shoppingsite.qa.pageObjects.CheckoutPage;
import com.shoppingsite.qa.pageObjects.LoginPage;
import com.shoppingsite.qa.pageObjects.SearchPage;

public class SearchPageTest extends TestBase{
	
	LoginPage loginPage;
	SearchPage searchPage;
	CheckoutPage checkoutPage;
	Logger log = Logger.getLogger(SearchPageTest.class);
	
	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    loginPage = new LoginPage();
	   searchPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	   checkoutPage = new CheckoutPage();
	}
	
	@Test
	public void testProductSearch(Method method) {
		ExtentTestManager.startTest(method.getName(),"Product searched.");
		searchPage.searchProduct();
		String searchResult = searchPage.getSearchedResultText();
		Assert.assertEquals(searchResult, "Showing results for Products","search result text failed");
	}
	
	@Test
	public void testProductaddedToCart(Method method) {
		// you can take it from different data source too // here i have hardcoded
		ExtentTestManager.startTest(method.getName(),"Products added to cart.");
		int quantity = 3;
		int totalProduct =searchPage.addMoreProductsToCart(3);
		Assert.assertEquals(totalProduct, quantity);
	}
	
	@Test
	public void gotoCheckOutTest() {
	  
	  checkoutPage = searchPage.clickOnCheckOutButton();
	  log.info(" CheckOut Page now");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
