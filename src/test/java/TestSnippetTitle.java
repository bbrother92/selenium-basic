import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemCardPage;
import pages.ResultsPage;
import pages.SearchPage;

public class TestSnippetTitle {
	private static final String URL = "https://ebay.com/";
	private WebDriver driver;
	
	@BeforeClass
	public void setUP() {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('gh-eb-Geo-a-en').click();");
	}
	
	@Test
	public void testItemsTitles() {
		
		SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
		searchPage.search("keyboard");
		
		ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
		resultsPage.clickOnBuyitnow();
		ItemCardPage itemCardPage = PageFactory.initElements(driver, ItemCardPage.class);
		itemCardPage.checkTitlesOnCards(resultsPage.getItemsTitles(), resultsPage.getItemsLinks());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
