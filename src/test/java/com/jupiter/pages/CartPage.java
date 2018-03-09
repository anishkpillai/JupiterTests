package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jupiter.modal.ConfirmPopup;
import com.jupiter.ui.Table;

public class CartPage extends BasePage {
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
		
	public Double getSubTotal(String title) throws Exception {
		return Double.parseDouble(this.getCartTable().getCellElement("Item", title, "Subtotal").getText().replace("$", ""));	
	}
	
	public Double getPrice(String title) throws Exception {
		return Double.parseDouble(this.getCartTable().getCellElement("Item", title, "Price").getText().replace("$", ""));
	}
	
	public int getQuantity(String title) throws Exception {
		return Integer.parseInt(this.getCartTable().getCellElement("Item", title, "Quantity").findElement(By.name("quantity")).getAttribute("value"));
	}
	
	private Table getCartTable() {
		return new Table(driver.findElement(By.cssSelector(".cart-items"))); 
	}
	
	/***
	 * 
	 *  Methods to click Empty Cart / Checkout button and remove item
	 * 
	 ***/
	
	public ConfirmPopup clickEmptyCartButton(){
		driver.findElement(By.linkText("Empty Cart")).click();
		return new ConfirmPopup(driver.findElement(By.className("modal")));
	}

	public CheckoutPage clickCheckoutButton(){
		driver.findElement(By.linkText("Checkout")).click();
		return new CheckoutPage(driver);
	}
	
	public ConfirmPopup clickRemoveItem(String title) throws Exception {
		this.getCartTable().getCellElement("Item", title, "Actions").findElement(By.cssSelector(".remove-item")).click();
		return new ConfirmPopup(driver.findElement(By.className("modal")));
	}
	
}
