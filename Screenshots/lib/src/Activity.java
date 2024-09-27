package webActions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Activity {

	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 */
	public WebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);

		// TODO - Milestone 5 Activity 1- Add configuration for headless mode
		// Configure driver to start as headless

		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

		return driver;
	}

	public static void takeScreenshot(WebDriver driver, String screenshotType, String description) {
		try {
			File theDir = new File("/screenshots");
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			String timestamp = String.valueOf(java.time.LocalDateTime.now());
			String fileName = String.format("screenshot_%s_%s_%s.png", timestamp, screenshotType, description);

			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			File DestFile = new File("screenshots/" + fileName);
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testFullPageScreenshot(WebDriver driver) {
		driver.get("https://web-locators-static-site-qa.vercel.app/Screenshot");
		WebElement AUTButton = driver.findElement(By.xpath("//a[@href='https://www.crio.do/']"));
		AUTButton.click();
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File("FullPageScreenshot.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void snippet_4_1(WebDriver driver) throws InterruptedException {
		// TODO
		driver.get("https://www.howtocodeschool.com/2021/10/demo-display-current-date-and-time-html-javascript.html");

		for(int i = 0; i < 5; i++) {
		Thread.sleep(5000);
		takeScreenshot(driver, "snippet_4_1", String.valueOf(i));
		}
	}

	public static WebDriver snippet_5_1(WebDriver driver) {
		// TODO
	
		// code of headless browser start
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		// “capabilities” is a “DesiredCapabilities” object
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	
		return driver;
	}
	
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException, ParseException {

		// Create the object of Activity class
		Activity activity = new Activity();

		// Start the browser
		WebDriver driver = activity.startBrowser();

		// Uncomment for Milestone 3 Activity 1
		// testFullPageScreenshot(driver);

		// Uncomment for Milestone 4 Activity 1
		// snippet_4_1(driver);

		// Uncomment for Milestone 5 Activity 1
		snippet_5_1(driver);

	}

}
