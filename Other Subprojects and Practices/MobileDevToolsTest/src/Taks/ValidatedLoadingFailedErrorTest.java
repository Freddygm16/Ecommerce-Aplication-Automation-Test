package Taks;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v147.network.Network;
import org.openqa.selenium.devtools.v147.network.model.ConnectionType;
import org.testng.annotations.Test;

public class ValidatedLoadingFailedErrorTest {
	@Test
	public void ValidatedLoadingFailedErrorCase() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		DevTools tools = driver.getDevTools();

		tools.createSession();

		tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

		tools.send(Network.emulateNetworkConditions(true, 3000, 10000, 30000, Optional.of(ConnectionType.ETHERNET), Optional.empty(), Optional.empty(), Optional.empty()));
		
		tools.addListener(Network.loadingFailed(), loadingFailed ->{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		
		long initailtime = System.currentTimeMillis(); 
				
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector("p > a[routerlink=\"/products\"]")).click();
		
		long endtime = System.currentTimeMillis();
		
		System.out.println("Time execution: " + (endtime - initailtime));

	}
}
