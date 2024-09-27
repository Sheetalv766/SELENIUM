package webElement;

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

public class LearnButton {

	RemoteWebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 * 
	 */
	public RemoteWebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"),
			capabilities);

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
	public boolean checkElementIsDisplayed(WebElement elem) {
		boolean isDisplay = false;

		// TODO : Check whether button is isDisplayed or not.

		isDisplay = elem.isDisplayed();

		return isDisplay;
	}

	/**
	 * use this method to check button isEnabled or not
	 */
	public boolean checkElementIsEnabled(WebElement webElement) {
		boolean isEnable = false;
		
		// TODO : Check whether button is isEnabled or not.
		isEnable = webElement.isEnabled();
		
		return isEnable;
	}

	/**
	 * use this method to get the height and width of element
	 */
	public void getSizeOfElement(WebElement webElement) {
		int height = 0;
		int width = 0; 
		
		// TODO : Get the size of button
		height = webElement.getSize().getHeight();
        width = webElement.getSize().getWidth();
		
		System.out.println("height is : " +height);
		System.out.println("width is : " +width);
	}
	
	/**
	 * use this method to get the height and width of element
	 */
	public void getPositionOfElement(WebElement webElement) {
		int coordinateX = 0;
		int coordinateY = 0; 
		
		// TODO : Get the position of button
		coordinateX = webElement.getLocation().getX();
		coordinateY = webElement.getLocation().getY();

		System.out.println("coordinate X is : " +coordinateX);
		System.out.println("coordinate y is : " +coordinateY);
	}
	
	/**
	 * use this method to retrieve the label on button
	 */
	public String getTextOfElement(WebElement webElement) {
		String label = null;

		// TODO : Retrieve the text/label of the button.
		label = webElement.getText();
		
		return label;
	}

	/**
	 * use this method to retrieve the css value of button
	 */
	public String getColorOfElement(WebElement webElement) {
		String color = null;
		
		// TODO : Retrieve the css value of "color"
		color = webElement.getCssValue("color");
		
		return color;
	}

	public String getAttributeValue(WebElement webElement) {
		String attributeValue = null;
		
		// TODO : Retrieve class attribute value
		attributeValue = webElement.getAttribute("class");
		
		return attributeValue;
	}
	/**
	 * use this method to perform click on button
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

	public void run() throws MalformedURLException, InterruptedException {

		// Step - 1 : Call the method startBrowser
		RemoteWebDriver driver = this.startBrowser();

		// Step - 2 : Call the method openURL
		this.openURL("https://web-locators-static-site-qa.vercel.app/Button");
		 
		 WebElement btnClickThisButton;
		 
		/**
		 * Step - 3 : 
		 * TODO : Locate the button "Click this button" and assign it to btnClickThisButton 
		 * TODO : Call the method checkElementIsDisplayed 
		 * TODO : Print the response
		 */
		
		btnClickThisButton = driver.findElement(By.xpath("//*[@id='root']/a/button/p"));
		boolean isdis = this.checkElementIsDisplayed(btnClickThisButton);
		System.out.println("Button is dispalyed..." + isdis);

		/**
		 * Step - 4 
		 * TODO : Call the method checkElementIsEnabled 
		 * TODO : Print the response
		 */
		
		 boolean isena = this.checkElementIsEnabled(btnClickThisButton);
		 System.out.println("Button is enabled..." + isena);

		/**
		 * Step - 5 :
		 * TODO : Call the method getSizeOfElement 
		 *
		 */

		 this.getSizeOfElement(btnClickThisButton);
		
		/**
		 * Step - 6 
		* TODO : Call the method getPositionOfElement
		*/

		this.getPositionOfElement(btnClickThisButton);

		/**
		 * Step - 7
		 * TODO : Call the method getTextOfElement
		 * TODO : Print the response
		 */

		 String label = this.getTextOfElement(btnClickThisButton);
		 System.out.println("Text on the button : " + label);

		/**
		 * Step - 8 
		 * TODO : Call the method getColorOfElement
		 * TODO : Print the response
		 */

		 String color = this.getColorOfElement(btnClickThisButton);
		 System.out.println("Color of the button is : " + color);
	
		/**
		 * Step - 9 
		 * TODO : Call the method getAttributeValue
		 * TODO : Print the response
		 */

		 String attr = this.getAttributeValue(btnClickThisButton);
		 System.out.println("Attribute value is : " + attr);
		
		/**
		 * Step - 10 
		 * TODO : Call the method clickOnBtn to click on the submit button
		 */

		 this.clickOnBtn(btnClickThisButton);
			
		WebElement btnRest;
		
		/**
		 * Step - 11
		 * TODO : Locate the button "Reset" and assign it to btnRest 
		 * TODO : Call the method getColorOfElement 
		 * TODO : Print the response
		 */

		 btnRest = driver.findElement(By.xpath("//*[@id='root']/div[2]/a/button"));
		 this.getColorOfElement(btnRest);
		 System.out.println("Color of the Reset button : " + btnRest);

		/**
		 * Step - 12
		 * TODO : Call the method clickOnBtn to click on the reset button
		 */
		 	
		 this.clickOnBtn(btnRest);
		 
		// Call the method closeBrowser
		this.closeBrowser();
	}
}
