/**
 * 
 */
package com.framework.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author karthik
 *
 */
public class Helper {

	
	public static String getscreenshot(WebDriver driver,String screenshot) {
		
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"./screenshots/"+screenshot+getcurrentdate()+".png";
		try {
			FileHandler.copy(Source, new File(path));
		} catch (IOException e) {
			System.out.println("capture image:"+e.getMessage());
		}
		return path;
	}
	
	public static String getcurrentdate() {
		DateFormat customdate=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		return customdate.format(date);
		
	}
}
