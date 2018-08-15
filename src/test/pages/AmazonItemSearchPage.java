package test.pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.utilities.CommonMethods;
import test.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

public class AmazonItemSearchPage extends Driver{

    PageObjects productSearchPage;
    WebDriverWait wait;
    CommonMethods common;
    
    private By listResults = By.className("sx-table-item");
    
    public AmazonItemSearchPage() throws Exception {
    		super();
    		productSearchPage = new PageObjects();
    		PageFactory.initElements(driver, productSearchPage);
    		wait = new WebDriverWait(driver, 400);
    		common = new CommonMethods();
    }
   
    
    class PageObjects {

        @CacheLookup
        @FindBy(id = "resultItems")
        public WebElement searchResults;

        

    }
    
    public Boolean isResultsPageAppears() {
    		wait.until(ExpectedConditions.visibilityOf(productSearchPage.searchResults));
    		return productSearchPage.searchResults.isDisplayed();
    }
    
    public Integer resultCount() throws TimeoutException {
    		return common.searchElements(listResults).size();
    }
    
    
}
