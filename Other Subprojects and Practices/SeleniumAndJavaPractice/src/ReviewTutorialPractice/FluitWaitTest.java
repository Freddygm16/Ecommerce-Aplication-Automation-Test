package ReviewTutorialPractice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluitWaitTest {

	public static void main(String[] args) {
		// TODO> Write a code that implement fluit wait methot
		System.setProperty("webdriver.edge.driver", "C:\\Web Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		
		@SuppressWarnings("unused")
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));	
				}else {
					return null;
				}
			}
			
		});
		
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed());
		
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
		
		driver.quit();
	}

}
