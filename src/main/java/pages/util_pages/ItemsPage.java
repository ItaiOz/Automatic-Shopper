package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenuPage;

public class ItemsPage extends MenuPage {

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[1]/span")
	private WebElement itemPrice;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[2]/a[1]/span")
	private WebElement addToCart;
	
	@FindBy(xpath = "//*[@id=\"list\"]/a/i")
	private WebElement listView;
	
	public ItemsPage(MainPageManager pages) {
		super(pages);
	}

	public ItemsPage ensurePageLoaded() {
		super.ensurePageLoaded();
		log.info("wair for ItemsPage");
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		return this;
	}
	
	public ItemsPage clickListView() {
		log.info("clicking on list view");
		listView.click();
		return this;
	}
	
	public String getFirstItemPrice() {
		String price = itemPrice.getText();
		log.info("price is "+ price);
		return price;
	}
	
	public PreCheckoutDlg clickAddToCart() {
		log.info("clicking on add to cart");
		addToCart.click();
		return pages.preCheckoutDlg.ensurePageLoaded();
	}
}

