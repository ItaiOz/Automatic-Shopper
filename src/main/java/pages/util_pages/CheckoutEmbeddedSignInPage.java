package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;

public class CheckoutEmbeddedSignInPage extends CheckoutShoppingCartSummaryPage{

	@FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
	private WebElement signIn;
	
	public CheckoutEmbeddedSignInPage(MainPageManager pages) {
		super(pages);
	}


	public CheckoutEmbeddedSignInPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
		return this;
	}
	
	public CheckoutEmbeddedSignInPage setEmail(String email) {
		log.info("Set email " + email);
		driver.findElement(By.id("email")).sendKeys(email);
		return this;
	}
	
	public CheckoutEmbeddedSignInPage setPassword(String password) {
		log.info("Set password " + password);
		driver.findElement(By.id("passwd")).sendKeys(password);
		return this;
	}
	
	
	public CheckoutAddressesPage clickSignIn() {
		log.info("signing in");
		signIn.click();
		return pages.checkoutAddressesPage.ensurePageLoaded();
	}
}

