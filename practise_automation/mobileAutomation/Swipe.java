package mobileAutomation;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Swipe {
	
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
		capability.setCapability("deviceName", "Nexus_4_API_27");
		capability.setCapability("platformName", "Android");

		capability.setCapability("appPackage", "com.android.settings");
		capability.setCapability("appActivity", "com.android.settings.Settings");
		
		// driver object with new Url and Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws MalformedURLException {
		System.out.println("App launched");
		WebDriverWait wait = new WebDriverWait(driver, 300);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.settings:id/dashboard_tile")));
		
//		WebElement scroll = driver.findElementByAndroidUIAutomator("new UiSelector(new UiSelector().resourceId(\"com.android.settings:id/title\")).scrollIntoView(\"new UiSelector().text(\"Battery\")\")");
//		
//		TouchAction action = new TouchAction(driver);
////		action.press(driver.findElementById("com.android.settings:id/title"));
//		action.press(PointOption.point(fromX, fromY))
//	    .moveTo(PointOption.point(offsetX, offsetY))
//	    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//	    .release()
//	    .perform();
		
		List<WebElement> title = driver.findElementsById("com.android.settings:id/title");
				
				int titlecount = title.size();
		
		WebElement lastElement = title.get(titlecount - 1);
		
		int xInitial = lastElement.getLocation().getX() + lastElement.getSize().getWidth()/2;
				int yInitial = lastElement.getLocation().getY() + lastElement.getSize().getHeight()/2;
				
				
				
//				action.press(xInitial, yInitial).moveTo(xInitial+90,yInitial).release().perform();
				TouchAction action = new TouchAction(driver); 
				action.press(lastElement).waitAction().moveTo(lastElement).release().perform();
		
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
