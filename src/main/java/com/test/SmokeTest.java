package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fileUtility.PropertiesFile;
import com.keywords.Constants;
import com.keywords.Keyword;

public class SmokeTest {
	static WebDriver driver;

	@BeforeMethod
	private void launchUrl() {
		Keyword.launchBrowser("Chrome");
		Keyword.launchUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Keyword.enterText(PropertiesFile.getLocator("email")[0], PropertiesFile.getLocator("email")[1],
				"chaudhari.moni789@gmail.com");
		Keyword.enterText(PropertiesFile.getLocator("password")[0], PropertiesFile.getLocator("password")[1],
				"Monika@123");
		Keyword.clickOnElement(PropertiesFile.getLocator("loginbutton")[0],
				PropertiesFile.getLocator("loginbutton")[1]);

	}

	@Test(priority = 1)
	public void dropDownSelect() {
		Keyword.clickOnElement(PropertiesFile.getLocator("women")[0], PropertiesFile.getLocator("women")[1]);
		Keyword.selectDropDown(PropertiesFile.getLocator("sortbydropdown")[0],
				PropertiesFile.getLocator("sortbydropdown")[1], "Price: Lowest first");
		Keyword.closeBrowser();

	}

	@AfterMethod
	public void tearDown() {
		Constants.driver.quit();
	}

}
