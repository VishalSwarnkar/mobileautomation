package test.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AmazonLoginUserPage extends Driver{

    PageObjects amazonLoginPage;
    WebDriverWait wait;
    
    public AmazonLoginUserPage() {
    		super();
    		amazonLoginPage = new PageObjects();
    		PageFactory.initElements(driver, amazonLoginPage);
    		wait = new WebDriverWait(driver, 400);
    }
    
   
    
    class PageObjects {

        @FindBy(id = "ap_email_login")
        public WebElement loginEmailTextField;

        @FindBy(id = "auth-password-container")
        public WebElement passwordTextField;
        
        
        @FindBy(id="auth-password-container")
        public WebElement passwordContainer;
        
        @FindBy(id = "auth-signin-show-password-checkbox")
        public WebElement showPasswordCheckbox;

        @FindBy(id = "signInSubmit")
        public WebElement singInBtn;
        
        @FindBy(id = "outer-accordion-signin-signup-page")
        public WebElement signinPage;
        
    }
    
    public Boolean isEmailLogInFieldPresent() {
//		wait.until(ExpectedConditions.visibilityOf(amazonLoginPage.loginEmailTextField));
    		return amazonLoginPage.loginEmailTextField.isEnabled();
    }
    
    public Boolean isPasswordFieldPresent() {
    		System.out.println("isPasswordFieldPresent " + amazonLoginPage.passwordTextField.isEnabled());
		return amazonLoginPage.passwordTextField.isEnabled();
    }
    
    public Boolean isSingInSumitBtnPresent() {
    		wait.until(ExpectedConditions.visibilityOf(amazonLoginPage.singInBtn));
    		System.out.println("isSingInSumitBtnPresent " + amazonLoginPage.singInBtn.isDisplayed());
		return amazonLoginPage.singInBtn.isDisplayed();
    }
    
    public Boolean isSinginPageLayoutPresent() {
    		wait.until(ExpectedConditions.visibilityOf(amazonLoginPage.signinPage));
    		System.out.println("isSinginPageLayoutPresent" + amazonLoginPage.signinPage.isDisplayed());
		return amazonLoginPage.signinPage.isDisplayed();
    }
    
    public Boolean isShowCheckBoxPresent() {
//    		wait.until(ExpectedConditions.visibilityOf(amazonLoginPage.showPasswordCheckbox));
		System.out.println("isShowCheckBoxPresent" + amazonLoginPage.showPasswordCheckbox.isEnabled());
		return amazonLoginPage.showPasswordCheckbox.isEnabled();
    }
    
    
    
    public AmazonItemSearchPage loginUser (String sUseremail, String sPassword) throws Exception {
    		
//    		amazonLoginPage.showPasswordCheckbox.click();
    	
    		System.out.println("User name and password " + sUseremail + " - " + sPassword);
    	
    		amazonLoginPage.passwordTextField.sendKeys(sPassword);
    		amazonLoginPage.loginEmailTextField.sendKeys(sUseremail);
    		
//    		amazonLoginPage.passwordTextField.click();
//    		amazonLoginPage.passwordContainer.click();
    		
    		amazonLoginPage.passwordTextField.sendKeys(sPassword);
	
    		amazonLoginPage.singInBtn.click();
    		
    		return new AmazonItemSearchPage();
    }
    
    
}
