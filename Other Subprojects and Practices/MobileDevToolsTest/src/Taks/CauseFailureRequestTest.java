package Taks;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v146.fetch.Fetch;
import org.openqa.selenium.devtools.v146.fetch.model.RequestId;
import org.openqa.selenium.devtools.v146.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v146.network.model.ErrorReason;
import org.testng.annotations.Test;

public class CauseFailureRequestTest {
	@Test
	public void CauseFailureRequestCase() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		DevTools tools = driver.getDevTools();

		tools.createSession();
		
	    Optional<List<RequestPattern>> patters = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBoo.php*"), Optional.empty(), Optional.empty())));

		tools.send(Fetch.enable(patters, Optional.empty()));
		

		tools.addListener(Fetch.requestPaused(), request -> {
			
			tools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
		
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector("button[routerlink=\"/library\"]")).click();
		
		
	}
}
