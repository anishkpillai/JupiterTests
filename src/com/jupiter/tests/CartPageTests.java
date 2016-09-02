package com.jupiter.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jupiter.modal.ConfirmPopup;
import com.jupiter.pages.CartPage;
import com.jupiter.pages.HomePage;
import com.jupiter.pages.ShopPage;
import com.jupiter.product.CompareTitleStrategy;
import com.jupiter.product.Product;

public class CartPageTests extends BaseTestSuite {

	
	@Test
	public void verifyEmptyCartPage() throws Exception {
		
		HomePage homePage=new HomePage(driver);
		ShopPage shopPage = homePage.clickShopLink();
		List<Product> products = shopPage.getProducts(new CompareTitleStrategy("Smiley Bear"));
		int noOfProductsToBuy = 5;
		for (int i=1;i<=noOfProductsToBuy;i++) {
			products.get(0).clickBuyButton();
		}
		Assert.assertEquals("Verify product count in cart", noOfProductsToBuy, homePage.getCartCount());
		CartPage cartPage = homePage.clickCartItemsLink();
		ConfirmPopup popup = cartPage.clickEmptyCartButton();
		popup.clickYesButton();
		Assert.assertEquals("Verify empty cart", 0, homePage.getCartCount());
	}
	
	@Test
	public void verifySubTotalAndPriceForItem() throws Exception {
		HomePage homePage=new HomePage(driver);
		ShopPage shopPage = homePage.clickShopLink();
		String itemTitle = "Smiley Bear";
		List<Product> products = shopPage.getProducts(new CompareTitleStrategy(itemTitle));
		Product product = products.get(0);
		product.clickBuyButton();
		product.clickBuyButton();
		
		Double productPrice = product.getPrice();
		Double expectedPrice = productPrice * 2;
		CartPage cartPage = homePage.clickCartItemsLink();
		Assert.assertEquals("Verify Subtotal for Item", expectedPrice, cartPage.getSubTotal(itemTitle));
		Assert.assertEquals("Verify Price for Item", productPrice, cartPage.getPrice(itemTitle));
	}
	
	@Test
	public void verifyRemoveItemFromCart() throws Exception {
		HomePage homePage=new HomePage(driver);
		ShopPage shopPage = homePage.clickShopLink();
		String itemTitle = "Smiley Bear";
		List<Product> products = shopPage.getProducts(new CompareTitleStrategy(itemTitle));
		products.get(0).clickBuyButton();
	
		CartPage cartPage = homePage.clickCartItemsLink();
		ConfirmPopup popup = cartPage.clickRemoveItem(itemTitle);
		popup.clickYesButton();
		Assert.assertEquals("Verify empty cart", 0, homePage.getCartCount());
	}
}