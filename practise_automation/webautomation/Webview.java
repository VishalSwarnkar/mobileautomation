package webautomation;

import java.io.File;

import java.net.MalformedURLException;

import java.net.URL;

import java.time.Duration;

import java.util.List;

import java.util.Set;

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

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileDriver;

import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.WaitOptions;

import static io.appium.java_client.touch.offset.PointOption.point;

public class Webview {

	AppiumDriver<WebElement> driver;
//	AndroidDriver<WebElement> driver;

	// WebDriverWait wait = new WebDriverWait(driver, 30);

	@BeforeClass

	public void setUp() throws MalformedURLException {

		// To create an object of Desired Capabilities

		DesiredCapabilities capability = new DesiredCapabilities();

		// OS Name

		capability.setCapability("device", "Android");

		// Mobile OS version. In My case its running on Android 4.2

		capability.setCapability(CapabilityType.VERSION, "4.2");

		// To Setup the device name

		capability.setCapability("deviceName", "emulator-5554");

		capability.setCapability("platformName", "Android");

		capability.setCapability("appPackage", "com.android.chrome");

		capability.setCapability("appActivity", "com.google.android.apps.chrome.Main");

		capability.setCapability(CapabilityType.BROWSER_NAME, "chrome");

		// driver object with new Url and Capabilities

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);

		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

	}

	@Test

	public void testApp() throws MalformedURLException {

		System.out.println("App launched");

		WebDriverWait wait = new WebDriverWait(driver, 400);

		Set<String> contexts = driver.getContextHandles();

		System.out.println(contexts.size());

		for (String context : contexts) {

			System.out.println(context);

		}

		// driver.context("CHROMIUM");

		//

		driver.get("https://www.amazon.co.uk/");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-search-keywords")));

		// System.out.println(driver.getPageSource());

		// driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Portable
		// hard drive");

		driver.findElement(By.id("nav-search-keywords")).sendKeys("Hard drive");

		// driver.findElement(By.xpath(".//*[@type='submit']")).click();

		// WebDriverWait wait = new WebDriverWait(driver, 100);

		// WebElement element=
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));

		// element.sendKeys("phone");

		// driver.findElement(By.name("field-keywords")).sendKeys("iphone");

		// WebElement div = driver.findElement(By.name("q"));

		// driver.findElementById("android.widget.EditText").sendKeys("appium");

		// div.sendKeys("appium")

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
