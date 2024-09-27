package seleniumWebActions.browserInit;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserInit {

	/**
	 * use this method to initialize the browser.
	 */
	public void startBrowser() throws MalformedURLException {
		// TODO : Initialise and start a Chrome window using RemoteWebDriver class
		
// Code to Launch Browser using Zalenium in Crio workspace
final DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setBrowserName(BrowserType.CHROME);
WebDriver driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"),
        capabilities);
	}

	public void run() throws MalformedURLException {
		this.startBrowser();
	}

}
