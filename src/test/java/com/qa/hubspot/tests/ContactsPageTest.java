package com.qa.hubspot.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest extends BasePageTest {
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeClass
	public void contactsSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	/*@Test(priority = 1)
	public void verifyContactsTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page Title " + title);
		Assert.assertEquals(title, Constants.Contacts_Title);
	}
*/
	@DataProvider
	public Object[][] getContactsTestData() {

		Object data[][] = ExcelUtil.getTestData(Constants.Contacts_Sheet_Name);
		return data;
	}

	@Test(priority = 1, dataProvider = "getContactsTestData")
	public void createContactstest(String email, String firstName, String lastname, String jobTitle) {
		contactsPage.createContacts(email, firstName, lastname, jobTitle);
	}

	
	//@Test(priority = 2) public void createContactstest() {
	// contactsPage.createContacts("Adsgbctt@ggg.com", "attdfgbc", "ggttg", "qa"); }
	 

}
