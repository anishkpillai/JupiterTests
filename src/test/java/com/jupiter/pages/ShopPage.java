package com.jupiter.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jupiter.product.Product;
import com.jupiter.product.ICompareStrategy;

public class ShopPage extends BasePage {
	
	public ShopPage(WebDriver driver) {
		super(driver);
	}
	
	public ArrayList<Product> getProducts(ICompareStrategy strategy) throws Exception {
		ArrayList<Product> matchedProducts = new ArrayList<Product>();
		List<WebElement> products= driver.findElements(By.cssSelector(".product"));
		for (WebElement element: products) {
			Product product = new Product(element);
			if (strategy.compareProduct(product))
			{
				matchedProducts.add(product);
			}
		}
		if (matchedProducts.size() > 0)
		{
			return matchedProducts;
		}
		throw new Exception("Product not found");
	}
}
