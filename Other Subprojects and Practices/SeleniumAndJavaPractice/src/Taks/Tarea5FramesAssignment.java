package Taks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tarea5FramesAssignment {

	public static void main(String[] args) {
		// TODO: Ensure Selenium handles multiple frames on the page, selects the middle frame, and prints the text contained within it.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");

		
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		

	    driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));

	    System.out.println(driver.findElement(By.id("content")).getText());
	    
	    // TODO: Write code that counts the number of links present in the page
		
	    
	    // TODO: Write code that counts the number of links present only in the footer section. This achieves a limited scope.
	    
	    
	    // TODO: Write code that prints the total number of links present in the first column of the footer section, then dynamically clicks on each of them (Open the links in another tab), and finally, print de title of the pages will be open.
	    
	    

	    
	}

}
