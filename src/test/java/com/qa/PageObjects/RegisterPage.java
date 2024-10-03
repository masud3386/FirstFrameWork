package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	@FindBy(linkText="Register")
	private WebElement registerDropMenue;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstnamefield;
	
	public void enterfirstName(String firstnametext) {
		firstnamefield.sendKeys(firstnametext);
	}
	
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement laststnamefield;
	
	public void enterlaststName(String laststnametext) {
		firstnamefield.sendKeys(laststnametext);
	}
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement phonefield;
	
	public void enterphoneNumber(String phoneNumber) {
		phonefield.sendKeys(phoneNumber);
	}
	
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmpasswordfield;
	
	public void confirmpassword(String conpasswordText) {
		confirmpasswordfield.sendKeys(conpasswordText);
	}
	
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreebutton;
	
	public void clickonAgreebutton() {
		agreebutton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickonRegistration() {
		registerDropMenue.click();
	}
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
