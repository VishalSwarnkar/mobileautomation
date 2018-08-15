package mobileAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;

public class FindElementsSettings {
	
	AndroidDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 30);

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// To create an object of Desired Capabilities
		DesiredCapabilities capability = new DesiredCapabilities();
		
		// OS Name
		capability.setCapability("device", "Android");
		capability.setCapability(CapabilityType.BROWSER_NAME, "");
		
		// Mobile OS version. In My case its running on Android 4.2
		capability.setCapability(CapabilityType.VERSION, "4.2");

		// To Setup the device name
		capability.setCapability("deviceName", "Nexus_6_API_23");
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "6.0");

		capability.setCapability("appPackage", "com.android.settings");
		capability.setCapability("appActivity", "com.android.settings.Settings");
		
		// driver object with new Url and Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.settings:id/dashboard")));
		
		System.out.println("App launched");
		// locate Add Contact button and click it
//		WebElement addContactButton = driver.findElement(By.className("android.widget.Button"));
		
		List<WebElement> textFields = driver.findElementsById("com.android.settings:id/title");
		
		for(WebElement linktext: textFields) {
			if(linktext.getText().equals("Battery")) {
				linktext.click();
			}
		}
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
