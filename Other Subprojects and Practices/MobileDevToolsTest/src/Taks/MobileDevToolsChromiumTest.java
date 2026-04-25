package Taks;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MobileDevToolsChromiumTest {
	
	@Test
	public void MovileDevToolsTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

	}
}
