package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.AnyPage;

public class PreCheckoutDlg extends AnyPage{
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	public WebElement proceedToCheckout;
	
	public PreCheckoutDlg(MainPageManager pages) {
		super(pages);
	}

	public PreCheckoutDlg ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}
	
	public CheckoutShoppingCartSummaryPage clickProceedToCheckout() {
		log.info("clicking on proceed to checkout");
		proceedToCheckout.click();
		return pages.checkoutShoppingCartSummaryPage.ensurePageLoaded();
	}
}
