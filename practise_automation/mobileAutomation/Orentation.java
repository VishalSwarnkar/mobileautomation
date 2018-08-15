package mobileAutomation;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.ScreenOrientation;
import io.appium.java_client.android.AndroidDriver;

public class Orentation {
	
	AndroidDriver driver;
	ScreenOrientation screen;
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
	public void testApp() throws MalformedURLException, InterruptedException {
		System.out.println("App launched");
		
		screen = ScreenOrientation.LANDSCAPE;
		driver.execute(DriverCommand.SET_SCREEN_ORIENTATION, ImmutableMap.of("orientation",screen.value().toUpperCase()));
		
		Thread.sleep(1000);
		
		screen = ScreenOrientation.PORTRAIT;
		driver.execute(DriverCommand.SET_SCREEN_ORIENTATION, ImmutableMap.of("orientation",screen.value().toUpperCase()));
		
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
