package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.HomePage;
import com.ecom.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginTest() {
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@Test(enabled=false)
	public void validationError() {
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals("Invalid login", loginPage.getValidationMessage());
		System.out.println(loginPage.getValidationMessage());
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
