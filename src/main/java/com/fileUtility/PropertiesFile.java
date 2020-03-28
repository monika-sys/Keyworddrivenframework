package com.fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.keywords.Constants;

public class PropertiesFile {
	/**
	 * This method will open only ObjectRepository.properties file and return value
	 * associeted with the key
	 * 
	 * @author monika hase
	 * @param key
	 * @return value{@code String value}
	 */
	public static String getProperty(String key) {
		String value = null;
		try {
			Constants.fis = new FileInputStream(
					"C:\\Users\\monika hase\\eclipse-workspace\\KeywordDriven\\src\\main\\resources\\input\\ObjectRepository.properties");
			Constants.prop = new Properties();
			Constants.prop.load(Constants.fis);
			value = Constants.prop.getProperty(key);

		} catch (FileNotFoundException e) {
			System.out.println("file is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to load file");
			e.printStackTrace();
		}

		return value;

	}

	/**
	 * this method is used to read any file which you want it will return value
	 * associted with that key
	 * 
	 * @author monika hase
	 * @param key
	 * @param filePath
	 * @return value {@code String value}
	 */
	public static String getProperty(String key, String filePath) {
		String value = null;
		try {
			Constants.fis = new FileInputStream(filePath);
			Constants.prop = new Properties();
			Constants.prop.load(Constants.fis);
			value = Constants.prop.getProperty(key);
		} catch (FileNotFoundException e) {
			System.out.println("file is no found" + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("unable to load file" + filePath);
			e.printStackTrace();
		}

		return value;
	}

	public static String[] getLocator(String key) {
		String[] value = null;
		try {
			Constants.fis = new FileInputStream(
					"C:\\Users\\monika hase\\eclipse-workspace\\KeywordDriven\\src\\main\\resources\\input\\ObjectRepository.properties");
			Constants.prop = new Properties();
			Constants.prop.load(Constants.fis);
			String part = Constants.prop.getProperty(key);
			value = part.split("##");
		} catch (FileNotFoundException e) {
			System.out.println("file " + Constants.fis + "not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to load file" + Constants.fis);
			e.printStackTrace();
		}

		return value;

	}
}
