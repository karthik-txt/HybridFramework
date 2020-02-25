/**
 * 
 */
package com.framework.pages;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.utility.Browserfactory;
import com.framework.utility.ExcelDataprovider;
import com.framework.utility.Helper;
import com.framework.utility.configreader;


/**
 * @author karthik
 *
 */
public class Baseclass {

	
	public WebDriver driver;
	public ExcelDataprovider data;
	public configreader config;
	public ExtentReports report;
	public ExtentTest logger;
	public Logger log;
	
	@BeforeSuite
	public void startsettingsuite() {
	log=Logger.getLogger("Baseclass");
	log.info("setting up Report and getting test started");
	data=new ExcelDataprovider();
	config=new configreader();
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/oranghrmlive"+Helper.getcurrentdate()+".html"));
	report=new ExtentReports();
	report.attachReporter(extent);
	log.info("setting done test started");
	}
	
	@Parameters({"browser","urltobetested"})
	@BeforeClass
	public void startbrowser(String browser,String urltobetested) {
		log.info("Browser was started and enter into Application");
		driver=Browserfactory.startApplication(driver,browser,config.geturl());
		log.info("Application was up and running");
	}
	
	@AfterClass
	public void teardown() {
		log.info("closing the browser");
		Browserfactory.quitbrowser(driver);
	}
	
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException {
		log.info("Test is ready to end");
		if(ITestResult.FAILURE==result.getStatus()) {
			
			logger.fail("Test fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getscreenshot(driver, result.getName())).build());
		}
		else if(ITestResult.SUCCESS==result.getStatus()) {
			logger.pass("Test pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getscreenshot(driver, result.getName())).build());
		}
		report.flush();
		log.info("reports generated");
	}
}
