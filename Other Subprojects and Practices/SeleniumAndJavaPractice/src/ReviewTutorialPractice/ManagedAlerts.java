package ReviewTutorialPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagedAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO: Write code that allows handling browser alerts when clicking either the "Accept" button or the "Cancel" button.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Freddy");
	
		driver.findElement(By.id("alertbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
	}

}
