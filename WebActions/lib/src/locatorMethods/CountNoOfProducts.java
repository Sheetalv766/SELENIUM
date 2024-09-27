package seleniumWebActions.locatorMethods;

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

public class CountNoOfProducts {
	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 */
	public void startBrowser() throws MalformedURLException {
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

		// TODO - Set implicity wait for 20 seconds
		System.out.println("Implicity Wait : ");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * use this method to open the url of an application
	 */
	public void openURL(String browserURL) {

		System.out.println("opening website --->" + browserURL);
		driver.get(browserURL);

		System.out.println("");
		driver.manage().window().maximize();
	}

	/**
	 * use this method to locate all the products on page and print the total number
	 * of product listed.
	 */
	public void totalCountOfProducts() {
		int count = 0;
		// TODO: Locate all the links available on web page and print the count
		System.out.println("Locate all the links : ");
		List<WebElement>allLinks = driver.findElements(By.xpath("//*[@id='root']/div/div/div/div/div/div/div/img"));
		System.out.println("Total links : " + allLinks.size());
	}

	/**
	 * use this method to close the current window of browser
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}

	public void run() throws MalformedURLException {

		CountNoOfProducts products = new CountNoOfProducts();
		
		// TODO: Call the method startBrowser
		products.startBrowser();

		// TODO: Call the method openURL to open
		// "https://crio-qkart-frontend-qa.vercel.app/"
		products.openURL("https:crio-qkart-frontend-qa.vercel.app/");
		
		// TODO: Call the method totalCountOfLinks
		products.totalCountOfProducts();

		// TODO: Call the method closeBrowser
		products.closeBrowser();

	}
}