package pages.super_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.util_pages.ItemsPage;

public class MenuPage extends AnyPage {

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement shirts;


	public MenuPage(MainPageManager pages) {
		super(pages);
	}

	public MenuPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		return this;
	}

	public ItemsPage clickTShirtsTab() {
		log.info("clicking on t-shirts");
		shirts.click();
		return pages.itemsPage.ensurePageLoaded();
	}
	

}