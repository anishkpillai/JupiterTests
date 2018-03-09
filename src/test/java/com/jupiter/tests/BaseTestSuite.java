package com.jupiter.tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTestSuite {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void initialiseDriver () {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Before
	public void setUp() {
		driver.manage().deleteAllCookies();
		driver.get("http://jupiter2.cloud.planittesting.com");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
}
