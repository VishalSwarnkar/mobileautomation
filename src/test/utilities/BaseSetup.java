package test.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseSetup {
	public static AppiumDriver<WebElement> driver;
	static InputStream input = null;
	public static Properties prop = null;
	
	ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;
	
	@BeforeClass
	public void setup() throws MalformedURLException, IOException{
		String class_name = this.getClass().getName();		
        
		prop = loadConfigs();
		
		if(class_name.equals("tests.FlipkartLoginAndSearchTest")) {
            		androidSetup(prop);
        } else {
            if (class_name.equals("tests.AmazonWebProductSearch")) {
                webSetup(prop);
            }
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public AppiumDriver<WebElement> getDriver() {  
        return driver;
    }
    
    public DesiredCapabilities commonCap(Properties prop) {
		
    		// To create an object of Desired Capabilities
    		DesiredCapabilities capability = new DesiredCapabilities();
    		capability.setCapability("device", prop.getProperty("device"));
    		capability.setCapability(CapabilityType.VERSION, "4.2");
    		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
    		capability.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("device_name"));
    		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 4000);
    		return capability;
    }
    
	public void androidSetup(Properties prop) throws MalformedURLException {
	
		DesiredCapabilities capability = commonCap(prop);
		
		capability.setCapability("appPackage", prop.getProperty("native_package_name"));
		capability.setCapability("appActivity", prop.getProperty("native_activity_name"));
		
		try
        {
			// driver object with new Url and Capabilities
            driver = new AppiumDriver(new URL(prop.getProperty("driver_url")), capability);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        catch (NullPointerException | MalformedURLException ex) {
            throw new RuntimeException("appium driver could not be initialised for device ");
        }
        
		Reporter.log("Driver in android setup: "+driver);
		
	}
	
	public void webSetup(Properties prop) throws MalformedURLException {
		DesiredCapabilities capability = commonCap(prop);
		
		System.out.println(prop.getProperty("chrome_package_name"));
		
		capability.setCapability("appPackage", prop.getProperty("chrome_package_name"));
		capability.setCapability("appActivity", prop.getProperty("chrome_activity_name"));
		capability.setCapability(CapabilityType.BROWSER_NAME, prop.getProperty("browsername"));

		try
        {
			// driver object with new Url and Capabilities
            driver = new AppiumDriver(new URL(prop.getProperty("driver_url")), capability);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        catch (NullPointerException | MalformedURLException ex) {
            throw new RuntimeException("appium driver could not be initialised for device ");
        }
		Reporter.log("Driver in web setup: "+driver);
		
	}
	
	public static Properties loadConfigs() throws IOException {
    			File src = new File(".properties");
    			// Create  FileInputStream object
    			FileInputStream fis=new FileInputStream(src);
    			// Create Properties class object to read properties file
    			Properties pro=new Properties();
    			// Load file so we can use into our script
    			pro.load(fis);
    			return pro;
    }
	
	@AfterClass
    public void tearDown() throws Exception{
		Reporter.log("\nTearing Down Driver.");
        driver.quit(); // web application
    }
}
