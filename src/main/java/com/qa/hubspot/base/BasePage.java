package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.util.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	public ElementUtil elementUtil;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			tldriver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			tldriver.set(new FirefoxDriver());

		} else if (browserName.contentEquals("Safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			// driver = new SafariDriver();
			tldriver.set(new SafariDriver());

		}

		// driver.manage().deleteAllCookies();
		getDriver().manage().deleteAllCookies();

		// driver.manage().window().maximize();
		getDriver().manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// driver.get(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	// Screenshot Method

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
