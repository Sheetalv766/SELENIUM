package webActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity {

	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 */
	public WebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

		return driver;
	}

	public static void snippet_2_2(WebDriver driver) throws InterruptedException {
		// TODO

		//FIRST ALERT BUTTON

		//visit this url
		driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");

		//Click on the “Show Alert” button
		WebElement showAlertButton = driver.findElement(By.xpath("//p[text()='Show Alert']"));
		showAlertButton.click();

		//synchronization issue
		Thread.sleep(3000);

		driver.switchTo().alert().accept();

		//SECOND ALERT BUTTON

		//Click on the “Show Agreement” button
		WebElement showAgreementButton = driver.findElement(By.xpath("//p[text()='Show Agreement']"));
		showAgreementButton.click();

		Thread.sleep(3000);

		driver.switchTo().alert().accept();

		//THIRD ALERT BUTTON
		WebElement addRemarksButton = driver.findElement(By.xpath("//p[text()='Add Remarks']"));
		addRemarksButton.click();

		Thread.sleep(3000);

		driver.switchTo().alert().sendKeys("Adding Remarks to Alert");
		driver.switchTo().alert().accept();
		//accept --> clicking on button 'OK'

		if(addRemarksButton.isDisplayed()){
			System.out.println("snippet_2_2 : Remark found");
		}else{
			System.out.println("snippet_2_2 : Remark not found");
		}

	}

	public static void snippet_3_2(WebDriver driver) {
		// TODO
		
		//visit the url
		driver.get(" https://web-locators-static-site-qa.vercel.app/Alerts");

		//click on Proceed to Agreement button
		WebElement proceedToAgreementButton = driver.findElement(By.xpath("//p[text()='Proceed to Agreement']"));
		proceedToAgreementButton.click();

		WebElement agreeButton = driver.findElement(By.xpath("//button[text()='Agree']"));
		agreeButton.click();

		WebElement verificationContent = driver.findElement(By.xpath("//p[text()='You have successfully shown Agreement.']"));

		if(verificationContent.getText().equals("You have successfully shown Agreement.")){
			System.out.println("snippet_3_2 : success");
		}else{
			System.out.println("snippet_3_2 : fails");
		}
	}

	public static void snippet_5_2(WebDriver driver) {
		// TODO
		//visit url
		//step 1
		driver.get("https://web-locators-static-site-qa.vercel.app/Frames");

		//step 2
		WebElement frameElement = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/iframe[1]"));
		driver.switchTo().frame(frameElement);

		//step 3
		WebElement checkBoxButton = driver.findElement(By.xpath(("/html/body/div/div/div/div/div[1]/div/input")));
		checkBoxButton.click();

		//step 4 switch back to parent page
		driver.switchTo().parentFrame();

	}

	public static void snippet_7_2(WebDriver driver) {
		driver.get("https://crio-qkart-frontend-qa.vercel.app/login");

		String[] urlArray = { "https://www.android.com/intl/en_in/", "https://www.amazon.in/ref=nav_logo",
				"https://www.google.com/", "https://www.netflix.com/in/", "https://www.redbus.in/",
				"https://in.bookmyshow.com/", "https://www.tesla.com/", "https://www.apple.com/",
				"https://www.flipkart.com/", "https://en.wikipedia.org/wiki/Main_Page" };

		JavascriptExecutor jscript = (JavascriptExecutor) driver;
		for (int i = 0; i < urlArray.length; i++) {
			jscript.executeScript("window.open('" + urlArray[i] + "');");

		}

		// TODO: Add Code to Print all the window handles of this Driver object
		Set<String> x = driver.getWindowHandles();
		for(String y : x){
			System.out.println(y);
		}
	}

	public static void snippet_7_3(WebDriver driver) throws InterruptedException {
		// TODO
		//visit url
		driver.get("https://web-locators-static-site-qa.vercel.app/Windows");

		String mainWindowHandle = driver.getWindowHandle();

		//find and click on launch multiple windows button
		WebElement launchMultipleWindowButton = driver.findElement(By.xpath("//p[text()='Launch Multiple Windows']"));
		launchMultipleWindowButton.click();

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.unitl(ExpectedConditions.presenceOfElemntLocated);
		Thread.sleep(3000);

		//all the windows handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		//close all the new open windows but not the main window
		for(String handle : allWindowHandles){

			//if it is not --> switch it --> close it
			if(!handle.equals(mainWindowHandle)){
				driver.switchTo().window(handle);

				//after switching --> synchronization issue 
				Thread.sleep(3000);
				driver.close();
			}
		}
		//then return back to main window
		driver.switchTo().window(mainWindowHandle);
		
	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException, ParseException {

		// Create the object of Activity class
		Activity activity = new Activity();

		// Start the browser
		WebDriver driver = activity.startBrowser();

		// Uncomment for Milestone 2 Activity 2
		// snippet_2_2(driver);

		// Uncomment for Milestone 3 Activity 2
		// snippet_3_2(driver);

		// Uncomment for Milestone 5 Activity 2
		// snippet_5_2(driver);

		// Uncomment for Milestone 7 Activity 2
		// snippet_7_2(driver);

		// Uncomment for Milestone 7 Activity 3
		snippet_7_3(driver);
	}

}
