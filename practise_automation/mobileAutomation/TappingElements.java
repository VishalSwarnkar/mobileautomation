package mobileAutomation;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;

public class TappingElements {
	
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
//		capability.setCapability(CapabilityType.BROWSER_NAME, "");
		
		// Mobile OS version. In My case its running on Android 4.2
//		capability.setCapability(CapabilityType.VERSION, "4.2");
		capability.setCapability("app", app.getAbsolutePath());

		// To Setup the device name
		capability.setCapability("deviceName", "Nexus_6_API_23");
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "6.0");
		
		// set the package name of the app
		capability.setCapability("appPackage", "com.example.android.contactmanager");
//		capability.setCapability("appPackage", "com.android.settings");
		
		// set the Launcher activity name of the app
		capability.setCapability("appActivity", ".ContactManager");
//		capability.setCapability("appActivity", "com.android.settings.Settings");
		
		// driver object with new Url and Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws MalformedURLException {
//		WebDriverWait wait = new WebDriverWait(driver, 300);
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.android.contactmanager:id/addContactButton")));
		
		System.out.println("App launched");
		// locate Add Contact button and click it
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().checkable(true)").getText());
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")").click();
		
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").textStartsWith(\"Sav\")").getText());
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").textStartsWith(\"Sav\")").isDisplayed();
		
//		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Spinner\")")
		List<WebElement> textFields = driver.findElementsByClassName("android.widget.Spinner");
		textFields.get(1).click();
		
		List<WebElement> contentList = driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.CheckedTextView\")");
		
		for(WebElement contentItem: contentList) {
			System.out.println("List of the items :: "+contentItem.getText());
		}
		
		
		// find the elements within the container
		
//		WebElement sub_categories = (WebElement) driver.findElementsById("com.android.settings:id/category_title").get(1);
//		System.out.println(sub_categories.getText());
//		
//		List<WebElement> settings_page = driver.findElementsById("com.android.settings:id/dashboard");
//		
//		for(WebElement elements: settings_page) {
//			System.out.println(elements.getText());
//		}
//		
//		List<WebElement> menu_lists = sub_categories.findElements(By.id("com.android.settings:id/title"));
//		
//		for(WebElement menu_item: menu_lists) {
//			System.out.println(menu_item.getText());
//		}
		
		
		
		
//		driver.findElementById("com.example.android.contactmanager:id/addContactButton").click();
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
