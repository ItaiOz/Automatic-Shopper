package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenuPage;

public class CheckoutSuperPage extends MenuPage{
	
	public CheckoutSuperPage(MainPageManager pages) {
		super(pages);
	}

	public CheckoutSuperPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@class='icon-home']"))));
		return this;
	}
}
