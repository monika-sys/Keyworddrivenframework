package com.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

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
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Safari":
			driver = new SafariDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
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
		driver.get(url);
	}

	/**
	 * This methode is uset to close the currently open browser
	 * 
	 * @author monika hase
	 */
	public static void closeBrowser() {
		driver.close();
	}

	/**
	 * This element is used to click on specified web element
	 * 
	 * @param elementName{@code String}
	 * @author monika hase
	 */

	public static void clickOnElement(String elementName) {
		driver.findElement(By.xpath("//*[contains(text(),'" + elementName + "')]")).click();

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
	public static void clickOnElement(String locatorName, String value) {
		switch (locatorName) {
		case "xpath":
			driver.findElement(By.xpath(value)).click();
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(value)).click();
			break;
		case "id":
			driver.findElement(By.id(value)).click();
			break;
		case "tagName":
			driver.findElement(By.tagName(value)).click();
			break;
		case "className":
			driver.findElement(By.className(value)).click();
			break;
		case "linkText":
			driver.findElement(By.linkText(value)).click();
			break;
		case "partialLinkText":
			driver.findElement(By.partialLinkText(value)).click();
		default:
			System.err.println("invalid locator:please refer java doc");
			break;
		}

	}

	public static void enterText(String locatorName, String value, String input) {
		switch (locatorName) {
		case "xpath":
			driver.findElement(By.xpath(value)).sendKeys(input);
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(value)).sendKeys(input);
			break;
		case "id":
			driver.findElement(By.id(value)).sendKeys(input);
			break;
		case "tagName":
			driver.findElement(By.tagName(value)).sendKeys(input);
			break;
		case "className":
			driver.findElement(By.className(value)).sendKeys(input);
			break;
		case "linkText":
			driver.findElement(By.linkText(value)).sendKeys(input);
			break;
		case "partialLinkText":
			driver.findElement(By.partialLinkText(value)).sendKeys(input);
		default:
			System.err.println("invalid locator:please refer java doc");
			break;
		}

	}
}
