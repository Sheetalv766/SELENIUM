package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Clicks {

	static RemoteWebDriver driver = null;

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

		System.out.println("Browser started");

		return driver;
	}

	public void run() throws InterruptedException, MalformedURLException {
		this.startBrowser();

		//Mazimize current window
		driver.manage().window().maximize();

		//create an object of action class
		Actions actions = new Actions(driver);

		// TODO - Add your implementation here

		// Navigate to https://web-locators-static-site-qa.vercel.app
		driver.get("https://web-locators-static-site-qa.vercel.app");

		// Click on the “Mouse” button
		WebElement mouseBtn = driver.findElement(By.xpath("//p[text()='Mouse']"));
		mouseBtn.click();
		Thread.sleep(2000);

		// Perform a single click on ‘Click Here ‘ button
		WebElement singleClickBtn = driver.findElement(By.xpath("//img[@alt='buttonimage']"));
		actions.click(singleClickBtn).perform();
		Thread.sleep(2000);

		// Perform double-click on ‘Click Here ‘ button
		WebElement doubleClickbtn = driver.findElement(By.xpath("//img[@alt='buttonimage']"));
		actions.doubleClick(doubleClickbtn).perform();
		Thread.sleep(2000);

		// Perform right-click on ‘Click Here ‘ button
		WebElement performRightClick = driver.findElement(By.xpath("//img[@alt='buttonimage']"));
		actions.contextClick(performRightClick).perform();
		Thread.sleep(2000);

		driver.quit();
		System.out.println("Driver closed");
	}
}
