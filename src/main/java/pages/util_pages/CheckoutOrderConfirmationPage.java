package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;

public class CheckoutOrderConfirmationPage extends CheckoutSuperPage{

	@FindBy(xpath = "//*[@id=\"center_column\"]/div/span/strong")
	private WebElement price;

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a")
	private WebElement orderConfirmation;
	
	public CheckoutOrderConfirmationPage(MainPageManager pages) {
		super(pages);
	}

	public CheckoutOrderConfirmationPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}
	
	public CheckoutOrderConfirmationPage verifyPrice(String expectedPrice) {
		
		log.info(expectedPrice);
		log.info("Check again if expected price as total price");
		String totalPrice = price.getText();
		Assert.assertTrue(expectedPrice.equals(totalPrice),
				"Expected cart amount to be " + totalPrice + " but received " + expectedPrice + " instead.");
			
		return this;
	}
	
	public OrderHistoryPage clickBackToOrders() {
		
		log.info("getting back to orders");
		orderConfirmation.click();
		return pages.orderHistoryPage.ensurePageLoaded();
	}
	
}
