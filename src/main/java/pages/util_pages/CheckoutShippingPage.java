package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;

public class CheckoutShippingPage extends CheckoutSuperPage{

	@FindBy(xpath = "//*[@id=\"form\"]/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]/div")
	private WebElement shippingPrice;
	
	@FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
	private WebElement proceed;
	
	public CheckoutShippingPage(MainPageManager pages) {
		super(pages);
	}

	public CheckoutShippingPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}

	public String getShippingPrice() {
		String shPrice = shippingPrice.getText();
		log.info("Shipping price is " + shPrice);
		return shPrice;
	}
	
	public CheckoutShippingPage setTermsOfService(boolean agree){
		boolean checked = false;
		
		log.info("Click on box verification if not already clicked");
		driver.findElement(By.id("cgv")).click();
		if (driver.findElement(By.id("cgv")).isSelected()) 
			checked = true;
		log.info(checked);
		if(checked != agree)
			driver.findElement(By.id("cgv")).click();
		
		return this;
	}
	
	public CheckoutChoosePaymentPage clickProceed() {
		log.info("clicking proceed");
		proceed.click();
		return pages.checkoutChoosePaymentPage;
	}
}
