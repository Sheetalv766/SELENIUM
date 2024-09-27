package seleniumWebActions.webDriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationCommands {
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

		System.out.println("Opening website --->" + browserURL);
		driver.get(browserURL);

		System.out.println("Maximizing window...");
		driver.manage().window().maximize();
	}
	
	/**
	 * use this method to open new url
	 * @param url
	 */
	public void navigateToUrl(String url) {
		// TODO - open the url in browser using to()
		System.out.println("Open URL :" + url);
		driver.navigate().to(url);

		// TODO - print the cureent url
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url :" + currentUrl);

	}
	
	/**
	 * use this method to click on back 
	 * button on browser
	 */
	public void backToPreviousUrl() {
		//TODO - go back to previous url
		driver.navigate().back();
		System.out.println("Going back to previous url :");

		//TODO - print the current url
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url :" + currentUrl);
	}
	
	/**
	 * use this method to click on forward 
	 * button on browser
	 */
	public void goToNextUrl() {
		// TODO - go to next/forward url
		System.out.println("Go to next url :");
		driver.navigate().forward();

		// TODO - print the current url
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current url :" + currentUrl);

	}
	
	/**
	 * use this method to click on refresh button
	 * on browser
	 */
	public void refreshPage() {
		//TODO - refresh the web page
		driver.navigate().refresh();

	}
	
	/**
	 * use this method to close the current window of browser 
	 */
	public void closeBrowser() {
		driver.close();
	}
	
	public  void run() throws MalformedURLException {
		NavigationCommands commands = new NavigationCommands();
		
		// start the browser
		commands.startBrowser();

		// TODO: Call the method openURL to open
		// https://crio-qkart-frontend-qa.vercel.app/
		commands.openURL("https://crio-qkart-frontend-qa.vercel.app/");

		// TODO: Call the method navigateToUrl to navigate to
		// https://crio-qkart-frontend-qa.vercel.app/login
		commands.navigateToUrl("https://crio-qkart-frontend-qa.vercel.app/login");
		
		// TODO: Call the method backToPreviousUrl
		commands.backToPreviousUrl();
		
		// TODO: Call the method goToNextUrl 
		commands.goToNextUrl();

		// TODO: Call the method refreshPage
		commands.refreshPage();
		
		// TODO: Call the methods closeBrowser
		commands.closeBrowser();

	}
}
