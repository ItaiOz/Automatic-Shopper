package applogic;

import models.User;
import pages.util_pages.CheckoutAddressesPage;

public class LoginHelper extends DriverBasedHelper {

	public LoginHelper(ApplicationManager1 manager) {
		super(manager);
	}
	
	public CheckoutAddressesPage shoopingLogin(User user) {
		return app.pages().checkoutEmbeddedSignInPage.setEmail(user.getEmail()).setPassword(user.getPassword()).clickSignIn();
	}
}
