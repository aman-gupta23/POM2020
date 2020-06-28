package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	private WebDriver driver;

	By header = By.cssSelector("h1.private-header__heading.private-header__heading--solo");
	By accountName = By.cssSelector("span.account-name");

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public String homePageTitle() {
		return driver.getTitle();
	}

	public String getHomePageHeader() {
		if (driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		} else
			return null;
	}

	public String getLoggedinUser() {
		if (driver.findElement(accountName).isDisplayed()) {
			return driver.findElement(accountName).getText();
		} else
			return null;

	}

}
