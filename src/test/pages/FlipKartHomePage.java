package test.pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import test.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import test.pages.FlipKartLoginPage;
import test.utilities.CommonMethods;

public class FlipKartHomePage extends Driver{   
    
    Properties pro;
    WebDriverWait wait;
    CommonMethods common;
    
    private By mobilenofield = By.id("com.flipkart.android:id/mobileNo");
    private By loginBtn = By.id("com.flipkart.android:id/btn_mlogin");
    private By singnup = By.id("com.flipkart.android:id/btn_msignup");
    
    public FlipKartHomePage() throws Exception {
    		super();
    		common = new CommonMethods();
    }
    
    public WebElement isMobileFieldPresent() throws TimeoutException {
    			return common.getObject(mobilenofield);
    }
    
    public String getPageTitle() throws TimeoutException {
    		return common.getPageTitle();
    }
    
    public WebElement isHomePageLoginButtonPresent() throws TimeoutException {
    		return common.getObject(loginBtn);
    }
    
    
    public FlipKartLoginPage clickToSignIn() throws Exception{		
    		common.clickOnElement(loginBtn);
		return new FlipKartLoginPage();
    }
    
}
