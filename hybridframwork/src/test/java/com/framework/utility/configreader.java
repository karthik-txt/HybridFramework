/**
 * 
 */
package com.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author karthik
 *
 */
public class configreader {
	
	Properties pro;
	public configreader() {
		File source=new File("./configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(source);
				pro=new Properties();
				pro.load(fis);
		} catch (Exception e) {
			System.out.println("cannot able to read configuration data");
		} 
	
	}
	
	public String getconfigfromdata(String Keytosearch) {
		return pro.getProperty("Key to search");
	}
	
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String geturl() {
		return pro.getProperty("Qaurl");
	}
}
