package ReviewTutorialPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveWithActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO: Write code to simulate moving the mouse over a DOM element
		// TODO: Write a code that allow type with capital letters and use right click, and finally allow select completed text for example with double click
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com");
		
		driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Continue shopping')]")).click();
		
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		
		a.moveToElement(driver.findElement(By.xpath("//div[@id='nav-link-accountList']//a[contains(@class,'nav-progressive-attribute')]"))).contextClick().build().perform();
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
