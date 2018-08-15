package mobileAutomation;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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
import io.appium.java_client.touch.WaitOptions;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SwipeScreen {
	
	AndroidDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 30);

	@BeforeClass
	public void setUp() throws MalformedURLException {

		File app = new File("/Users/swarnv01/Downloads/Android APKS", "net.one97.paytm.apk");
		
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
		
		capability.setCapability("app", app.getAbsolutePath());
		capability.setCapability("app-package", "net.one97.paytm");
		capability.setCapability("app-activity", "net.one97.paytm/.AJRJarvisSplash");

//		capability.setCapability("appPackage", "com.android.settings");
//		capability.setCapability("appActivity", "com.android.settings.Settings");
		
		// driver object with new Url and Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws MalformedURLException {
		System.out.println("App launched");
		WebDriverWait wait = new WebDriverWait(driver, 400);
//		WebElement addContactButton = driver.findElement(By.className("android.widget.Button"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("net.one97.paytm:id/lyt_help_overlay")));
		WebElement overlay = (WebElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"net.one97.paytm:id/lyt_help_overlay\")");
		
//		WebElement overlay = driver.findElementById("net.one97.paytm:id/lyt_help_overlay");
		overlay.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("net.one97.paytm:id/txt_tab")));
		
		
		
		
		System.out.println(driver.manage().window().getSize().getWidth());
		System.out.println(driver.manage().window().getSize().getHeight());
		
		int screenWidth = driver.manage().window().getSize().getWidth();
		int screenHeight = driver.manage().window().getSize().getHeight();
		
		int xStart = screenWidth * 8/9;
		int xEnd = screenHeight / 9;
		int yStart = screenHeight / 2;
		int yEnd = screenHeight / 2;
		
//		new TouchAction(driver).longPress(point(xStart, yEnd)).release().perform();
		new TouchAction(driver).press(point(xStart, yStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(point(xEnd, yEnd)).release().perform();
		
//		xStart = screenWidth / 5;
//		xEnd = screenHeight * 4/5;
		yStart = screenHeight / 2;
		yEnd = screenHeight / 2;
		
		new TouchAction(driver).press(point(xEnd, yEnd)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(point(xStart, yStart)).release().perform();
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
