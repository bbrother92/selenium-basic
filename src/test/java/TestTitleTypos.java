
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.ResultsPage;
import pages.SearchPage;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;


public class TestTitleTypos {
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
	
	@DataProvider
	public Object[][] dataArray() {
		return new Object[][]{
				{"keybord", "keyboard"},
				{"keybrd", "keyboard"},
				{"kwyboard", "keyboard"},
				{"kkeyboard", "keyboard"},
				{"keibord", "keyboard"},
				{"keyboad", "keyboard"},
		};
	}
	
	@Test(dataProvider = "dataArray")
	public void testTitleTypos(String typo, String expected) {
		
		SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
		searchPage.search(typo);
		ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
		resultsPage.clickOnBuyitnow();
		ArrayList<String> itemsTitles = resultsPage.getItemsTitles();
		for (String itemTitle : itemsTitles) {
			System.out.println(itemTitle);
			assertTrue(itemTitle.toLowerCase().contains(expected));
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
