package com.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.PageObjects.HomePage;
import com.qa.PageObjects.RegisterPage;
import com.qa.TestBases.Base;
import com.qa.Utils.Utilities;

public class Register extends Base {
	public Register() throws IOException {
		super();

	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		logger.info("Set up method was excuted");
		driver = launchBrowser(prop.getProperty("BrowserName"));
		logger.info("Browser was launched");
		HomePage homepage=new HomePage(driver);
		homepage.myaccount();
		logger.info("my account menu was selected");
		RegisterPage rigistrpage=new RegisterPage(driver);
		rigistrpage.clickonRegistration();
		logger.info("Registration button was clicked");
		
	}

	@AfterMethod

	public void closeBrowser() {
		driver.quit();
		logger.info("Browser was closed");
	}

	@Test
	public void makeRegister() {
		
		RegisterPage rigistrpage=new RegisterPage(driver);
		rigistrpage.enterfirstName(prop.getProperty("firstname"));
		rigistrpage.enterlaststName(prop.getProperty("lastname"));
		HomePage homepage=new HomePage(driver);
		homepage.sendemail(Utilities.newEmail());
		rigistrpage.enterphoneNumber(prop.getProperty("phoneNumber"));
		homepage.sendpassword(prop.getProperty("password"));
		rigistrpage.confirmpassword(prop.getProperty("password"));
		rigistrpage.clickonAgreebutton();
		homepage.ClickonSubmitButton();
		
	

}
}
