package com.crio.seleniumWebActions;

import java.util.List;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

public class LearnHyperLink {

	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 * 
	 */
	public WebDriver startBrowser() throws MalformedURLException {
		System.out.println("Starting the browser...");

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
	 * use this method to check whether hyperlink isDisplayed or not
	 * 
	 */
	public boolean checkElementIsDisplayed(WebElement webElement) {
		boolean isDisplayed = false;

		// TODO : Check whether hyperlink is isDisplayed or not
		isDisplayed = webElement.isDisplayed();

		return isDisplayed;
	}

	/**
	 * use this method to check whether hyperlink isEnabled or not
	 */
	public boolean checkElementIsEnabled(WebElement webElement) {
		boolean isEnabled = false;

		// TODO : Check whether hyperlink is isEnabled or not
		isEnabled = webElement.isEnabled();

		return isEnabled;
	}

	/**
	 * use this method to get the count of links on page
	 * 
	 * @param webElement
	 */
	public int totalLinksOnPage(List<WebElement> webElement) {
		int totalLinks = 0;

		// TODO : Count the total number of links
		totalLinks = webElement.size();

		return totalLinks;
	}

	/**
	 * use this method to retrieve the attribute value
	 * 
	 * @param webElement
	 * @return
	 */
	public String getAttributeValue(WebElement webElement, String attributeName) {
		String attributeValue = null;

		// TODO : Retrieve attribute value
		attributeValue = webElement.getAttribute(attributeName);

		return attributeValue;
	}

	/**
	 * use this method to get the text of hyperlink
	 * 
	 * @return
	 */
	public String getText(WebElement webElement) {
		String text = null;

		// TODO : get the link text
		text = webElement.getText();

		return text;
	}

	/**
	 * use this methods to check give text is present in the link or not
	 * 
	 * @param webElement
	 * @param text
	 */
	public void checkTextIsPresent(List<WebElement> webElement, String text) {
		int count=0;
		// TODO : Check whether the given text is present in links and return the count of links containing the text
		for(WebElement elem : webElement)
	{
		if(elem.getText().equals(text))
		count += 1;
	}

		System.out.println("Number of links containing text Crio.Do is: "+count);
	}

	/**
	 * use this method to perform click on hyperlink
	 */
	public void clickOnLink(WebElement webElement) {
		// TODO : Perform click operation on hyperlink
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
		this.openURL("https://web-locators-static-site-qa.vercel.app/hyperlink");

		// Step - 3 : Check whether the "Crio.Do" link is displayed
		WebElement linkCrioDo;
		// TODO: Locate the Link "Crio.do" and assign it to linkCrioDo
		linkCrioDo = driver.findElement(By.partialLinkText("Crio.do"));

		// TODO: Check Link "Crio.Do" is displayed - call the method
		// checkElementIsDisplayed()
		boolean isdis = this.checkElementIsDisplayed(linkCrioDo);
		System.out.println("Crio.do link is dispalyed : " + isdis);

		// TODO: Check if the link "Crio.Do" is enabled - call the method
		// checkElementIsEnabled()
		boolean isena = this.checkElementIsEnabled(linkCrioDo);
		System.out.println("Crio.do link is enabled : " + isena);

		// TODO: Read the text from the hyperlink
		String text = this.getText(linkCrioDo);

		// TODO: Print the link text
		System.out.println("Crio.do link text : " + text);

		// TODO: Retrieve the "href" attribute value.
		String href = this.getAttributeValue(linkCrioDo, "href");

		// TODO: Print the href
		System.out.println("Crio.do href attribute value :" + href);

		WebElement linkExternalPage;
		// TODO: Locate the Link "Find out how many links are available" and assign it
		// to linkExternalPage
		linkExternalPage = driver.findElement(By.partialLinkText("Find out how many links are available"));

		// TODO: Click on link under the "Find out how many links are available" text
		this.clickOnLink(linkExternalPage);

		List<WebElement> totalLinks;
		// TODO: Count the total hyper links present on the web page - Locate all the
		// links, assign to totalLinks and call the method totalLinksOnPage()
		totalLinks = driver.findElements(By.tagName("a"));

		// TODO: Print the count of links
		int totalLink = this.totalLinksOnPage(totalLinks);
		System.out.println("Total links : " +totalLink);

		// TODO: Find number of visible and not-visible links by passing totalLinks
        // links one by one to method checkElementIsDisplayed()
		int visible = 0;
		int notvisible = 0;
		for(WebElement elem : totalLinks){
			if(this.checkElementIsDisplayed(elem))
			visible += 1;
			else
			notvisible += 1;
		}
		System.out.println("No. of links visible : " + visible);
		System.out.println("No. of links notvisible : " + notvisible);

		// TODO: How many links are having text "Crio.Do" - pass totalLinks one by one
		// link to method checkTextIsPresent()
		this.checkTextIsPresent(totalLinks, "Crio.Do");

		// Call the method closeBrowser
		this.closeBrowser();
	}
}
