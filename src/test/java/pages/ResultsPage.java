package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ResultsPage {
	public static final int FIRST_TEN_ITEMS = 10;
	private static final String RESUlTS_LOCATOR = "//*[@id='Results']//li/h3/a";
	private static final String BUYITNOW_LOCATOR = "//a[@title='Buy It Now']";
	
	@FindBy(xpath = RESUlTS_LOCATOR)
	private List<WebElement> itemsTitlesOnSnippets;
	@FindBy(xpath = BUYITNOW_LOCATOR)
	private WebElement buyitNowButton;
	
	ArrayList<String> titles = new ArrayList();
	ArrayList<String> titlesLinks = new ArrayList();
	
	public void clickOnBuyitnow () {
		if (buyitNowButton.isDisplayed())
		buyitNowButton.click();
	}
	
	/**
	 * Collects items titles on result page
	 * @return
	 */
	public ArrayList<String> getItemsTitles() {
		for (WebElement itemTitlesOnSnippet : itemsTitlesOnSnippets) {
			titles.add(itemTitlesOnSnippet.getText());
		}
		return titles;
	}
	/**
	 * Collects items links
	 * @return
	 */
	public ArrayList<String> getItemsLinks() {
		for (WebElement itemTitlesOnSnippet : itemsTitlesOnSnippets) {
			titlesLinks.add(itemTitlesOnSnippet.getAttribute("href"));
		}
		return titlesLinks;
	}
}
