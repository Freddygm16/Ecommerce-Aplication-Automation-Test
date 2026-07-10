package Taks;

import java.time.Duration;
import java.util.LinkedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

public class MobileDevToolsCommandTest {
	
	@Test
	public void MovileDevToolsTest() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		DevTools tools = driver.getDevTools();

		tools.createSession();
		
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("width", 412);
        params.put("height", 900);
        params.put("deviceScaleFactor", 1);
        params.put("mobile", true);
        
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", params);
		
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector("button[data-target=\"#navbarSupportedContent\"] > span")).click();

		driver.findElement(By.cssSelector("#navbarSupportedContent > ul > li:nth-child(2) > a")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}
}
