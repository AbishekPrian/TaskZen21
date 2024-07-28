package task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program02 {

 public static void main(String[] args) throws InterruptedException {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
  
  //Navigate to the URL
     driver.get("https://the-internet.herokuapp.com/windows");
     driver.manage().window().maximize();
     Thread.sleep(1000);
     
     //Click on "CLICKHERE" link 
     driver.findElement(By.xpath("//a[.='Click Here']")).click();

     // main window handle
     String mainwindow=driver.getWindowHandle();
     //System.out.println(mainWindow);

     //Switch to Child window
     for(String windowHandle:driver.getWindowHandles()) {
      //System.out.println(windowHandle);
      driver.switchTo().window(windowHandle);
     }

     //Verify the child window message

     WebElement childWindowTitle=driver.findElement(By.xpath("//h3"));
     if(childWindowTitle.getText().equals("New Window"))
      System.out.println("Child window has a text - "+ childWindowTitle.getText());
     else
      System.out.println("Child window does not have a text - "+ childWindowTitle.getText());

     //Close the child window
     driver.close();

     //Switch to Main window
     driver.switchTo().window(driver.getWindowHandles().iterator().next());
     // driver.switchTo().window(mainWindow);

     //Verify the main window message
     WebElement mainWindowTitle=driver.findElement(By.xpath("//h3[.='Opening a new window']"));
     if(mainWindowTitle.getText().equals("Opening a new window"))
      System.out.println("Main window text - "+ mainWindowTitle.getText());
     else
      System.out.println("Main window have no text - "+ mainWindowTitle.getText());

     //Close the main window
     driver.close();
 }

}