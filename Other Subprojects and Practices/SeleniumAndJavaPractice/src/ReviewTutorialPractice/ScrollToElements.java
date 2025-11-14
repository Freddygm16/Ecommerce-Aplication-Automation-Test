package ReviewTutorialPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollToElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Write a code that move de scroll of the page, an move scroll within elements
		// TODO Managed the table elemnt in the page, slected the specifified table that contains amout column, then, plus the all vloues prest in the column, finally compared this total whitthe text below of the table that indicated "Total Amount Collected"
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);

		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,500)");
	
		//.tableFixHead td:nth-child(4)
		List<WebElement> amouts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (WebElement a : amouts) {
			sum = sum + Integer.parseInt(a.getText());	
		}
		System.out.println(sum);
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum,total);
		
		driver.quit();
	
	}

}
