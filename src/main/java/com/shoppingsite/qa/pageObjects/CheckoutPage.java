package com.shoppingsite.qa.pageObjects;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shoppingsite.qa.base.TestBase;

public class CheckoutPage extends TestBase{
 
	@FindBy(name="name")
	@CacheLookup
	WebElement nameTextBox;
	
	@FindBy(xpath="")
	WebElement chosenProductquantity;
	
	@FindBy(xpath="")
	WebElement price;
	
	@FindBy(xpath="")
	WebElement finalAmountbox;
	
	@FindBy(name="mobileNumber")
	@CacheLookup
	WebElement mobileTextBox;
	
	@FindBy(name="address")
	@CacheLookup
	WebElement addressTextBox;
	
	@FindBy(xpath="")
	WebElement getQuantityValue;
	
	@FindBy(id="submit")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(id="otp")
	@CacheLookup
	WebElement otpBtn;
	
	@FindBy(id="Pay")
	@CacheLookup
	WebElement payBtn;
	
	public CheckoutPage() {
	      PageFactory.initElements(driver, this);
		}
	
	public boolean  checkFinalAmount() {
		boolean isAmountMatch = false;
		float actualFinalPrice =0;
		try {
		   String actualPrice = price.getText();
		   String quantity = getQuantityValue.getText();
		   String finalAmount=finalAmountbox.getText();
		   float actPrice = Float.valueOf(actualPrice);
		   int quant = Integer.valueOf(quantity);
		   actualFinalPrice =  actPrice*quant;
		   if(actualFinalPrice==Float.valueOf(finalAmount)) {
			   isAmountMatch =true;
		   }
		}
		catch(ArithmeticException e){
			System.out.print("Exception in checkfinalAmount");
		}
		return isAmountMatch;
	}
	
	public void clickSubmit() {
		nameTextBox.sendKeys("Rahul Sharma");
		mobileTextBox.sendKeys("9134568979");
		addressTextBox.sendKeys("Beverly Hills");
		submitBtn.click();
	}
	public void getOtp() {
		otpBtn.click();
	}
	
	public void enterOtpandClickPay() {
		final JDialog dialog = new JDialog();
	    dialog.setAlwaysOnTop(true);
	    String otp = JOptionPane.showInputDialog(dialog, "Please enter your one time password", "Enter otp", JOptionPane.INFORMATION_MESSAGE);
	    payBtn.click();	
	}
	
}
