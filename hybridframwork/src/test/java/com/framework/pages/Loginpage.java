/**
 * 
 */
package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.framework.utility.Browserfactory;

/**
 * @author karthik
 *
 */
public class Loginpage {

	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(id="txtUsername")
	@CacheLookup
	WebElement Username;
	
	@FindBy(id="txtPassword")
	@CacheLookup
	WebElement Password;
	
	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement Login_button;
	
	
	public void loginToOrangehrmlive(String username,String password) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Username.sendKeys(username);
		Password.sendKeys(password);
		Login_button.click();
		
	}
}
