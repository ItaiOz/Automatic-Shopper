package pages._pages_mngt;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import applogic.ApplicationManager1;
import pages._pages_mngt.page_factory.DisplayedElementLocatorFactory;
import pages.super_pages.MenuPage;
import pages.super_pages.Page;
import util.ParamsUtils;
import util.SelUtils;
import pages.util_pages.ItemsPage;
import pages.util_pages.CheckoutEmbeddedSignInPage;
import pages.util_pages.CheckoutShoppingCartSummaryPage;
import pages.util_pages.PreCheckoutDlg;
import pages.util_pages.CheckoutAddressesPage;
import pages.util_pages.CheckoutShippingPage;
import pages.util_pages.CheckoutChoosePaymentPage;
import pages.util_pages.CheckoutPaymentByCheckPage;
import pages.util_pages.CheckoutOrderConfirmationPage;
import pages.util_pages.OrderHistoryPage;

public class MainPageManager {

	private WebDriver driver;
	public SelUtils su;
	private Logger log;
	private ParamsUtils sessionParams;
	
	public MenuPage menuPage;
	public ItemsPage itemsPage;
	public CheckoutShoppingCartSummaryPage checkoutShoppingCartSummaryPage;
	public CheckoutEmbeddedSignInPage checkoutEmbeddedSignInPage;
	public PreCheckoutDlg preCheckoutDlg;
	public CheckoutAddressesPage checkoutAddressesPage;
	public CheckoutShippingPage checkoutShippingPage;
	public CheckoutChoosePaymentPage checkoutChoosePaymentPage;
	public CheckoutPaymentByCheckPage checkoutPaymentByCheckPage;
	public CheckoutOrderConfirmationPage checkoutOrderConfirmationPage;
	public OrderHistoryPage orderHistoryPage;
	
	public MainPageManager(ApplicationManager1 app) {
		driver = app.getDriver();
		su = app.su;
		log = app.getLogger();
		sessionParams = app.getParamsUtils();

		
		menuPage = initElements(new MenuPage(this));
		itemsPage = initElements(new ItemsPage(this));
		checkoutShoppingCartSummaryPage = initElements(new CheckoutShoppingCartSummaryPage(this));
		checkoutEmbeddedSignInPage = initElements(new CheckoutEmbeddedSignInPage(this));
		preCheckoutDlg = initElements(new PreCheckoutDlg(this));
		checkoutEmbeddedSignInPage = initElements(new CheckoutEmbeddedSignInPage(this));
		checkoutAddressesPage = initElements(new CheckoutAddressesPage(this));
		checkoutShippingPage  = initElements(new CheckoutShippingPage(this));
		checkoutChoosePaymentPage = initElements(new CheckoutChoosePaymentPage(this));
		checkoutPaymentByCheckPage = initElements(new CheckoutPaymentByCheckPage(this));
		checkoutOrderConfirmationPage = initElements(new CheckoutOrderConfirmationPage(this));
		orderHistoryPage = initElements(new OrderHistoryPage(this));
	}

	public <T extends Page> T initElements(T page) {
		PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
		return page;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public Logger gerLogger() {
		return log;
	}

	public ParamsUtils getSessionParams() {
		return sessionParams;
	}
}
