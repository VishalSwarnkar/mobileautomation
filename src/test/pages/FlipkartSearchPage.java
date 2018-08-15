package test.pages;


import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utilities.CommonMethods;
import test.utilities.Driver;

public class FlipkartSearchPage extends Driver{

    WebDriverWait wait;
    CommonMethods common;
    
    private By searchTextBox = By.id("com.flipkart.android:id/search_widget_textbox");
    private By autoCompleteText = By.id("com.flipkart.android:id/search_autoCompleteTextView");
    private By autoSuggestText = By.id("com.flipkart.android:id/auto_suggest_text");
    private By searchedTextBox = By.id("android.widget.TextView");
    private By searchResults = By.id("com.flipkart.android:id/contentFragment");
    private By notNowBtn = By.id("com.flipkart.android:id/not_now_button");
    private By results = By.className("col _2-gKeQ");
    
    public FlipkartSearchPage() throws Exception {
    		super();
    		common = new CommonMethods();
    }
    
    public void typeSearchItem(String item) throws TimeoutException {
    		common.getObject(searchTextBox).click();
    		common.TypeInTextField(autoCompleteText, item);
    		common.getObject(autoSuggestText).click();
    		common.getObject(notNowBtn).click();    		
    }
    
    public Boolean isSearchTextedBoxPresent() throws TimeoutException {
    		return common.getObject(searchedTextBox).isDisplayed();
    }
    
    public Boolean isSearchResultsPresent() throws TimeoutException {
    		return common.getObject(searchResults).isDisplayed();
    }
 
}
