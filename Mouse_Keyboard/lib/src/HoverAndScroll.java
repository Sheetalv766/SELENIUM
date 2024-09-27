package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HoverAndScroll {
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

        // Navigate to https://web-locators-static-site-qa.vercel.app
        driver.get("https://web-locators-static-site-qa.vercel.app");

        // Click on the mouse button
        WebElement clickOnMouse = driver.findElement(By.xpath("//p[text()='Mouse']"));
        clickOnMouse.click();
        Thread.sleep(2000);

        // Scroll down the page.
        
        WebElement pwd = driver.findElement(By.xpath("//input[@type='password'][1]"));
        // Create an object of JavascriptExecutor class
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", pwd);
        Thread.sleep(2000);

        //moveToElement
        actions.moveToElement(pwd).perform();
        Thread.sleep(2000);

        driver.quit();
        System.out.println("Driver closed");
    }
}
