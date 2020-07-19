package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

import io.qameta.allure.Step;

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
		elementUtil = new ElementUtil(this.driver);
	}

	// Page Actions
	@Step("CHECK LOGIN PAGE TITLE")
	public String getLoginTitle() {
		// return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.Login_Page_Title, 10);
	}

	@Step("CHECK SIGNUP LINK ON LOGIN PAGE")
	public boolean verifySignUplink() {
	
		// return driver.findElement(Signup).isDisplayed();
		elementUtil.waitForElementPresent(Signup, 10);
		return elementUtil.doIsDisplayed(Signup);
	}

	@Step("CHECK LOGIN METHOD WITH CREDENTIALS username: {0} and password:{1} ")
	public HomePage doLogin(String username, String password) {
	
		// driver.findElement(this.username).sendKeys(username);
		// driver.findElement(this.password).sendKeys(password);
		// driver.findElement(this.loginButton).click();
		elementUtil.waitForElementToBeVisible(this.username, 10);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(this.loginButton);

		return new HomePage(driver);

	}
}
