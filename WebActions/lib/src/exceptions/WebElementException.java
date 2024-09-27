package seleniumWebActions.exceptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebElementException {
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

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
	}
	
	/**
	 * use this method to locate login button
	 * and print the locator.
	 */
	public void locateLoginBtn() {
		System.out.println("Locating login button on page");
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
		
		driver.navigate().refresh();
		loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
		loginButton.click();
		
		System.out.println("Locator value : "+loginButton.toString());
	}

	/**
	 * use this method to close the current window of browser 
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}
	
	public void run() throws MalformedURLException {
		

		//Call the method startBrowser
		this.startBrowser();
		
		//Call the method openURL
		this.openURL("https://crio-qkart-frontend-qa.vercel.app/");
		
		//Call the method locateLoginBtn 
		this.locateLoginBtn();
		
		//Call the method closeBrowser
		this.closeBrowser();

	}
}
