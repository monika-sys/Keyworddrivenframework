package com.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {

	private static WebDriver driver;

	/**
	 * this method is used to opening the specified browser <br>
	 * <ul>
	 * <li>Chrome,
	 * <li>Firefox,
	 * <li>Safari,
	 * <li>ie
	 * <ul/>
	 * 
	 * @author monika chaudhari
	 * @param browserName browserName {@code String}
	 */
	public static void launchBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();

			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
		case "Safari":
			Constants.driver = new SafariDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
		default:
			System.err.println("invalid browser name:plaease refer java doc");
			break;
		}
	}

	/**
	 * This methode used for launching url on currently pointing browser
	 * 
	 * @param url{@code String}
	 * @author monika hase
	 */
	public static void launchUrl(String url) {
		Constants.driver.get(url);
	}

	/**
	 * This methode is uset to close the currently open browser
	 * 
	 * @author monika hase
	 */
	public static void closeBrowser() {
		Constants.driver.close();
	}

	public static WebElement getWebElement(String locatorName, String locatorValue) {
		WebElement element = null;
		switch (locatorName) {
		case "xpath":
			element = Constants.driver.findElement(By.xpath(locatorValue));
			break;
		case "cssSelector":
			element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "id":
			element = Constants.driver.findElement(By.id(locatorValue));
			break;
		case "tagName":
			element = Constants.driver.findElement(By.tagName(locatorValue));
			break;
		case "className":
			element = Constants.driver.findElement(By.className(locatorValue));
			break;
		case "linkText":
			element = Constants.driver.findElement(By.linkText(locatorValue));
			break;
		case "partialLinkText":
			element = Constants.driver.findElement(By.partialLinkText(locatorValue));
		default:
			System.err.println("invalid locator:please refer java doc");
			break;
		}
		return element;

	}

	/**
	 * This element is used to click on specified web element
	 * 
	 * @param elementName{@code String}
	 * @author monika hase
	 */

	public static void clickOnElement(String elementName) {
		Constants.driver.findElement(By.xpath("//*[contains(text(),'" + elementName + "')]")).click();

	}

	/**
	 * This methode is use to click on element by specified locator.
	 * <ol>
	 * <li>xpath,
	 * <li>cssSelector,
	 * <li>id,
	 * <li>tagName,
	 * <li>className,
	 * <li>linkText,
	 * <li>partialLinkText,
	 * <ol/>
	 * 
	 * @param locatorName{@code String}
	 * @param value{@code String}
	 * @author monika hase
	 */
	public static void clickOnElement(String locatorName, String locatorValue) {
		getWebElement(locatorName, locatorValue).click();
	}

	public static void enterText(String locatorName, String locatorValue, String textToEnter) {
		getWebElement(locatorName, locatorValue).sendKeys(textToEnter);
	}

	public static void selectDropDown(String locatorName, String locatorValue, String textToEnter) {
		WebElement element = getWebElement(locatorName, locatorValue);
		Select select = new Select(element);
		select.selectByVisibleText(textToEnter);

	}

	public static void maximizeWindow() {
		Constants.driver.manage().window().maximize();
	}

	public static void closeAllBrowser() {
		Constants.driver.quit();
	}
}
