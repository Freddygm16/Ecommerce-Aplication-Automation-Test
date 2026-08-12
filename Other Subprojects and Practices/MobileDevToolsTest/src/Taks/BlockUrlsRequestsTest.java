package Taks;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v146.fetch.Fetch;
import org.openqa.selenium.devtools.v146.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v147.network.model.BlockPattern;
import org.openqa.selenium.devtools.v146.network.model.ErrorReason;
import org.openqa.selenium.devtools.v147.network.Network;
import org.testng.annotations.Test;

public class BlockUrlsRequestsTest {
	@Test
	public void BlockUrlsRequestsCase() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		DevTools tools = driver.getDevTools();

		tools.createSession();
		
		Optional<List<BlockPattern>> urlsblock = Optional.of(Arrays.asList(new BlockPattern("*://*:*/*.jpg", true), new BlockPattern("*://*:*/*.css", true)));		
		long initailtime = System.currentTimeMillis(); 
		
		tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		tools.send(Network.setBlockedURLs(urlsblock, Optional.empty()));
		
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector("p > a[routerlink=\"/products\"]")).click();
		
		long endtime = System.currentTimeMillis();
		
		System.out.println("Time execution: " + (endtime - initailtime));

	}
}
