package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Drag {

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

        // Click on the “Mouse” button
        WebElement mouseBtn = driver.findElement(By.xpath("//p[text()='Mouse']"));
        actions.click(mouseBtn).perform();
        Thread.sleep(2000);

        // Perform drag around on the designed element
        WebElement drag = driver.findElement(By.xpath("//div[contains(text(),'Drag me around')]"));
        actions.clickAndHold(drag).perform();
        Thread.sleep(2000);

        // Perform the drag on the element within the boundaries and drop it inside the target
        // element

        // Locating the web elements
        WebElement dragElem = driver.findElement(By.xpath("//div[text()='Drag me around']"));

        // Perform drag around
        actions.dragAndDropBy(dragElem, 100, 100);

        WebElement targetElem = driver.findElement(By.xpath("//div[text()='Drag me to target']"));

        WebElement dest = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]"));

        // Perform drag and drop
        actions.dragAndDrop(targetElem, dest).build().perform();
        Thread.sleep(2000);

        // Creating an object of JavascriptExecutor Class
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement scroll = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[6]/div[1]"));
        js.executeScript("arguments[0].scrollIntoView();", scroll);

        // To reorder rows in table
        // Identifying rows in table
        WebElement row1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[2]/div[1]"));

        WebElement row4 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[5]/div[1]"));

        // To perform reorder of the rows
        Action dragAndDrop = actions.clickAndHold(row1).moveToElement(row4).release(row4).build();
        dragAndDrop.perform();

        Thread.sleep(4000);

        // To reorder rows in table
        WebElement row2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[3]/div[1]"));
        WebElement row5 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div[2]/div/div[6]/div[1]"));

        Action dragAndDrop1 = actions.clickAndHold(row2).moveToElement(row5).release(row5).build();
        dragAndDrop1.perform();
        Thread.sleep(10000);

        // Closing the browser
        driver.quit();

    }
}
