
package pages.util_pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;

public class OrderHistoryPage extends CheckoutSuperPage{

	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[2]")
	private WebElement orderDate;
	
	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[3]/span")
	private WebElement price;

	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[4]")
	private WebElement pMethod;
	
	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[6]/a")
	private WebElement pdf;
	public OrderHistoryPage(MainPageManager pages) {
		super(pages);
	}

	public OrderHistoryPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}

	public OrderHistoryPage verifyFirstOrderDate(String expectedDate) {
		
		log.info("Check if expected date as current data");
		String date = orderDate.getText();
		Assert.assertTrue(expectedDate.equals(date),
				"Expected order date to be " + date + " but received " + expectedDate + " instead.");
		
		return this;
	}
	
	public OrderHistoryPage verifyFirstPaymentMethod(String expectedMethod) {
		
		log.info("Check if expected date as current data");
		String method = pMethod.getText();
		Assert.assertTrue(expectedMethod.equals(method),
				"Expected payment method to be " + method + " but received " + expectedMethod + " instead.");
		
		return this;
	}
	
	public OrderHistoryPage verifyFirstTotalPrice(String expectedTotal) {
		
		log.info(expectedTotal);
		log.info("Check again if expected price as total price");
		String totalPrice = price.getText();
		Assert.assertTrue(expectedTotal.equals(totalPrice),
				"Expected cart amount to be " + totalPrice + " but received " + expectedTotal + " instead.");	
		
		return this;
	}
	
	public OrderHistoryPage clickFirstDownloadPDF() {
		
		log.info("downloading pdf");
		pdf.click();
		return this;
	}	
}