package ReviewTutorialPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TraverseXpathHelpers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		// TODO Write the same xpath travers but "parent::" selector
		System.out.print(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		driver.quit();
	}

}
