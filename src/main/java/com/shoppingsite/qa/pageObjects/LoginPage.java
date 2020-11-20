package com.shoppingsite.qa.pageObjects;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shoppingsite.qa.base.TestBase;

public class LoginPage extends TestBase {
  
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath=(""))
	@CacheLookup
	WebElement captchaTextBox;
	
	@FindBy(id="button1")
	@CacheLookup
	WebElement loginButton;
	
	public LoginPage() {
	  PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public void enterCaptcha() {
		String str =JOptionPane.showInputDialog("Enter Your Captcha");
		captchaTextBox.sendKeys(str);
	}
	
	public SearchPage login(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		enterCaptcha();
		loginButton.click();
		return  new SearchPage();
	}
	
}
