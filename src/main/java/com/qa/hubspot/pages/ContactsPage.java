package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {

	private WebDriver driver;

	By header = By.cssSelector("h1.IndexPageRedesignHeader__StyledH1-ljkrr-1");
	By CreateContactPrimary = By.xpath("//span[text()='Create contact']");
	By emailID = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By CreateContactSecondary = By.xpath("(//span[text()='Create contact'])[2]");
	By ContactBackLink = By.xpath("(//*[text()='Contacts'])[1]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.Contacts_Title, 10);

	}

	public String getContactsPageHeader() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	}

	public void createContacts(String email, String firstName, String lastName, String jobTitle) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.waitForElementToBeVisible(CreateContactPrimary, 20);
		elementUtil.doClick(CreateContactPrimary);
		// elementUtil.clickWhenready(CreateContactPrimary, 10);
		elementUtil.waitForElementToBeVisible(this.emailID, 10);
		elementUtil.doSendKeys(this.emailID, email);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.waitForElementToBeVisible(this.jobTitle, 10);
		elementUtil.doSendKeys(this.jobTitle, jobTitle);
		// elementUtil.waitForElementToBeVisible(CreateContactSecondary,10);
		// elementUtil.doClick(CreateContactSecondary);
		elementUtil.clickWhenready(CreateContactSecondary, 20);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.clickWhenready(ContactBackLink, 10);

	}

}