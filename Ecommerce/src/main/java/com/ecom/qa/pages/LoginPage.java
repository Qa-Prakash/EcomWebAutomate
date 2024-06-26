package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object repository

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[@href='https://ui.freecrm.com']")
	WebElement Login;

	@FindBy(xpath = "//p[text()='Invalid login']")
	WebElement ValidationError;

	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public HomePage login(String un, String pwd) {
		Login.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
	}

	public String getValidationMessage() {
		return ValidationError.getText();

	}

}
