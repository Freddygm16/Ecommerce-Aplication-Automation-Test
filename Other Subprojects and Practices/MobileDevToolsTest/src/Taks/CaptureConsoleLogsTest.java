package Taks;

import java.net.URI;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v147.network.Network;
import org.openqa.selenium.devtools.v147.network.model.ConnectionType;
import org.openqa.selenium.devtools.v147.network.model.NetworkConditions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

public class CaptureConsoleLogsTest {
	
	@Test
	public void CaptureConsoleLogsCase() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector("p > a[routerlink=\"/products\"]")).click();
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		driver.findElement(By.cssSelector("button[class=\"add-to-cart btn btn-default\"]")).click();
		driver.findElement(By.cssSelector("a[routerlink=\"/cart\"]")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = logEntries.getAll();
		
		for (LogEntry logEntry : logs) {
			System.out.println(logEntry.getMessage());
		};
		
		
		driver.quit();


	}
	
}
