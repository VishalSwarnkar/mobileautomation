package test.utilities;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods extends Driver{

	WebDriverWait wait;
	public CommonMethods() throws Exception{
		super();
		wait = new WebDriverWait(driver, 600);
	}
	
	 public void lauchWebApplication(String URL) {
		driver.get(URL);
	 }
	
	public void TypeInTextField(By element, String typeItem) throws TimeoutException {
		getObject(element).sendKeys(typeItem);
    }
	
	public void clickOnElement(By element) throws TimeoutException {		
		getObject(element).click();
	}
	
	public String getTextFromElement(By element) throws TimeoutException {	
		return getObject(element).getText();
	}
	
	public void clear(By element) throws TimeoutException {
		getObject(element).clear();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getContentDescription(WebElement element) {
		return element.getAttribute("content-desc");
	}
	
	public List<WebElement> searchElements(By element) throws TimeoutException {
		Assert.assertTrue(getObject(element).isDisplayed(), "Element is not visible");
		List<WebElement> results = driver.findElements(element);
		return results;
	}

	public WebElement getObject(By locator) throws TimeoutException {
	        long iWaitTimeForAnElement = 40;
			return new WebDriverWait(driver, iWaitTimeForAnElement)
					.until(ExpectedConditions.visibilityOfElementLocated(locator));					
	}
	
}
