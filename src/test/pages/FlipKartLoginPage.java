package test.pages;

import test.utilities.CommonMethods;
import test.utilities.Driver;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.pages.FlipkartSearchPage;

public class FlipKartLoginPage extends Driver{
	
	public static WebDriverWait wait;
	CommonMethods common;
	
	private By mobilenofield = By.id("com.flipkart.android:id/mobileNo");
	private By passwordField = By.id("com.flipkart.android:id/et_password");
	private By loginBtn = By.id("com.flipkart.android:id/btn_mlogin");
	private By singupLnk = By.id("com.flipkart.android:id/btn_msignup");
	private By cancelBtn = By.id("com.google.android.gms:id/cancel");
    
    public FlipKartLoginPage() throws Exception {
    		super();
    		common = new CommonMethods();
    }
    

//    public Boolean isMobileFieldPresent() {
////		wait.until(ExpectedConditions.visibilityOf(loginpage.mobilenofield));
//		return loginpage.mobilenofield.isDisplayed();
//    }
//    
//	public Boolean isPasswordFieldPresent() {
////		wait.until(ExpectedConditions.visibilityOf(loginpage.passwordField));
//		return loginpage.mobilenofield.isDisplayed();
//	}
//	
//	public String getSinginBtnText() {
////		wait.until(ExpectedConditions.visibilityOf(loginpage.loginBtn));
//		return loginpage.loginBtn.getText();
//	}
//	
//	public Boolean isSingupLinkPresent() {
////		wait.until(ExpectedConditions.visibilityOf(loginpage.singupLnk));
//		return loginpage.singupLnk.isDisplayed();
//	}

	public FlipkartSearchPage enterUserCridentials(String sUsername, String sPassword) throws Exception{
		
		common.getObject(mobilenofield).clear();
		
		if(common.getObject(cancelBtn).isDisplayed()) {
			common.getObject(cancelBtn).click();
		}

//		common.getObject(mobilenofield).sendKeys(sUsername);
		common.TypeInTextField(mobilenofield, sUsername);
		common.TypeInTextField(passwordField, sPassword);
//		loginpage.passwordField.sendKeys(sPassword);
	
//		loginpage.loginBtn.click();
		common.clickOnElement(loginBtn);
		
		return new FlipkartSearchPage();
	}
}
