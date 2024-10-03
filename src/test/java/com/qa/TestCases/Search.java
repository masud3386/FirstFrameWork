package com.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.PageObjects.SearchPage;
import com.qa.TestBases.Base;

public class Search extends Base{
	
	public Search() throws IOException {
		super();
		
	}


	WebDriver driver;
	@BeforeMethod
	public WebDriver setup() {
		driver=launchBrowser(prop.getProperty("BrowserName"));
		logger.info("Browser succesfully lauched");
		
		return driver;
		
	}
	@AfterMethod

	public void closeBrowser() {
		driver.quit();
		logger.info("Browser closed succesfully");
	}
	
	
	@Test
	public void validSearch() {
		
		SearchPage searchpage=new SearchPage(driver);
		searchpage.itemsearch(prop.getProperty("searchitem"));
		logger.error("your testcase failed.");
		
	}

}
