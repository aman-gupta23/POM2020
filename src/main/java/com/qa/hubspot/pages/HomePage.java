package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

import io.qameta.allure.Step;

public class HomePage extends BasePage {

	private WebDriver driver;

	By header = By.cssSelector("h1.private-header__heading.private-header__heading--solo");
	By accountName = By.cssSelector("span.account-name");
	By parentContactLink = By.id("nav-primary-contacts-branch");
	By childContactLink = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}
	@Step("CHECK HOME PAGE TITLE")
	public String homePageTitle() {
		// return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.Home_Page_Title, 10);

	}
	@Step("CHECK HOME PAGE HEADER")
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
	@Step("CHECK USER ACCOUNT NAME")
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

	public void clickContactsLink() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.waitForElementToBeVisible(parentContactLink, 20);
		elementUtil.doClick(parentContactLink);
		elementUtil.waitForElementToBeVisible(childContactLink, 20);
		elementUtil.doClick(childContactLink);
	}

	public ContactsPage goToContactsPage() {
		// private ContactsPage goToContactsPage() {   #NAL Used
		clickContactsLink();
		return new ContactsPage(driver);
	}
}
