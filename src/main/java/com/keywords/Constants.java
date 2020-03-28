package com.keywords;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ru.yandex.qatools.ashot.AShot;

public class Constants {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static WebElement element;
	public static Logger log;
	public static Actions action;
	public static Alert alert;
	public static AShot ashot;
}
