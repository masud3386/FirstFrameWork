package com.qa.TestBases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Utils.Utilities;

public class Base {
    static WebDriver driver;
	public Properties prop;
	public  Logger logger;
	

	public Base() throws IOException {
		
		logger=LogManager.getLogger(this.getClass());
		prop = new Properties();
		File profile = new File("./src/main/java/com/qa/Config/config.properties");
		FileInputStream fis = new FileInputStream(profile);
		prop.load(fis);
		
	}

	public WebDriver launchBrowser(String browser) {
		
		

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.WaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageloadTime));
		driver.get(prop.getProperty("url"));
		return driver;

	}

	public static void screenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File("./Screenshot/masud" + " " + filename + datandtime() + ".png");
		sourcefile.renameTo(targetfile);
	}
	
	
	
	public static String datandtime() {
		Date date = new Date();
		return date.toString().replace(" ", "-").replace(":", "-");

	}

}
