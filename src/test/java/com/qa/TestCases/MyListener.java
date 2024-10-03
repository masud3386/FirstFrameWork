package com.qa.TestCases;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.TestBases.Base;

public class MyListener extends Base implements ITestListener{

	public MyListener() throws IOException {
		super();
		
	}
	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports extent;
	public static ExtentTest test;


	@Override
	public void onStart(ITestContext context) {
		sparkreporter = new ExtentSparkReporter("./ExtendReport/Myreport" + datandtime() + ".html");
		sparkreporter.config().setDocumentTitle("Automaiton report");
		sparkreporter.config().setReportName("Finctional testoing");
		sparkreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("cmputername", "localhost");
		extent.setSystemInfo("emvironment", "QA");
		extent.setSystemInfo("Testername", "Masud");
		extent.setSystemInfo("os", "windows 10");
		extent.setSystemInfo("Browser name", "chrome");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test cases PASS  " + result.getName());

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Base.screenshot(result.getMethod().getMethodName());
		
		logger.info("Screen shot was taken for failed test cases");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		logger.info("Extent reported was generated");
	}
	

}
