package ReviewTutorialPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ManagedInframes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Write that allow managed iframe elements. 
		// Within these iframes, enable drag-and-drop actions. 
		// Afterwards, switch to the default page or the parent page.

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		//demo-frame
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		Actions a = new Actions(driver);	
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[normalize-space()='Accept']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
