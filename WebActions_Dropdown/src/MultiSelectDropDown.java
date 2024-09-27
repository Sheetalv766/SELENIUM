package com.crio.webActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {

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
	 * use this method to close the current window of browser
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}
	
	/**
	 * use this method to print all selected options
	 * @param webElement
	 */
	public void printAllSelectedOptions(WebElement webElement) {
		
		List<WebElement> allOptions;
		
		//TODO : Create the object of Select class and pass webElement to its constructor.
		Select select = new Select(webElement);

		//TODO : Using object of Select class call the method and assign result to allOptions
		allOptions = select.getAllSelectedOptions();

	    //TODO : Print the text of option using for each loop
		System.out.println("All the selected options :");
		for(WebElement option : allOptions)
		{
			System.out.println(option.getText());
		}
	}
	/**
	 * use this method to print the first selected option
	 * @param webElement
	 */
	public void printFirstSelectedOption(WebElement webElement) {
		WebElement firstSelectedOption;
		String firstOption;
		//TODO : Create the object of Select class and pass webElement to its constructor.
		Select select = new Select(webElement);

		//TODO : Using object of Select class call the method and assign result to firstSelectedOption
		firstSelectedOption = select.getFirstSelectedOption();

		//TODO : Use get Text method on firstSelectedOption and assign value to firstOption
		firstOption = firstSelectedOption.getText();

		//TODO : Print the firstOption
		System.out.println("First option selected : " + firstOption);
	}
	
	/**
	 * use this method to select option based on its text
	 * @param webElement
	 * @param value
	 */
	public void selectValueByText(WebElement webElement,List<String> value) {
		//TODO : Create the object of Select class and pass webElement to its constructor.
		Select select = new Select(webElement);

		//TODO : Using for each loop, iterate value and pass it to Select class method.
		for (String val : value)
		{
			System.out.println("Selected : " + val);
			select.selectByVisibleText(val);
		}
	}
	
	public void run() throws MalformedURLException {
		
		// Step - 1 : Call the method startBrowser
		WebDriver driver = this.startBrowser();

		// Step - 2 : Call the method openURL
		this.openURL("https://web-locators-static-site-qa.vercel.app/Dropdown");

		// TODO: locate MultiSelect Dropdown tab
		WebElement multiSelect = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/div/div/button[2]/span[1]"));
		System.out.println("Locate MultiSelect Dropdown Tab : " + multiSelect);
		multiSelect.click();

		// perform click operation on the tab
        
		WebElement skills;
		/*
		 * Step - 3 : 
		 * TODO : Locate the dropdown "Skills" and assign it to skills
		 * TODO : Call the method printAllSelectedOptions
		 * TODO : Call the method printFirstSelectedOption
		 */
		skills = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/select"));
		this.printAllSelectedOptions(skills);
		this.printFirstSelectedOption(skills);

		WebElement weeks;
		List<String> days;
		/**
		 * Step - 4 : 
		 * TODO : Locate the dropdown "On which days of the week, could you watch TV?" and assign it to skills
		 * TODO : Store days which you want to select in "days" list. Call the method selectValueByText 
		 */
		
		weeks = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/select"));
		days = new ArrayList<>();
		days.add("Monday");
		days.add("Friday");
		days.add("Sunday");
	 	
		// Call the method closeBrowser
		this.closeBrowser();
	}
}
