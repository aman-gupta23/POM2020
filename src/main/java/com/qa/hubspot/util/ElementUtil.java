package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		getElement(Locator).sendKeys("value");
	}

	public void doClick(By Locator) {
		getElement(Locator).click();
	}

	public String doGetText(By Locator) {
		return getElement(Locator).getText();
	}

}
