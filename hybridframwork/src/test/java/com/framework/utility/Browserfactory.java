/**
 * 
 */
package com.framework.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author karthik
 *
 */
public class Browserfactory {

	public static WebDriver startApplication(WebDriver driver,String browsername,String url) {
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Browserdriver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Browserdriver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", "./Browserdriver/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	public static void quitbrowser(WebDriver driver) {
		driver.quit();
	}
}
