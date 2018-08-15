package mobileAutomation;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
//import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
//import io.appium.java_client.TouchAction;

public class FindElementsByUISelector {
	
	AndroidDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 30);

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// location of the app
		File app = new File("/Users/swarnv01/Downloads", "ContactManager.apk");

		// To create an object of Desired Capabilities
		DesiredCapabilities capability = new DesiredCapabilities();
		
		// OS Name
		capability.setCapability("device", "Android");
		
		// Mobile OS version. In My case its running on Android 4.2
		capability.setCapability("app", app.getAbsolutePath());

		// To Setup the device name
		capability.setCapability("deviceName", "Nexus_6_API_23");
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "6.0");
		
		// set the package name of the app
		capability.setCapability("appPackage", "com.example.android.contactmanager");
		
		// set the Launcher activity name of the app
		capability.setCapability("appActivity", ".ContactManager");
		
		// driver object with new Url and Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws MalformedURLException {
		
		System.out.println("App launched");

		WebElement tap_button = driver.findElementById("com.example.android.contactmanager:id/addContactButton");
//		tap_button.click();
		
		// perform long press activity on the element
		TouchAction action = new TouchAction((MobileDriver)driver);
//		action.longPress(element).perform();
//		action.press(tap_button).waitAction(2000).release().perform();		
		
	}
	
	@AfterTest
	public void aftertest() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
