package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy (linkText=("My Account"))
	private WebElement MyAccountDropMenue;
	
	@FindBy(linkText="Login")
	private WebElement LoninButton;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailfield;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement Submitbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement EmailpasswordNotMtchingMessage;
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public void myaccount() {
		MyAccountDropMenue.click();
	}
	public void lonin() {
		LoninButton.click();
	}
	public void sendemail(String emailtext) {
		emailfield.sendKeys(emailtext);
	}
	
	public void sendpassword(String passwordtext) {
		emailfield.sendKeys(passwordtext);
	}
	public void ClickonSubmitButton() {
		Submitbutton.click();
	}
	public String warningmessageText() {
		String gettext=EmailpasswordNotMtchingMessage.getText();
		return gettext;
	}
	
	
	

}
