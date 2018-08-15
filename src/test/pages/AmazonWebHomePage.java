package test.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.utilities.CommonMethods;
import test.utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonWebHomePage extends Driver{

    WebDriverWait wait;
    CommonMethods common;
    
    private By divElement = By.id("issDiv0");
    private By searchTextField = By.id("nav-search-keywords");
    private By singinBtn = By.id("gwm-SignIn-button");
    private By navBar = By.id("nav-gwbar");
    private By departmentsNavBar = By.id("departments");
    private By primeNavBar = By.id("Prime");
    private By videoNavBar = By.id("Video");
    private By searchKeywords = By.id("nav-search-field");
    private By listResults = By.className("sx-table-item");
    
    
    public AmazonWebHomePage() throws Exception {
		super();
		common = new CommonMethods();
    }
    
    public void typeInSearchItem(String searchItem) throws TimeoutException {
		common.TypeInTextField(searchKeywords, searchItem);
    }
    
    public AmazonItemSearchPage submitSearchItems() throws Exception {
    		common.clickOnElement(divElement);
    		return new AmazonItemSearchPage();
    }    
    
    
}
