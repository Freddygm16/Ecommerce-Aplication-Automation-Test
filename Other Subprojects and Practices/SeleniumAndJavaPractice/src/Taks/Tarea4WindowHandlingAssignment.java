package Taks;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tarea4WindowHandlingAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.cssSelector("div.example a[target='_blank']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parendId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		
		driver.switchTo().window(parendId);
		
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
	
		
	}

}
