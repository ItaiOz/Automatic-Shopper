package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;

public class CheckoutAddressesPage extends CheckoutSuperPage{

	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
	public WebElement proceedToCheckout;
	
	public CheckoutAddressesPage(MainPageManager pages) {
		super(pages);
	}


	public CheckoutAddressesPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}
	
	public CheckoutShippingPage clickProceed(){
		log.info("clicking on proceed to checkout");
		proceedToCheckout.click();
		return pages.checkoutShippingPage.ensurePageLoaded();
	}
}
