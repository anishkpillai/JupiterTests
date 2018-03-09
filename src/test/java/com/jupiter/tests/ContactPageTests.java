package com.jupiter.tests;

import org.junit.Assert;
import org.junit.Test;

import com.jupiter.pages.ContactPage;
import com.jupiter.pages.HomePage;

public class ContactPageTests extends BaseTestSuite {
	
	@Test
	public void verifyMandatoryFormFields() {
		HomePage homePage=new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
		contactPage.clickSubmitButton();
		
		Assert.assertEquals("Verify forename field error", "Forename is required", contactPage.getForeNameError());
		Assert.assertEquals("Verify email field error", "Email is required", contactPage.getEmailError());
		Assert.assertEquals("Verify message field error", "Message is required", contactPage.getMessageError());
		
		contactPage.setForeName("Anish");
		contactPage.setEmail("anish@kumar.com");
		contactPage.setMessage("Testing the message field");
		
		Assert.assertEquals("Verify forename field error", "", contactPage.getForeNameError());
		Assert.assertEquals("Verify email field error", "", contactPage.getEmailError());
		Assert.assertEquals("Verify message field error", "", contactPage.getMessageError());
	}
	
	@Test
	public void verifyInvalidEmailAndPhone() {
		HomePage homePage=new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
		contactPage.setEmail("anish");
		contactPage.setTelephone("ABCD");
		
		Assert.assertEquals("Verify email field error", "Please enter a valid email", contactPage.getEmailError());
		Assert.assertEquals("Verify telephone number field error", "Please enter a valid telephone number", contactPage.getTelephoneError());
	}
	
	@Test
	public void verifyValidFormSubmission() {
		String foreName = "Anish";
		HomePage homePage=new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
		contactPage.setForeName(foreName);
		contactPage.setEmail("anish@kumar.com");
		contactPage.setMessage("This is testing");
		contactPage.clickSubmitButton();
		
		Assert.assertEquals("Verify valid form submission", "Thanks "+foreName+", we appreciate your feedback.", contactPage.getSuccessMessage());
	}
}
