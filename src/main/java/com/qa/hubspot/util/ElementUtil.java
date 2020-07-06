package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getElement(By Locator) {
		WebElement element = driver.findElement(Locator);
		return element;

	}

	public void doSendKeys(By Locator, String value) {
		getElement(Locator).sendKeys(value);
	}

	public void doClick(By Locator) {
		getElement(Locator).click();
	}

	public boolean doIsDisplayed(By Locator) {
		return getElement(Locator).isDisplayed();
	}

	public String doGetText(By Locator) {
		return getElement(Locator).getText();
	}

	public String waitForTitleToBePresent(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();

	}

	public void clickWhenready(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		element.click();
	}

	public WebElement waitForElementToBeVisible(By Locator, int timeout) {
		WebElement element = getElement(Locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}

}
