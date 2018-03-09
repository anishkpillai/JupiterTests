package com.jupiter.tests;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jupiter.pages.CartPage;
import com.jupiter.pages.CheckoutPage;
import com.jupiter.pages.HomePage;
import com.jupiter.pages.ShopPage;
import com.jupiter.product.CompareTitleStrategy;
import com.jupiter.product.Product;

public class CheckoutPageTests extends BaseTestSuite {

	@Test
	public void verifyCheckout() throws Exception {
		HomePage homePage=new HomePage(driver);
		ShopPage shopPage = homePage.clickShopLink();
		String itemTitle = "Smiley Bear";
		String foreName = "Anish";
		
		List<Product> products = shopPage.getProducts(new CompareTitleStrategy(itemTitle));
		Product product = products.get(0);
		product.clickBuyButton();
		product.clickBuyButton();
		
		CartPage cartPage = homePage.clickCartItemsLink();
		int expectedQuantity = cartPage.getQuantity(itemTitle);
		
		CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
		Assert.assertEquals("Verify item quantity", expectedQuantity, checkoutPage.getQuantity());
		
		checkoutPage.setForeName(foreName);
		checkoutPage.setEmail("anish@kumar.com");
		checkoutPage.setAddress("Test Address");
		checkoutPage.setCardType("Mastercard");
		checkoutPage.setCardNumber("1234567812345678");
		checkoutPage.clickSubmitButton();
		Assert.assertTrue("Verify checkout confirmation", checkoutPage.getSuccessMessage().matches("Thanks "+foreName+", your order has been accepted. Your order nuumber is JT[0-9]+?"));
	}

}
