package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;

public class CheckoutPaymentByCheckPage extends CheckoutSuperPage{

	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
	private WebElement confirmOrder;
	
	@FindBy(xpath = "//*[@id=\"amount\"]")
	private WebElement price;
	
	public CheckoutPaymentByCheckPage(MainPageManager pages) {
		super(pages);
	}

	public CheckoutPaymentByCheckPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}
	
	public CheckoutPaymentByCheckPage verifyPrice(String expectedPrice){
		
		log.info(expectedPrice);
		log.info("Check if expected price as total price");
		String totalPrice = price.getText();
		Assert.assertTrue(expectedPrice.equals(totalPrice),
				"Expected cart amount to be " + totalPrice + " but received " + expectedPrice + " instead.");
			
		return this;
	}
	
	public CheckoutOrderConfirmationPage clickConfirmOrder(){
		log.info("clicking on confrim order");
		confirmOrder.click();
		return pages.checkoutOrderConfirmationPage.ensurePageLoaded();
	}
}
