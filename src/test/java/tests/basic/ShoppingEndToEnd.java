package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import models.User;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.time.LocalDateTime;  

public class ShoppingEndToEnd extends TestBase {

	String timestamp, email, password, price, shippingPrice;
	User user;
	
	@Test
	public void test() {
		try {


			initParameters();
			app.getDriver().get("http://automationpractice.com/index.php/");

			startShoppingProcess();
			
			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
	
	private void initParameters() {
		price = "";
		shippingPrice = "";
		user = new User("fff@fff.com", "123456");
	}
	
	public ShoppingEndToEnd() {
		// TODO Auto-generated constructor stub
	}
	
	private void startShoppingProcess() {
		
		WebDriver driver = app.getDriver();
		
		timestamp = calculateTodayDate();
		
		price = app.pages()
				.menuPage.clickTShirtsTab()
				.clickListView()
				.getFirstItemPrice();
	
		 app.pages().itemsPage.clickAddToCart().clickProceedToCheckout()
			.clickProceedReturnSignInPage();
		
		shippingPrice = app.getLoginHelper().shoopingLogin(user).clickProceed()
				.getShippingPrice();
		
		
		String total = calculateTotalPrice();

		app.getVerifiedHelper().shoppingVertification(total,timestamp).clickFirstDownloadPDF();
		verifyPDFContainsText(total);
		
	}
	
	private String calculateTodayDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		LocalDateTime now = LocalDateTime.now();
		String currDate = dtf.format(now);
		log.info(dtf.format(now));
		return currDate;
	}
	
	private String calculateTotalPrice() {
		String str = price.substring(1,6);
		double p = Double.parseDouble(str);
		str = shippingPrice.substring(1,5);
		double s = Double.parseDouble(str);
		double total = s + p;
		str = Double.toString(total);
		String dollar = "$";
		String tot = dollar + str;	
		return tot;
	}

	private void verifyPDFContainsText(String expectedPrice) {
		log.info("verify PDF Contains Text");
		try {
			log.info("checking pdf");
			String filePath = "C:\\Users\\Itai\\Downloads" + File.separator + "IN040972.pdf";

			if (!app.fileUtilis.isTextInPDFFile(filePath, expectedPrice))
				Assert.fail("The text " + expectedPrice + " not found in the file " + filePath);
			log.info("Text was found in pdf file");

			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
	
}

