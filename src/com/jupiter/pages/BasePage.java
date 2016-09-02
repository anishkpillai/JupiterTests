package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ContactPage clickContactLink() {
		driver.findElement(By.cssSelector("#nav-contact a")).click();
		return new ContactPage(driver);
	}
	
	public ShopPage clickShopLink() {
		driver.findElement(By.cssSelector("#nav-shop a")).click();
		return new ShopPage(driver);
	}
	
	public CartPage clickCartItemsLink(){
		driver.findElement(By.cssSelector("#nav-cart a")).click();
		return new CartPage(driver);
	}
	
	/***
	 * 
	 *  Methods to retrieve details from base page
	 * 
	 ***/
	
	public int getCartCount() {
		return Integer.parseInt(driver.findElement(By.cssSelector(".cart-count")).getText());
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
}