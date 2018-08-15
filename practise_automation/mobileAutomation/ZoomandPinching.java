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

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

import static io.appium.java_client.touch.offset.PointOption.point;

public class ZoomandPinching {
	
	AndroidDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 30);

	@BeforeClass
	public void setUp() throws MalformedURLException {

		File app = new File("/Users/swarnv01/Downloads/Android APKS", "com.davemorrissey.labs.subscaleview.sample 2.apk");
		
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
		capability.setCapability("app-package", "com.davemorrissey.labs.subscaleview.sample");
		capability.setCapability("app-activity", "com.davemorrissey.labs.subscaleview.sample/.MainActivity");

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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/action_bar_title")));
	
		WebElement basicFeatureButton = driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures");
		basicFeatureButton.click();
		
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView")));
		
		WebElement image = driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/imageView");
		
		int x = image.getLocation().getX() + image.getSize().getWidth() / 2;
		int y = image.getLocation().getY() + image.getSize().getHeight() / 2;
		
		
		TouchAction  touchAction01 = new TouchAction(driver);
		touchAction01.press(point(x, y - 20)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(point(x,y-100)).release();
		
		TouchAction touchAction02 = new TouchAction(driver);
		touchAction02.press(point(x, y+20)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(point(x, y+100)).release();
		
		
		
		
	    MultiTouchAction  multiTouchAction = new MultiTouchAction(driver);
	    
	    multiTouchAction.add(touchAction01).add(touchAction02).perform();
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
