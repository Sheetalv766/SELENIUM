package com.crio.webActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StaticTableShoeSize {
	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 */
	public WebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

		return driver;
	}

	/**
	 * use this method to open the url of an application
	 */
	public void openURL(String browserURL) {

		System.out.println("maximize the window..");
		driver.manage().window().maximize();

		System.out.println("opening website --->" + browserURL);
		driver.get(browserURL);
	}

	/**
	 * use this method to select the shoe size
	 */
	public void selectShoeSize(WebElement webElement) {
		// Click on the radio button
		webElement.click();
	}

	public void printHeelToToeValue(WebElement webElement) {
		String value = null;
		// get the Heel To Toe value
		value = webElement.getText();
		System.out.println("Heel To Toe value is : " + value);
	}

	/**
	 * use this method to close the current window of browser
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}

	public void run() throws MalformedURLException {
		

		// Step - 1 : Call the method startBrowser
		WebDriver driver = this.startBrowser();

		// Step - 2 : Call the method openURL
		this.openURL("https://web-locators-static-site-qa.vercel.app/Web%20Table");

		// Step - 3 : Select your shoe size(By Clicking on the radio button in the
		// specific row)
		
		// WebElement shoeSize;
		// TODO: Locate the radio button of shoe size which you want to select and assign it
		// to shoeSize
		WebElement shoeSize = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/fieldset/label/span[1]/span[1]/input"));

		// TODO: Call the method selectShoeSize
		this.selectShoeSize(shoeSize);

		// Step - 3 : Select your shoe size(By Clicking on the radio button in the
		// specific row)

		// WebElement heelToToe;
		// TODO: Locate the heelToToe cell of your selected shoe size
		WebElement heelToToe = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[5]"));

		// TODO: Call the method printHeelToToeValue
		this.printHeelToToeValue(heelToToe);

		// Call the method closeBrowser
		this.closeBrowser();
	}
}
