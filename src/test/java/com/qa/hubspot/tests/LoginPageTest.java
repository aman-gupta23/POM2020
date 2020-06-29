package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.hubspot.util.Constants;

public class LoginPageTest extends BasePageTest {

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, Constants.Login_Page_Title);
	}

	@Test(priority = 3)
	public void verifyDoLogin() {
		loginPage.doLogin(prop.getProperty("UserName"), prop.getProperty("Password"));
	}

	@Test(priority = 1)
	public void verifySignUplinkTest() {
		Assert.assertTrue(loginPage.verifySignUplink());
	}

}
