package com.jupiter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {
	
	public ContactPage(WebDriver driver) {
		super(driver);
	}
	
	public void setForeName(String name) {
		driver.findElement(By.id("forename")).sendKeys(name);
	}
	
	public String getForeNameError() {
		return getErrorMessageForField(By.id("forename-err"));  
	}
	
	public void setEmail(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
	}
	
	public String getEmailError() {
		return getErrorMessageForField(By.id("email-err"));  
	}
	
	public void setTelephone(String telephone) {
		driver.findElement(By.id("telephone")).sendKeys(telephone);
	}
	
	public String getTelephoneError() {
		return getErrorMessageForField(By.id("telephone-err"));   
	}
		
	public void setMessage(String message) {
		driver.findElement(By.id("message")).sendKeys(message);
	}
	
	public String getMessageError() {
		return getErrorMessageForField(By.id("message-err"));   
	}
	
	/***
	 * 
	 * Method to retrieve success/error message(s) and click Submit button
	 * 
	 ***/
	
	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		By alertSuccess = By.cssSelector(".alert-success");
		wait.until(ExpectedConditions.presenceOfElementLocated(alertSuccess));
		return driver.findElement(alertSuccess).getText();
	}
	
	public String getErrorMessageForField(By fieldName) {
		List<WebElement> fieldNames = driver.findElements(fieldName);
		return (fieldNames.size() > 0) ? fieldNames.get(0).getText() : ""; 
	}
	
	public void clickSubmitButton(){
		driver.findElement(By.linkText("Submit")).click();
	}
	
}
