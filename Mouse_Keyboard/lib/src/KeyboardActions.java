package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class KeyboardActions {
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
        // Mazimize current window
        driver.manage().window().maximize();

        // create an object of action class
        Actions actions = new Actions(driver);

        // // Press the TAB Key to switch focus to next field
        // actions.sendKeys(Keys.TAB);

        // Navigate to https://web-locators-static-site-qa.vercel.app
        driver.get("https://web-locators-static-site-qa.vercel.app");

        // Click on the “Keyboard Operations” button
        WebElement keyBtn = driver.findElement(By.xpath("//p[text()='Keyboard Operations']"));
        actions.click(keyBtn).perform();
        Thread.sleep(2000);

        // Use tab to fill the name, email id and phone number fields with these data
        //name box
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name of  the user']"));
        name.sendKeys("username");
        Thread.sleep(2000);

        //email values 
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='example@example.com']"));
        email.sendKeys("username@gmail.com");
        Thread.sleep(2000);

        //phone number
        WebElement phoneNo = driver.findElement(By.xpath("//input[@type='number']"));
        phoneNo.sendKeys("9999900000");
        Thread.sleep(2000);

        driver.quit();
        System.out.println("Driver closed");
    }
}
