package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends LoginPage {
	 LoginPage loginPage;
	
	
	// Page Factory - Object repository
	@FindBy(xpath= "//span[text()='James Bond']")
	public WebElement Username;
	
	@FindBy(xpath="//b[contains(text(),'xyz')]")
	public WebElement ClientName;
	
	@FindBy(css="a[href*='email']")
	public WebElement EmailIcon;
	
	@FindBy(xpath="//input[@class=\"prompt\"]")
	public WebElement SearchBox;
	
	
	// Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
		loginPage= new LoginPage();
	}
	
	// Actions
	public void Home() {
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	public boolean checkName() {
		return Username.isDisplayed();
	}
	public boolean checkClientName() {
		return ClientName.isDisplayed();		
	}

}
