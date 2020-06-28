package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		// homePage = new HomePage(driver);
		homePage = loginPage.doLogin(prop.getProperty("UserName"), prop.getProperty("Password"));

	}

	@Test(priority = 3)
	public void verifyhomePageTitleTest() {
		String HomePageTitle = homePage.homePageTitle();
		System.out.println("Home Page title is " + HomePageTitle);
		Assert.assertEquals(HomePageTitle, Constants.Home_Page_Title, "Home page title is not matched");
	}

	@Test(priority = 1)
	public void verifygetHomePageHeaderTest() {
		String header = homePage.getHomePageHeader();
		System.out.println("Home Page header is " + header);
		Assert.assertEquals(header, Constants.Home_Page_Header, "header in user is matched");
	}

	@Test(priority = 2)
	public void verifyLoggedinUserTest() {
		String LoggedInUser = homePage.getLoggedinUser();
		Assert.assertEquals(LoggedInUser, prop.getProperty("AccountName"), "Logged in user is matched");

	}

	@AfterTest
	public void quit() {
		driver.quit();
	}
}
