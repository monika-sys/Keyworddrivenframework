package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.keywords.Keyword;

public class SmokeTest {

	@BeforeMethod
	public void openBrowser() {
		Keyword.launchBrowser("Chrome");
		Keyword.launchUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@AfterMethod
	public void closeBrowser() {
		Keyword.closeBrowser();
	}

	@Test
	public void verifySignIn() {
		// Keyword.clickOnElement("cssSelector", ".login");
		Keyword.enterText("xpath", "//input[@id=\"email\"]", "chaudhari.moni789@gmail.com");
		Keyword.enterText("cssSelector", "#passwd", "Monika@123");
		Keyword.clickOnElement("cssSelector", "#SubmitLogin");
	}

	@Test
	public void dropDownSelect() {
		Keyword.clickOnElement("xpath", "//a[contains(@title,\"Women\")]");

	}

}
