package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
@Epic("Epic 101: HubSpot Login Page Functionality ")
@Story("Story 01; Login Page Test")

public class LoginPageTest extends BasePageTest {

	@Test(priority = 2)
	@Description("verifyLoginPageTitleTest_METHOD")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginTitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, Constants.Login_Page_Title);
	}

	@Test(priority = 3)
	@Description("verifyDoLogin_METHOD")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyDoLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	@Description("verifySignUplinkTest_METHOD")
	@Severity(SeverityLevel.BLOCKER)
	public void verifySignUplinkTest() {
		Assert.assertTrue(loginPage.verifySignUplink());
	}

}
