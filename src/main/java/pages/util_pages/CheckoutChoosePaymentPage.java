package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;

public class CheckoutChoosePaymentPage extends CheckoutSuperPage{
	
	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
	private WebElement payByCheck;
	
	public CheckoutChoosePaymentPage(MainPageManager pages) {
		super(pages);
	}

	public CheckoutChoosePaymentPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}
	
	public CheckoutPaymentByCheckPage clickPayByCheck() {
		log.info("clicking on check payment");
		payByCheck.click();
		return pages.checkoutPaymentByCheckPage.ensurePageLoaded();
	}
}
