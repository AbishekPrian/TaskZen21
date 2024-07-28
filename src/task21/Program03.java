package task21;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program03 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.manage().window().maximize();
		// navigate to URL
		d.get("https://the-internet.herokuapp.com/nested_frames");

		// Switch to Top frame
		WebElement topFrame = d.findElement(By.xpath("//frame[@name='frame-top']"));
		d.switchTo().frame(topFrame);

		// Verify that there are three frames on the page
		List<WebElement> frameCount = d.findElements(By.tagName("frame"));
		if (frameCount.size() == 3)
			System.out.println("Three frames are available");
		else
			System.out.println("Available frames are " + frameCount.size());

		// Switch to left frame
		WebElement leftFrame = d.findElement(By.name("frame-left"));
		d.switchTo().frame(leftFrame);
		System.out.println("Switched to left Frame");

		// Verify that left frame has the text "LEFT"
		WebElement leftFrame1 = d.findElement(By.xpath("//body[contains(.,'LEFT')]"));
		if (leftFrame1.getText().equals("LEFT"))
			System.out.println("Left frame text = LEFT");
		else
			System.out.println("Left frame does not have the text LEFT");

		// Switch to top frame
		d.switchTo().defaultContent();
		d.switchTo().frame(topFrame);
		System.out.println("Switched from left Frame to Top frame");

		// Switch to middle frame
		WebElement middleFrameElement = d.findElement(By.xpath("//frame[2]"));
		d.switchTo().frame(middleFrameElement);
		System.out.println("Switched to middle Frame");

		//// Verify that middle frame has the text "MIDDLE"
		WebElement middleBodyFrameElement = d.findElement(By.xpath("//body/div[@id='content']"));
		if (middleBodyFrameElement.getText().equals("MIDDLE"))
			System.out.println("Middle frame text = MIDDLE");
		else
			System.out.println("Middle frame does not have the text MIDDLE");

		// Switch back to top frame
		d.switchTo().defaultContent();
		d.switchTo().frame(topFrame);
		System.out.println("Switched from middle Frame to Top frame");

		// Switch to right frame
		WebElement rightFrameElement = d.findElement(By.xpath("//frame[@name='frame-right']"));
		d.switchTo().frame(rightFrameElement);
		System.out.println("Switched to right Frame");

		// Verify that right frame has the text "RIGHT"
		WebElement rightBodyFrameElement = d.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
		if (rightBodyFrameElement.getText().equals("RIGHT"))
			System.out.println("Right frame text = RIGHT");
		else
			System.out.println("Right frame does not have the text RIGHT");

		// Switch back to top frame
		d.switchTo().defaultContent();
		System.out.println("Switched from right Frame to Top frame");

		// Switch to bottom frame
		WebElement bottomFrameElement = d.findElement(By.xpath("//frame[2]"));
		d.switchTo().frame(bottomFrameElement);
		// d.switchTo().frame("frame-bottom");
		System.out.println("Switched to bottom Frame");

		// Verify that bottom frame has the text "BOTTOM"
		WebElement bottomFrame = d.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
		if (bottomFrame.getText().equals("BOTTOM"))
			System.out.println("Bottom frame text = BOTTOM");
		else
			System.out.println("Bottom frame does not have the text BOTTOM");

		// Switch to top frame
		d.switchTo().defaultContent();
		System.out.println("Switched from bottom Frame to top frame");

		// Verify that page title is "Frames"
		d.switchTo().defaultContent();
		if (d.getTitle().equals("Frames"))
			System.out.println("page title is Frames");
		else
			System.out.println("Page title is not Frames");

		// Close the browser
		d.close();

	}

}
