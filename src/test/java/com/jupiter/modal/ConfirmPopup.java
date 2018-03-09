package com.jupiter.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmPopup {
	protected WebElement element;

	public ConfirmPopup(WebElement element) {
		this.element = element;
	}
	
	public void clickYesButton(){
		element.findElement(By.linkText("Yes")).click();
	}
	
	public void clickNoButton(){
		element.findElement(By.linkText("No")).click();
	}
}
