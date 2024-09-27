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

public class MultipleKeys {
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
        // navigate to url
        driver.get("https://web-locators-static-site-qa.vercel.app");

        Actions actions = new Actions(driver);

        // Click on the “Keyboard Operations” button
        WebElement keyboardAct = driver.findElement(By.xpath("//p[text()='Keyboard Operations']"));
        actions.click(keyboardAct).perform();

        // Copy the text in the input field under the Copy text by pressing “Ctrl + C”’ section by
        // first clicking on the input field and then using “Ctrl + C” to copy the text
        WebElement copyTheText = driver
                .findElement(By.xpath("//div[text()='Copy me and paste me in the below box']"));

        // Performing copy operation
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        // Press the TAB Key to Switch Focus to next field
        actions.sendKeys(Keys.TAB);
        Thread.sleep(2000);

        WebElement pasteTheText = driver.findElement(By.xpath("//input[@type='text'][2]"));
        // Performing paste operation
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(5000);

        driver.quit();
        System.out.println("Driver closed");
    }
}
