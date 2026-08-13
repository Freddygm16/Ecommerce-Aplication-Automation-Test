package Taks;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v147.network.Network;
import org.openqa.selenium.devtools.v147.network.model.BlockPattern;
import org.openqa.selenium.devtools.v147.network.model.ConnectionType;
import org.openqa.selenium.devtools.v147.network.model.NetworkConditions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

public class NetworkSpeedEmulated {

	@Test
	public void NetworkSpeedEmulatedCase() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		DevTools tools = driver.getDevTools();

		tools.createSession();

		tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty()));

		// Decreated method
		// tools.send(Network.emulateNetworkConditions(false, 3000, 10000, 30000,
		// Optional.of(ConnectionType.ETHERNET), Optional.empty(), Optional.empty(),
		// Optional.empty()));

		// java.util.List<org.openqa.selenium.devtools.v147.network.model.NetworkConditions>

		List<NetworkConditions> networkConditions = Arrays.asList(new NetworkConditions("", 3000, 10000, 30000,
				Optional.of(ConnectionType.ETHERNET), Optional.empty(), Optional.empty(), Optional.empty()));

		tools.send(Network.emulateNetworkConditionsByRule(false, networkConditions));

		long initailtime = System.currentTimeMillis();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector("p > a[routerlink=\"/products\"]")).click();
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		driver.findElement(By.cssSelector("button[class=\"add-to-cart btn btn-default\"]")).click();
		driver.findElement(By.cssSelector("a[routerlink=\"/cart\"]")).click();


		long endtime = System.currentTimeMillis();

		System.out.println("Time execution: " + (endtime - initailtime));

	}
}
