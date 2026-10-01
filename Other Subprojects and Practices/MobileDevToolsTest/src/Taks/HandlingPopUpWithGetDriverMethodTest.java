package Taks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

public class HandlingPopUpWithGetDriverMethodTest {
	@Test
	public void CaptureConsoleLogsCase() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
	}
	
}
