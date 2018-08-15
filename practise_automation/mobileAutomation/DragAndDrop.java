package mobileAutomation;


import static io.appium.java_client.touch.offset.PointOption.point;

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
import org.testng.internal.TestResult;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

public class DragAndDrop {
	
	AndroidDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 30);

	@BeforeClass
	public void setUp() throws MalformedURLException {

		File app = new File("/Users/swarnv01/Downloads/Android APKS", "com.hmh.api.apk");
		
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
//		capability.setCapability("app-package", "");
//		capability.setCapability("app-activity", "net.one97.paytm/.AJRJarvisSplash");

//		capability.setCapability("appPackage", "com.android.settings");
//		capability.setCapability("appActivity", "com.android.settings.Settings");
		
		// driver object with new Url and Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws MalformedURLException {
		System.out.println("App launched");
		
		List<WebElement> menu_list = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")");
		
		menu_list.get(12).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/text1")));
	
		
		List<WebElement> submenu_list = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")");
		
		submenu_list.get(10).click();
		
		WebElement dragElement = driver.findElementById("com.example.android.apis:id/drag_dot_1");
		System.out.println(dragElement.getLocation());
		WebElement dropElement = driver.findElementById("com.example.android.apis:id/drag_dot_2");
		System.out.println(dropElement.getLocation());
		
		
		new TouchAction(driver).longPress(point(0, 460)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(point(554, 460)).release().perform();
		
		WebElement textResult = driver.findElementById("com.hmh.api:id/drag_result_text");
		System.out.println("Result " + textResult.getText());
		
		
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
