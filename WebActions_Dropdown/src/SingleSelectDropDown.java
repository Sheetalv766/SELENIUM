package com.crio.webActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.lang.model.element.ExecutableElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleSelectDropDown {

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
	 * use this method to select option based on its visible text.
	 * 
	 * @param webElement
	 * @param value
	 */
	public void selectByVisibleText(WebElement webElement, String value) {
		// TODO : Create the object of Select class and pass webElement to its
		// constructor
		Select dropDown = new Select(webElement);
			
		// TODO : Using object of Select class call the method and pass value
		dropDown.selectByVisibleText(value);
		
	}

	/**
	 * use this method to select the last option from dropdown
	 * 
	 * @param webElement
	 */
	public void selectLastOption(WebElement webElement) {
		List<WebElement> options;
		int index;

		// TODO : Create the object of Select class and pass webElement to its
		// constructor
		Select dropDown = new Select(webElement);
		
		// TODO : Using object of Select class call the method get all the options from
		// dropdown and assing it to options
		options= dropDown.getOptions();

		// TODO : Find out the last index of option
		index = options.size();
		index = index -1;
		
		// TODO : Using object of Select class call the method and pass the index
		dropDown.selectByIndex(index);
	}

	/**
	 * use this method to check whether dropdown is multi select or not
	 * 
	 * @param webElement
	 * @return
	 */
	public boolean isMultipleOptions(WebElement webElement) {
		boolean isMultiple = false;
		// TODO : Create the object of Select class and pass webElement to its
		// constructor
		Select dropDown = new Select(webElement);
		
		// TODO : Using object of Select class call the method and assign result into
		// isMultiple
		isMultiple = dropDown.isMultiple();

		return isMultiple;
	}

	/**
	 * use this method to find default selected option
	 * 
	 * @param webElement
	 */
	public void getDefaultOption(WebElement webElement) {
		WebElement defaultValue;

		// TODO: Create the object of Select class and pass webElement to its
		// constructor.
		Select dropDown = new Select(webElement);
		
		// TODO: Using object of Select class call the method and assign result to
		// defaultValue
		defaultValue = dropDown.getFirstSelectedOption();

		// TODO: Print the text
		System.out.println("Default value : " + defaultValue.getText());
		
	}

	/**
	 * use this method to print all the option from dropdown
	 * 
	 * @param webElement
	 */
	public void printOptions(WebElement webElement) {
		List<WebElement> allOptions;

		// TODO: Create the object of Select class and pass webElement to its
		// constructor.
		Select dropDown = new Select(webElement);
	

		// TODO: Using object of Select class call the method get all the options
		// present in
		// the dropdown and assign to allOptions.
		allOptions = dropDown.getOptions();
		
		// TODO: Print the text of option using for each loop
		System.out.println("All the options in dropdown : ");
		for(WebElement option : allOptions)
		{
			System.out.println(option.getText());
		}
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
		this.openURL("https://web-locators-static-site-qa.vercel.app/Dropdown");

		// Step - 3
		// TODO : Locate the "Which country do you want to travel" and assign to
		// "country"
		// WebElement country;
		WebElement country = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div/select"));
		
		// TODO : Call the method selectByVisibleText() to select "Australia"
		this.selectByVisibleText(country, "Australia");
		
		// Step - 4
		// WebElement movies;

		// TODO : Locate the "What would you prefer to watch among the listed movies?"
		// dropdown and assign to "movies"
		WebElement movies = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/div/div/select"));

		// TODO : Call the method selectLastOption() to select the last option in
		// "movies"
		this.selectLastOption(movies);

		// Step - 5
		// WebElement fruits;

		// TODO : Locate the "What would you prefer to eat among the listed fruits?"
		// dropdown and assign to "fruits"
		WebElement fruits = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/select"));

		// TODO : Call the method isMultipleOptions and print the response of
		// isMultipleOptions()
		this.isMultipleOptions(fruits);

		// TODO: Call the method getDefaultOption
		this.getDefaultOption(fruits);
		

		// TODO: Call the method printOptions
		this.printOptions(fruits);
		
		// Call the method closeBrowser
		this.closeBrowser();
	}
}
