package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class PageBase {
	WebDriverWait wait;
	//TouchAction touchAction;
	public static Properties prop;
    
    public PageBase() throws Exception
	{
	try
	{
		prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/automation/config/config.Properties");

		System.getProperties();
		prop.load(fis);
	}
	catch(FileNotFoundException e )
	{
		e.printStackTrace();

	}
	}
    public void setup() throws Exception
    {
    	String deviceName=prop.getProperty("device");

//		
		
	 if(deviceName.contentEquals("Android"))
		{
			
	
		    //File app = new File("user.dir"+"/src/main/resources/app-debug.apk");
		    DesiredCapabilities ds = new DesiredCapabilities();

	       
	    		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	    	   // ds.setCapability("app", app.getAbsolutePath());

	    		ds.setCapability("platformName", "Android");
	    		ds.setCapability("platformVersion", "10.0");
	    		ds.setCapability("autoAcceptAlerts", true);
	    		
	    		
				AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), ds);
				
			    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		}
		else
		{
			System.out.println("Device name not matching");

		}
    }
}
