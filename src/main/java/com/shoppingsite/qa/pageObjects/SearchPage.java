package com.shoppingsite.qa.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shoppingsite.qa.base.TestBase;
import com.shoppingsite.qa.util.TestUtil;

public class SearchPage extends TestBase {
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement searchTextBox;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement checkoutBtn;
	
	@FindBy(id="")
	@CacheLookup
	WebElement divShowingResult;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement addMoreProduct;
	
	public SearchPage() {
      PageFactory.initElements(driver, this);
	}
	
	public void searchProduct() {
		searchTextBox.sendKeys("Search Product");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		//searchBtn.click();
	}
  
	public String getSearchedResultText() {
		return divShowingResult.getText();
	}
	
	public int addMoreProductsToCart(int quantity) {
		int counter = 0;
		for(int i=0;i<quantity;i++) {
			addMoreProduct.click();
			counter++;
		}
		return counter;
	}
	
	public CheckoutPage clickOnCheckOutButton() {
		checkoutBtn.click();
		return new CheckoutPage();
	}
	
}
