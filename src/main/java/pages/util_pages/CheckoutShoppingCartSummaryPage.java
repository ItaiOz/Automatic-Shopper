package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;

public class CheckoutShoppingCartSummaryPage extends PreCheckoutDlg {

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	public WebElement checkout;
	
	public CheckoutShoppingCartSummaryPage(MainPageManager pages) {
		super(pages);
	}

	public CheckoutShoppingCartSummaryPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}


	public CheckoutEmbeddedSignInPage clickProceedReturnSignInPage() {
		log.info("returning to sign in");
		checkout.click();
		return pages.checkoutEmbeddedSignInPage.ensurePageLoaded();
	}
}