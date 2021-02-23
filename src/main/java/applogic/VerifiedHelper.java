package applogic;

import pages.util_pages.OrderHistoryPage;

public class VerifiedHelper extends DriverBasedHelper {

	public VerifiedHelper(ApplicationManager1 manager) {
		super(manager);
	}
	
	public OrderHistoryPage shoppingVertification(String total, String currDate) {
		return app.pages().checkoutShippingPage.setTermsOfService(true).clickProceed()
				.clickPayByCheck().verifyPrice(total)
				.clickConfirmOrder()
				.verifyPrice(total)
				.clickBackToOrders()
				.verifyFirstOrderDate(currDate)
				.verifyFirstPaymentMethod("Payment by check")
				.verifyFirstTotalPrice(total);
	}
}
