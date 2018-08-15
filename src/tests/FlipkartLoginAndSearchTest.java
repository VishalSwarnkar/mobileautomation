package tests;

import java.util.concurrent.TimeoutException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.pages.FlipKartHomePage;
import test.pages.FlipKartLoginPage;
import test.pages.FlipkartSearchPage;
import test.utilities.Driver;

public class FlipkartLoginAndSearchTest extends Driver{

	private FlipKartHomePage homescreen;
	private FlipKartLoginPage loginPage;
	private FlipkartSearchPage searchpage;
	
	@Test
	@Parameters({"sUsername", "sPassword"})
	public void testHomePage(String sUsername, String sPassword) throws Exception {
		
		homescreen = new FlipKartHomePage();
		Reporter.log("Opened flipkar home page");

		Assert.assertTrue(homescreen.isHomePageLoginButtonPresent().isDisplayed(), "Login Button is Visible and clickable");
		
		loginPage = homescreen.clickToSignIn();
		Reporter.log("Login page is opened");
		searchpage = loginPage.enterUserCridentials(sUsername, sPassword);
		
		Reporter.log("Successfully logged in flipkar");
	}
	
	@Test
	public void testSearchItems() throws TimeoutException {
		searchpage.typeSearchItem("smart watches");
		
		Reporter.log("Searching the products : smart watches");
		Assert.assertTrue(searchpage.isSearchResultsPresent());
		
	}
}
