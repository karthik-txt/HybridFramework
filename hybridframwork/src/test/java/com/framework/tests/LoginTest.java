/**
 * 
 */
package com.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework.pages.Baseclass;
import com.framework.pages.Loginpage;
import com.framework.utility.Browserfactory;

/**
 * @author karthik
 *
 */
public class LoginTest extends Baseclass {

	
	@Test
	public void Loginpage() {
		logger=report.createTest("entered orangehrm webpage");
		Loginpage login=PageFactory.initElements(driver, Loginpage.class);
		logger.info("entering username and password");
		login.loginToOrangehrmlive(data.getStringdata("Login", 0, 0), data.getStringdata("Login", 0, 1));
		logger.pass("login successsfull");
	
	}
}
