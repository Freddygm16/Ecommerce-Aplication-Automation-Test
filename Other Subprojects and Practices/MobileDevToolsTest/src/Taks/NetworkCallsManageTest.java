package Taks;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v147.fetch.Fetch;
import org.openqa.selenium.devtools.v147.network.Network;
import org.testng.annotations.Test;

public class NetworkCallsManageTest {
	@Test
	public void MovileDevToolsTest() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		DevTools tools = driver.getDevTools();
		tools.createSession();
		
		tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		tools.addListener(Network.requestWillBeSent(),  request -> {
			System.out.println("Resquest:" + request.getRequest().getUrl());
			System.out.println("Resquest:" + request.getRequest().getHeaders());

		});
		
		tools.addListener(Network.responseReceived(), respose -> {
			System.out.println(respose.getResponse().getUrl());
			System.out.println(respose.getResponse().getStatus());
			
			if (respose.getResponse().getStatus().toString().startsWith("4")) {
				System.out.println(respose.getResponse().getStatus());
			}
						
		});
		
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		
		driver.quit();
		
	}
}
