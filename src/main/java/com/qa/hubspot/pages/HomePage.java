package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	By header = By.cssSelector("h1.private-header__heading.private-header__heading--solo");
	By accountName = By.cssSelector("span.account-name");
	// By accountName = By.className("account-name ");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	public String homePageTitle() {
		// return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.Home_Page_Title, 10);

	}

	public String getHomePageHeader() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		} else
			return null;

		/*
		 * if (driver.findElement(header).isDisplayed()) { return
		 * driver.findElement(header).getText(); } else return null;
		 */
	}

	public String getLoggedinUser() {
		if (elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		} else
			return null;

		/*
		 * if (driver.findElement(accountName).isDisplayed()) { return
		 * driver.findElement(accountName).getText(); } else return null;
		 */

	}

}
