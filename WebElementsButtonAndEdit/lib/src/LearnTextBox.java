package webElement;

import java.util.List;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTextBox {

	RemoteWebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 * 
	 */
	public RemoteWebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

		// Maximize and Implicit Wait for things to initailize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	/**
	 * use this method to open the url of an application
	 */
	public void openURL(String browserURL) throws InterruptedException {
		System.out.println("opening website --->" + browserURL);
		driver.get(browserURL);
		Thread.sleep(5000);
	}

	/**
	 * use this method to check button isDisplayed or not
	 * 
	 */
	public boolean checkElementIsDisplayed(WebElement webElement) {
		boolean isDisplay = false;

		// TODO : Check whether text box is isDisplayed or not.
		isDisplay = webElement.isDisplayed();
		
		return isDisplay;
	}

	/**
	 * use this method to enter text in text box and text area
	 */
	public void enterText(WebElement webElement,String text) {
		// TODO : Enter the text into text box
		webElement.sendKeys(text);
		
	}
	
	/**
	 * use this method to retrieve/read the default(placeholder)
	 * from textbox/textarea
	 */
	
	public String getPlaceHolderText(WebElement webElement) {
		String defaultText = null;
		
		// TODO : retrieve/read the placeholder value
		defaultText = webElement.getAttribute("placeholder");
		
		return defaultText;
	}
	
	/**
	 * use this method to check button isEnabled or not
	 */
	public boolean checkElementIsEnabled(WebElement webElement) {
		boolean isEnable = false;
		
		// TODO : check whether textbox is isEnabled or not.
		isEnable = webElement.isEnabled();
		
		return isEnable;
	}

	/**
	 * use this method to get the height and width of element
	 */
	public void getSizeOfElement(WebElement webElement) {
		int height = 0;
		int width = 0; 
		
		// TODO : get the size of button
		height = webElement.getSize().getHeight();
		width = webElement.getSize().getWidth();

		System.out.println("height is : " +height);
		System.out.println("width is : " +width);

	}

	public void getTotalWebElement(List<WebElement> webElements) {
		int totalCount = 0;
		// TODO : count the total number of text box;
		totalCount = webElements.size();
		
		System.out.println("total number of text box are : " +totalCount);
		
	}
	
	/**
	 * use this method to close the current window of browser
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}

	public void run() throws InterruptedException, MalformedURLException {
		

		// Step - 1 : Call the method startBrowser
		RemoteWebDriver driver = this.startBrowser();

		// Step - 2 : Call the method openURL
		this.openURL("https://web-locators-static-site-qa.vercel.app/Edit");

		WebElement txtEnteryourName;
		
		/**
		 * Step - 3 : 
		 * TODO : Locate the text box "Enter your name" and assign it to txtEnteryourName
		 * TODO : Call the method checkElementIsDisplayed
		 * TODO : Print the response
		 */
		
		 txtEnteryourName = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input"));
		 boolean isdis = this.checkElementIsDisplayed(txtEnteryourName);
		 System.out.println("Button is displayed..." + isdis);

		/**
		 * Step - 4 : 
		 * TODO : Enter /Type your name in the "Enter your name" textbox.
		 */

		 this.enterText(txtEnteryourName, "Sheetal");
		
		/**
		 * Step - 5 : 
		 * TODO : Retrieve/read and print the placeholder value of "Your nationality" textbox
		 */
		
		String placeh = this.getPlaceHolderText(txtEnteryourName);
		System.out.println("Place holder value : " + placeh);
		WebElement txtWeightBefore;
		
		/**
		 * Step - 6 and Step - 7 : 
		 * TODO : Locate the text box "My weight before starting the wellness program(in kgs)" and assign it to txtWeightBefore
		 * TODO : Call the method checkElementIsEnabled
		 * TODO : Handle the exception using try-catch block
		 */
		
		txtWeightBefore = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input[2]"));
		boolean isenab = this.checkElementIsEnabled(txtWeightBefore);
		System.out.println("Textbox is enabled : " + isenab);
		try{
			this.enterText(txtWeightBefore,"Sheetal");
		}
		catch(ElementNotInteractableException ex)
		{
			System.out.println("Cannot enter the value in disabled textbox : ");
		} 

		/**
		 *  Step - 8 : 
		 *  TODO : Call the method getSizeOfElement 
		 *  
		 */

		this.getSizeOfElement(txtWeightBefore);
		
		List<WebElement> totalTextBox;
		
		/**
		 * Step - 9 : 
		 * TODO : Locate the all text box and assign it to totalTextBox.
		 * TODO : Call method getTotalWebElement
		 * 
		 */

		totalTextBox = driver.findElements(By.tagName("input"));
		this.getTotalWebElement(totalTextBox);

		// Call the method closeBrowser
		this.closeBrowser();
	}
}
