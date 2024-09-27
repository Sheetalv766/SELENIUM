package seleniumWebActions.webActions;

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

public class WebElementAction {
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

		System.out.println("");
		driver.manage().window().maximize();
	}

	/**
	 * use this method to get text
	 * 
	 * @return
	 */
	public String getLoginBtnText() {
		String text = null;

		// TODO : get the text on login button
		System.out.println("Get text on Login Button : ");
		WebElement logInButton = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/button"));
		text = logInButton.getText();


		return text;
	}

	/**
	 * use this method to perform click on button
	 */ 
	public void clickOnLoginBtn() {
		// TODO : click on login button
		WebElement clickOnButton = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/button"));
		clickOnButton.click();

	}

	/**
	 * use this method to enter user name
	 * 
	 * @param userName
	 */
	public void enterUserName(String userName) {
		// TODO : enter username "admin"
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys(userName);

	}

	/**
	 * use this method to enter password
	 * 
	 * @param password
	 */
	public void enterPassWord(String password) {
		// TODO : enter password "admin"
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(password);

	}

	/**
	 * use this method to click on LOGIN TO QKART button
	 */
	public void clickOnLoginToQKart() {
		// TODO : click on "LOGIN TO QKART"
		WebElement logInToQkart = driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/button"));
		logInToQkart.click();

	}

	/**
	 * use this method to close the current window of browser
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser window");
		driver.close();
	}

	public void run() throws MalformedURLException {

		WebElementAction actions = new WebElementAction();
		
		// TODO: Call the method startBrowser
		actions.startBrowser();

		// TODO: Call the method openURL
		actions.openURL("https://crio-qkart-frontend-qa.vercel.app/login");

		// TODO: Call the method getLoginBtnText
		actions.getLoginBtnText();

		// TODO: Call the method clickOnLoginBtn
		actions.clickOnLoginBtn();

		// TODO: Call the method enterUserName
		actions.enterUserName("username");

		// TODO: Call the method enterPassWord
		actions.enterPassWord("password");		

		// TODO: Call the method clickOnLoginToQKart
		actions.clickOnLoginToQKart();

		// TODO: Call the method closeBrowser
		actions.closeBrowser();

	}
}
