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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;

//public class AppiumTest {
//  @Test
//  public void f() {
//  }
//}

//package test;

public class AppiumTest {
//	WebDriver driver;
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
		capability.setCapability(CapabilityType.BROWSER_NAME, "");
		
		// Mobile OS version. In My case its running on Android 4.2
		capability.setCapability(CapabilityType.VERSION, "4.2");
		capability.setCapability("app", app.getAbsolutePath());

		// To Setup the device name
		capability.setCapability("deviceName", "Galaxy_Nexus_API_27");
		capability.setCapability("platformName", "Android");
		
		// set the package name of the app
		capability.setCapability("app-package", "com.example.android.contactmanager-1");
		
		// set the Launcher activity name of the app
		capability.setCapability("app-activity", ".ContactManager");
		
		// driver object with new Url and Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws MalformedURLException {

		System.out.println("App launched");
		// locate Add Contact button and click it
//		WebElement addContactButton = driver.findElement(By.className("android.widget.Button"));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.Button")));
		
		WebElement addContactButton = driver.findElementByClassName("android.widget.Button");
		
		
		
		addContactButton.click();
		// locate input fields and type name and email for a new contact and save it
		List<WebElement> textFields = driver.findElementsByClassName("android.widget.EditText");
		
		textFields.get(0).sendKeys("Neeraj Test");
		textFields.get(1).sendKeys("9999999999");
		textFields.get(2).sendKeys("testemail@domain.com");
		driver.findElement(By.className("android.widget.Button")).click();
		// insert assertions here
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
