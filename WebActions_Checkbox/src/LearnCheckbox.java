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

public class LearnCheckbox {

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
	 * use this method to check whether check box displayed or not
	 * 
	 */
	public boolean checkElementIsDisplayed(WebElement webElement) {
		boolean isDisplayed = false;

		// TODO : Check whether check box is displayed or not
		isDisplayed = webElement.isDisplayed();

		return isDisplayed;
	}

	/**
	 * use this method to check whether check box enabled or not
	 */
	public boolean checkElementIsEnabled(WebElement webElement) {
		boolean isEnabled = false;

		// TODO : Check whether check box is enabled or not
		isEnabled = webElement.isEnabled();

		return isEnabled;
	}

	/**
	 * use this method to check whether check box is selected or not
	 * 
	 */
	public boolean checkElementIsSelected(WebElement webElement) {
		boolean isSelected = false;

		// TODO : Check whether check box is selected or not
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
	 * use this method to perform click on check box
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
		this.openURL("https://web-locators-static-site-qa.vercel.app/Checkbox");

		WebElement chkBoxQA;
		WebElement chkBoxFDT;
		WebElement chkBoxBDT;
		WebElement chkBoxDSA;

		// Step - 3 : In the check box "To which course are you enrolled into?""

		// TODO: Locate the check box under "To which course are you enrolled into?" an
		// assign it to chkBoxQA |chkBoxFDT | chkBoxBDT |chkBoxDS

		chkBoxQA = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/div/span/input"));
		chkBoxFDT = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[2]/div/div/span/input"));
		chkBoxBDT = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[3]/div/div/span/input"));
		chkBoxDSA = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[4]/div/div/span/input"));

		// TODO: List the options which are enabled(clickable). Use
		// checkElementIsEnabled()
		boolean isdisQA = this.checkElementIsEnabled(chkBoxQA);
		boolean isDisFDT = this.checkElementIsEnabled(chkBoxFDT);
		boolean isDisBDT = this.checkElementIsEnabled(chkBoxBDT);
		boolean isDisDSA = this.checkElementIsEnabled(chkBoxDSA);


		// TODO: Print the response
		System.out.println("Checkbox QA is displayed : " + isdisQA);
		System.out.println("Checkbox FDT is displayed : " + isDisFDT);
		System.out.println("Checkbox BDT is displayed : " + isDisBDT);
		System.out.println("Checkbox DSA is displayed : " + isDisDSA);


		// TODO: Select QA | DSA. Call the method clickOnBtn
		this.clickOnBtn(chkBoxQA);
		this.clickOnBtn(chkBoxDSA);


		// TODO: Retrieve attributes value (type and value) for - FDT,DSA
		// Call the method getAttributeValue
		String attrFDT = this.getAttributeValue(chkBoxFDT, "type");
		String attrValueFDT = this.getAttributeValue(chkBoxFDT, "value");
		String attrDSA = this.getAttributeValue(chkBoxDSA, "type");
		String attrValueDSA = this.getAttributeValue(chkBoxDSA, "value");

		// TODO: Print the attribute values
		System.out.println("Type attri for FDT checkbox : " + attrFDT);
		System.out.println("Value attri for FDT checkbox : " + attrValueFDT);
		System.out.println("Type attri for DSA checkbox : " + attrDSA);
		System.out.println("Value attri for DSA checkbox : " + attrValueDSA);


		WebElement chkBoxUnknown;
		WebElement chkBoxAndroid;

		// Step - 4 In the check box "Your phone has which Operating System (OS)?"
		// TODO: Locate the check box 1) Unknown and 2) Android and assign it to
		// chkBoxUnknown |chkBoxAndroid |
		chkBoxUnknown= driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[1]/div/div/span/input"));
		chkBoxAndroid= driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[3]/div/div/span/input"));

		// TODO: Call the method checkElementIsSelected() to check default selected
		// check box - chkBoxUnknown.
		boolean isselected = this.checkElementIsSelected(chkBoxUnknown);

		// TODO: Print the response
		System.out.println("Unknown checkbox is Selected by default : " + isselected);

		// TODO: Call the method clickOnBtn - To De-select default selected check box -
		// chkBoxUnknown
		this.clickOnBtn(chkBoxUnknown); 

		// TODO: Call the method clickOnBtn - To select "Android or iOS"
		this.clickOnBtn(chkBoxUnknown);

		// List<WebElement> days;

		// Step - 5 : In check box "Select all the possible days when you could watch a
		// phone"
		// TODO: Locate all the check box under "Select all the possible days when you
		// could watch a phone"
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]"));

		// TODO: Call the method clickOnBtn
		for(WebElement day : days)
		{
			this.clickOnBtn(day);
		}

		// Call the method closeBrowser
		this.closeBrowser();
	}
}
