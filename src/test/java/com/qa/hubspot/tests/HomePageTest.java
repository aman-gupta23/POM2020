package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 102: HubSpot Home Page Functionality ")
@Story("Story 02; Home Page Test")
public class HomePageTest extends BasePageTest {

	HomePage homePage;

	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 3)
	@Description("verifyhomePageTitleTest_METHOD")
	@Severity(SeverityLevel.TRIVIAL)
	public void verifyhomePageTitleTest() {
		String HomePageTitle = homePage.homePageTitle();
		System.out.println("Home Page title is " + HomePageTitle);
		Assert.assertEquals(HomePageTitle, Constants.Home_Page_Title, "Home page title is not matched");
	}

	@Test(priority = 1)
	@Description("verifygetHomePageHeaderTest_METHOD")
	@Severity(SeverityLevel.NORMAL)
	public void verifygetHomePageHeaderTest() {
		String header = homePage.getHomePageHeader();
		System.out.println("Home Page header is " + header);
		Assert.assertEquals(header, Constants.Home_Page_Header, "header in user is matched");
	}

	@Test(priority = 2)
	@Description("verifyLoggedinUserTest_METHOD")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyLoggedinUserTest() {
		String LoggedInUser = homePage.getLoggedinUser();
		Assert.assertEquals(LoggedInUser, prop.getProperty("accountName"), "Logged in user is matched");

	}

}
