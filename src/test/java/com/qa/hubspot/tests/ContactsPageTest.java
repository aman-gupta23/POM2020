package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;

public class ContactsPageTest extends BasePageTest {
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeClass
	public void contactsSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactsTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page Title " + title);
		Assert.assertEquals(title, Constants.Contacts_Title);
	}

	@Test(priority = 2)
	public void createContactstest() {
		contactsPage.createContacts("Ajay@01gmail.com", "Ajay", "Devgan", "sr. Manager");
	}
}
