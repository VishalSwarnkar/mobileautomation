package test.utilities;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class Driver extends BaseSetup{
	protected AppiumDriver<WebElement> driver;

    public Driver() {
        this.driver = super.getDriver();
    }
}