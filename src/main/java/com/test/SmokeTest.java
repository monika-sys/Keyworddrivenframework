package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fileUtility.PropertiesFile;
import com.keywords.Constants;
import com.keywords.Keyword;

public class SmokeTest {
	static WebDriver driver;

	@BeforeMethod
	public void launchUrl() {
		Keyword.launchBrowser("Chrome");
		Keyword.generateLog();
		Keyword.launchUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Keyword.enterText(PropertiesFile.getLocator("email")[0], PropertiesFile.getLocator("email")[1],
				"chaudhari.moni789@gmail.com");
		Keyword.enterText(PropertiesFile.getLocator("password")[0], PropertiesFile.getLocator("password")[1],
				"Monika@123");
		Keyword.clickOnElement(PropertiesFile.getLocator("loginbutton")[0],
				PropertiesFile.getLocator("loginbutton")[1]);

	}

	@Test(priority = 2)
	public void dropDownSelectTest() {
		Keyword.clickOnElement(PropertiesFile.getLocator("women")[0], PropertiesFile.getLocator("women")[1]);
		Keyword.selectDropDown(PropertiesFile.getLocator("sortbydropdown")[0],
				PropertiesFile.getLocator("sortbydropdown")[1], "Price: Lowest first");
		Keyword.closeBrowser();

	}

	@Test(priority = 1)
	public void verifytitle() {
		String title = Keyword.getPageTitle();
		Assert.assertEquals(title, "My account - My Store");
	}

	@Test(priority = 2)
	public void verifyLogoTest() {
		boolean flag = driver.findElement(By.xpath("//img[@class='logo img-responsive']")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifySigninFormTest() {
		boolean flag = driver.findElement(By.cssSelector("#login_form")).isDisplayed();
		Assert.assertTrue(flag);

	}

	@Test(priority = 4)
	public void verifysigninLableTest() {
		String lable = driver.findElement(By.xpath("//h3[contains(text(),\"Already registered?\")]")).getText();
		Assert.assertEquals(lable, "ALREADY REGISTERED?");
	}

	@Test(priority = 5)
	public void verifyemailLableTest() {
		String label = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/div[1]/label")).getText();
		Assert.assertEquals(label, "Email address");
	}

	@Test(priority = 6)
	public void verifyemailTextboxTest() {
		boolean flag = driver.findElement(By.cssSelector("#email")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 7)
	public void verifypasswordLableTest() {
		String label = driver.findElement(By.xpath("//label[contains(text(),\"Password\")]")).getText();
		Assert.assertEquals(label, "Password");
	}

	@Test(priority = 8)
	public void verifypasswordTextboxTest() {
		boolean flag = driver.findElement(By.cssSelector("#passwd")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 9)
	public void verify_valid_IdPasswordTest() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys("chaudhari.moni789@gmail.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Monika@123");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}

	@Test(priority = 10)
	public void verify_invalid_IdTest() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys("chaaudhari.moni789@gmail.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Monika@123");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}

	@Test(priority = 11)
	public void verify_invalid_PasswordTest() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys("chaudhari.moni789@gmail.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Mohhsnika@123");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}

	@Test(priority = 12)
	public void verify_invalid_IdPasswordTest() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys("chaudahari.moni789@gmail.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Mohhsnika@123");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}

	@Test(priority = 13)
	public void verify_Blank_IdPasswordTest() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys("");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}

	@Test(priority = 14)
	public void verify_Blank_IdTest() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys("");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Monika@123");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}

	@Test(priority = 15)
	public void verify_Blank_PasswordTest() throws InterruptedException {
		driver.findElement(By.cssSelector("#email")).sendKeys("chaudhari.moni789@gmail.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}

	@Test(priority = 16)
	public void verify_forgotPasswordTest() {
		boolean flag = driver.findElement(By.cssSelector("a[title='Recover your forgotten password']")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 17)
	public void verify_forgotPassword_clickTest() throws InterruptedException {
		driver.findElement(By.cssSelector("a[title='Recover your forgotten password']")).click();
		Thread.sleep(4000);
	}

	@Test(priority = 18)
	public void verify_forgotPassword_EmailIdTest() throws InterruptedException {
		driver.findElement(By.cssSelector("a[title='Recover your forgotten password']")).click();
		Thread.sleep(4000);
		boolean flag = driver.findElement(By.cssSelector("input#email")).isDisplayed();
		Assert.assertTrue(flag);

	}

	@Test(priority = 19)
	public void verify_forgotPassword_BlankEmailIdTest() throws InterruptedException {
		driver.findElement(By.cssSelector("a[title='Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("input#email")).sendKeys("");
		driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert")).getText());

	}

	@Test(priority = 20)
	public void verify_forgotPassword_ValidEmailIdTest() throws InterruptedException {
		driver.findElement(By.cssSelector("a[title='Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("input#email")).sendKeys("chaudhari.moni789@gmail.com");
		driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert")).getText());

	}

	@Test(priority = 21)
	public void verify_forgotPassword_InvalidEmailIdTest() throws InterruptedException {
		driver.findElement(By.cssSelector("a[title='Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("input#email")).sendKeys("chauwedhari.moni789@gmail.com");
		driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert")).getText());

	}

	@Test(priority = 22)
	public void verify_BackToLoginbtnTest() {
		driver.findElement(By.cssSelector("a[title='Recover your forgotten password']")).click();
		boolean flag = driver.findElement(By.cssSelector("li>a.btn.btn-default.button.button-small")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 23)
	public void verify_BackToLoginfunTest() {
		driver.findElement(By.cssSelector("a[title='Recover your forgotten password']")).click();
		driver.findElement(By.cssSelector("a[title='Back to Login']")).click();

	}

	@AfterMethod
	public void tearDown() {
		Constants.driver.quit();
	}

}
