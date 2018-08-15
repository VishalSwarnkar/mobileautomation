package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.pages.AmazonItemSearchPage;
import test.pages.AmazonLoginUserPage;
import test.pages.AmazonWebHomePage;
import test.utilities.Driver;
import org.testng.Assert;
import org.testng.Reporter;

import test.utilities.CommonMethods;



public class AmazonWebProductSearch extends Driver{

	private AmazonWebHomePage amazonHomePage;
	private AmazonLoginUserPage amazonLoginPage;
	private AmazonItemSearchPage amazonSearchPage;
	private AmazonItemSearchPage resultPage;
	CommonMethods launch; 
	
	@DataProvider(name = "SearchData")
	 
	  public static Object[][] credentials() {
	 
	        // The number of times data is repeated, test will be executed the same no. of times
	 
	        // Here it will execute two times
	 
	        return new Object[][] {{"smart watches"},{"mobile phones"},{"story books"}};
	 
	  }
	
	@Test(dataProvider = "SearchData")
	public void testAmazonHomePage(String searchTerm) throws Exception {

		amazonHomePage = new AmazonWebHomePage();
		launch = new CommonMethods();
		
		launch.lauchWebApplication("https://www.amazon.co.uk");
		
		Reporter.log("Application launched");
		
		Assert.assertEquals("Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more", launch.getPageTitle());
		
		amazonHomePage.typeInSearchItem(searchTerm);
		amazonSearchPage = amazonHomePage.submitSearchItems();
		
		Reporter.log("Search page listed");
		
		Assert.assertTrue(amazonSearchPage.isResultsPageAppears(), "Searched results populated successfully");
		Assert.assertEquals((int) 21, (int) amazonSearchPage.resultCount());
		
		Reporter.log("Total result count : "+amazonSearchPage.resultCount());
			
	}
	
}
