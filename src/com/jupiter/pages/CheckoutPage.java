package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void setForeName(String name) {
		driver.findElement(By.id("forename")).sendKeys(name);
	}

	public void setEmail(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
	}
	
	public void setAddress(String address) {
		driver.findElement(By.id("address")).sendKeys(address);
	}
	
	public void setCardNumber(String cardNumber) {
		driver.findElement(By.id("card")).sendKeys(cardNumber);
	}
	
	public void setCardType(String card) {
		Select cardType = new Select(driver.findElement(By.id("cardType")));
		cardType.selectByVisibleText(card);
	}

	public int getQuantity(){
		return Integer.parseInt(driver.findElement(By.cssSelector(".alert .ng-binding")).getText());
	}
	
	public void clickSubmitButton () {
		driver.findElement(By.id("checkout-submit-btn")).click();
	}
	
	/***
	 * Method to get success message
	 * 
	 **/
	
	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		By alertSuccess = By.cssSelector(".alert-success");
		wait.until(ExpectedConditions.presenceOfElementLocated(alertSuccess));
		return driver.findElement(alertSuccess).getText();
	}

}
