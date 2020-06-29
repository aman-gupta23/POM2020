package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class BasePageTest {

	public WebDriver driver;
	public BasePage basePage;
	public LoginPage loginPage;
	public Properties prop;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}

}
  