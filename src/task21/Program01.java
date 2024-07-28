package task21;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program01 {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            //Open Chrome browser
            driver.manage().window().maximize();

            //Navigate to the URL
            driver.get("https://the-internet.herokuapp.com/iframe");
           
            // Switch to the iframe using CSS Selector or XPath
            WebElement frm = driver.findElement(By.cssSelector("#mce_0_ifr"));
            driver.switchTo().frame(frm);
            Thread.sleep(10000);
            //Locate the "p" tag inside the iframe and write the text "Hello People"
            WebElement pTag = driver.findElement(By.cssSelector("#tinymce p"));
            pTag.clear(); // Clear any existing text in the p tag
            pTag.sendKeys("Hello People");
            Thread.sleep(3000);
            //Switch back to the default content if needed
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close the browser instance
            driver.quit();
        }
    }
}
