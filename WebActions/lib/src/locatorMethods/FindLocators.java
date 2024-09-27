package seleniumWebActions.locatorMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FindLocators {
	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 */
	public void startBrowser() throws MalformedURLException {
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
	}

	/**
	 * use this method to open the url of an application
	 */
	public void openURL(String browserURL) {

		System.out.println("opening website --->" + browserURL);
		driver.get(browserURL);

		System.out.println("Maximizing window...");
		driver.manage().window().maximize();
	}

	/**
	 * use this method to locate login button and print the locator.
	 */
	public void locateWebElements() {
		// TODO : Locate the username text box on page and print the locator
		System.out.println("Locate username text box : ");
		WebElement userName = driver.findElement(By.id("username"));
		System.out.println("Locator value :" + userName);
		
		// TODO : Locate the password text box on page and print the locator
		System.out.println("Locate password text box : ");
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Locator value : " + password.toString());

		// TODO : Locate the login button on page and print the locator
		System.out.println("Locate the Login button : ");
		WebElement logInButton = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/button"));
		System.out.println("Locator value : " + logInButton.toString());
	}

	/**
	 * use this method to close the current window of browser
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}

	public void run() throws MalformedURLException {

		//object of FindLocators class
		FindLocators locators = new FindLocators();

		// TODO: Call the method startBrowser
		locators.startBrowser();
		
		// TODO: Call the method openURL
		locators.openURL("https://crio-qkart-frontend-qa.vercel.app/login");
		
		// TODO: Call the method locateWebElements 
		locators.locateWebElements();
		
		// TODO: Call the method closeBrowser
		locators.closeBrowser();
	}
}
