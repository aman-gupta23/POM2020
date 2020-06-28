package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

	}

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

	@AfterTest
	public void quit() {
		driver.quit();
	}

}
