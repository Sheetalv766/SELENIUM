package com.crio.webActions;

import java.util.List;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnRadioButton {

	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 * 
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
	 * use this method to check whether radio button is displayed or not
	 * 
	 */
	public boolean checkElementIsDisplayed(WebElement webElement) {
		boolean isDisplayed = false;

		// TODO : Check whether radio button is displayed or not
		isDisplayed = webElement.isDisplayed();

		return isDisplayed;
	}

	/**
	 * use this method to check whether radio button is enabled or not
	 */
	public boolean checkElementIsEnabled(WebElement webElement) {
		boolean isEnabled = false;

		// TODO : Check whether radio button is is enabled or not
		isEnabled = webElement.isEnabled();

		return isEnabled;
	}

	/**
	 * use this method to check whether radio button is selected or not
	 * 
	 */
	public boolean checkElementIsSelected(WebElement webElement) {
		boolean isSelected = false;

		// TODO : Check whether radio button is selected or not
		isSelected = webElement.isSelected();

		return isSelected;
	}

	/**
	 * use this method to retrieve the attribute value
	 */
	public String getAttributeValue(WebElement webElement, String attributeName) {
		String attributeValue = null;

		// TODO : Retrieve attribute value
		attributeValue = webElement.getAttribute(attributeName);

		return attributeValue;
	}

	/**
	 * use this method to perform click on radio button
	 */
	public void clickOnBtn(WebElement webElement) {
		// TODO : Perform click operation on button
		webElement.click();
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
		this.openURL("https://web-locators-static-site-qa.vercel.app/Radio");

		WebElement radioFemale;

		// Step - 3 : In the radio button group "Select Your Gender"
		// TODO : Locate the radio button "Female" and assign it to radioFemale.
		radioFemale = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/fieldset/div/div/div[1]/div/label/span[1]/span[1]/input"));

		// TODO: Check whether "Female" is selected by default - Call the method
		// checkElementIsSelected()
		boolean isSelect = this.checkElementIsSelected(radioFemale);
		System.out.println("Female radio buttion is selected :" + isSelect);

		// TODO: Retrieve the attribute value - Type | Value of "Female" option - Call
		// the method getAttributeValue()
		String typeAttr = this.getAttributeValue(radioFemale, "type");

		// TODO: Print the response
		System.out.println("Type attribute value for Female Radio button :" + typeAttr);

		WebElement radioVeryGood;

		// Step - 4 : In the radio button group "Rate yourself in JAVA"
		// TODO : Locate the radio button - Very Good and assign it to radioVeryGood
		radioVeryGood = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/fieldset/div/div/div[1]/div/label/span[1]/span[1]/input"));

		// TODO : Select "Very Good" rating - Call method clickOnBtn()
		this.clickOnBtn(radioVeryGood);

		WebElement radioYes;
		 WebElement radioNo;

		// Step - 5 : In the radio button group "Is your PAN Card or other Photo ID card
		// linked"

		// TODO: Locate all the radio button "Is your PAN Card or other Photo ID card
		// linked" and and assign it to radioYes | radioNo
		radioYes = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/fieldset/div/div/div[1]/div/label/span[1]/span[1]/input"));
		radioNo = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/fieldset/div/div/div[2]/div/label"));

		// TODO: Check whether the "No" option is disabled - Call the method
		// checkElementIsDisplayed()
		boolean isdis = this.checkElementIsDisplayed(radioNo);
		System.out.println("No option is displayed : " + isdis);

		// TODO: Check whether the "Yes" option is enabled - Call the method
		// checkElementIsEnabled()
		boolean isena = this.checkElementIsDisplayed(radioYes);
		System.out.println("Yes option is enabled : " + isena);

		// TODO: Select the "Yes" option - Call the method clickOnBtn()
		this.clickOnBtn(radioYes);

		// Call the method closeBrowser
		this.closeBrowser();
	}
}
