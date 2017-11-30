package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	WebDriver driver;
	public static final String SEARCH_FIELD_LOCATOR = "//input[@id='gh-ac']";
	public static final String SEARCH_BUTTON_LOCATOR = "//input[@id='gh-btn']";
	
	@FindBy(xpath = SEARCH_FIELD_LOCATOR)
	private WebElement searchField;
	@FindBy(xpath = SEARCH_BUTTON_LOCATOR)
	private WebElement button;
	
	public void search(String text) {
		searchField.clear();
		button.sendKeys("");
		searchField.sendKeys(text);
		button.click();
	}
	
}
