package com.jupiter.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
	protected WebElement element;
	
	public Product(WebElement element) {
		this.element = element;
	}
	
	public String getTitle() {
		return element.findElement(By.cssSelector(".product-title")).getText().trim();
	}
	
	public Double getPrice() {
		return Double.parseDouble(element.findElement(By.cssSelector(".product-price")).getText().replace("$", ""));
	}
	
	public int getStarRating() {
		return Integer.parseInt(element.findElement(By.cssSelector(".star-level")).getText().trim());
	}
	
	public void clickBuyButton() {
		element.findElement(By.linkText("Buy")).click();
	}
}
