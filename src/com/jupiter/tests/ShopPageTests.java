package com.jupiter.tests;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jupiter.pages.HomePage;
import com.jupiter.pages.ShopPage;
import com.jupiter.product.ComparePriceStrategy;
import com.jupiter.product.CompareRatingStrategy;
import com.jupiter.product.CompareTitleStrategy;
import com.jupiter.product.Product;

public class ShopPageTests extends BaseTestSuite {
	
	@Test
	public void verifySpecificProductPrice() throws Exception {
		Double expectedPrice = 9.99;
		HomePage homePage=new HomePage(driver);
		ShopPage shoppingPage = homePage.clickShopLink();
		
		List<Product> product = shoppingPage.getProducts(new CompareTitleStrategy("Handmade Doll"));
		Assert.assertEquals("Verify Handmade Doll price", expectedPrice, product.get(0).getPrice());
	}
	
	@Test
	public void addProductToCart() throws Exception {
		HomePage homePage=new HomePage(driver);
		ShopPage shopPage = homePage.clickStartShoppingButton();
		
		List<Product> products = shopPage.getProducts(new CompareTitleStrategy("Smiley Bear"));
		products.get(0).clickBuyButton();
		
		products = shopPage.getProducts(new CompareRatingStrategy(5));
		products.get(0).clickBuyButton();
		
		products = shopPage.getProducts(new ComparePriceStrategy(10.00));
		for (Product product:products) {
			product.clickBuyButton();
		}
	}
}
