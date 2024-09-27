package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutoComplete {
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

		// TODO - Add your implementation here

		Actions actions = new Actions(driver);

		// Launch https://web-locators-static-site-qa.vercel.app/
		driver.get("https://web-locators-static-site-qa.vercel.app/");

		// Click on Auto-complete
		WebElement autoComp = driver.findElement(By.xpath("//p[text()='Auto-complete']"));
		actions.click(autoComp).perform();
		Thread.sleep(2000);

		// Click on text box
		WebElement textBox = driver.findElement(By.xpath("//input[@data-test='search-input']"));
		actions.click(textBox).perform();
		Thread.sleep(2000);

		// Type god
		WebElement typeInTxtBox =
				driver.findElement(By.xpath("//input[@data-test='search-input']"));
		typeInTxtBox.sendKeys("god");
		Thread.sleep(2000);

		// Select the option from dropdown with text “​​Goodfellas”
		WebElement selection = driver.findElement(By.xpath("//div[text()='Goodfellas']"));
		selection.click();
		Thread.sleep(6000);

		driver.quit();
		System.out.println("Driver closed");
	}
}
