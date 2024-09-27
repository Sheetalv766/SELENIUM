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

public class ProductCountUsingFindElementsBy {
	RemoteWebDriver driver = null;

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

		System.out.println("");
		driver.manage().window().maximize();
	}

	/**
	 * use this method to locate all the products on page and print the total number
	 * of products available.
	 */
	public void totalProducts() {
		int count = 0;
		// TODO: Locate all the products available on web page and print the count
		System.out.println("Locate all the products available : ");
		List<WebElement>allProducts = driver.findElementsByXPath("//*[@id='root']/div/div/div/div/div/div/div/img");
		System.out.println("Count :" + allProducts.toString());
		
	}

	/**
	 * use this method to close the current window of browser 
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}

	public void run() throws MalformedURLException {
		
		ProductCountUsingFindElementsBy products = new ProductCountUsingFindElementsBy();

		// TODO: Call the method startBrowser
		products.startBrowser();

		// TODO: Call the method openURL to open https://crio-qkart-frontend-qa.vercel.app
		products.openURL("https://crio-qkart-frontend-qa.vercel.app");

		// TODO: Call the method totalProducts
		products.totalProducts();

		// TODO: Call the method closeBrowser
		products.closeBrowser();

	}
}
