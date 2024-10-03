package com.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.PageObjects.HomePage;
import com.qa.TestBases.Base;
import com.qa.Utils.Utilities;

public class Login extends Base {
	

	public Login() throws IOException {
		
		super();

	}

	WebDriver driver;
	

	@BeforeMethod
	public WebDriver setup() {
		logger.info("My browser was launched succesfully");
		driver = launchBrowser(prop.getProperty("BrowserName"));
		HomePage homepage=new HomePage(driver);
		homepage.myaccount();
		logger.info("Myaccount menu was selected");
		homepage.lonin();
		logger.info("login menue was selected");
		
		return driver;
		

	}

	@AfterMethod

	public void closeBrowser() {
		driver.quit();
	}

	@Test(priority = 1,dataProvider = "valicredential")
	public void validlogin(String mail,String pass) {
		
		HomePage homepage=new HomePage(driver);
		homepage.sendemail(mail);
		logger.info("Email text was send");
        homepage.sendpassword(pass);
        logger.info("Password was entered");
        homepage.ClickonSubmitButton();
        logger.info("Submitt button was clicked");
		

	}

	@DataProvider(name = "valicredential")
	public Object[][] suplyTestData() {

		Object[][] data = Utilities.gettestData("login");
		return data;
		
	}

	@Test(priority = 2)
	public void invaludLogin() {
		
		HomePage homepage=new HomePage(driver);
		homepage.sendemail(Utilities.newEmail());
        homepage.sendpassword(prop.getProperty("invalidpassword"));
        homepage.ClickonSubmitButton();
		String actualmessage = homepage.warningmessageText();
		String expectedmessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualmessage.contains(expectedmessage));

	
		
			
		
}
}
