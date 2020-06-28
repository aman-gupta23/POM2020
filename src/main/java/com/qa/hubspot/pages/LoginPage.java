package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	private WebDriver driver;

	// by locators - Object repository

	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By Signup = By.linkText("Sign up");

	// Create constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page Actions

	public String getLoginTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean verifySignUplink() {
		boolean signuplink = driver.findElement(Signup).isDisplayed();
		return signuplink;

	}

	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();

		return new HomePage(driver); 
	}
}
