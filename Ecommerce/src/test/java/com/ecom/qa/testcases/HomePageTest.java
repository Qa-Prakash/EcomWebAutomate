package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.HomePage;
import com.ecom.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
//	@Test
//	public void landingPage() {
//		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));	
//	}
	
	@Test(priority=1)
	public void validateName() {
		homePage.checkClientName();
		Assert.assertEquals(true, homePage.Username.isDisplayed());
		Assert.assertEquals("James Bond", homePage.Username.getText());
		System.out.println(homePage.Username.getText());
		
	}
	
	@Test(priority=2)
	public void validateClientName() {
		homePage.checkClientName();
		Assert.assertEquals(true, homePage.ClientName.isDisplayed());
		Assert.assertEquals("xyz", homePage.ClientName.getText());
		System.out.println(homePage.ClientName.getText());
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
